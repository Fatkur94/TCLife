package com.techcombank.tclife.dataService.service;

import com.techcombank.tclife.dataService.model.dto.UserAccessDTO;
import com.techcombank.tclife.dataService.model.entity.User;
import com.techcombank.tclife.dataService.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AccessRoleServiceImpl implements AccessRoleService {

    private final UserRepository userRepository;

    private final RedisService redisService;

    private static final String REDIS_PREFIX = "userAccess:";

    @Override
    public UserAccessDTO getUserAccessByCognitoSub(UUID sub) {
        String redisKey = REDIS_PREFIX + sub.toString();

        UserAccessDTO cached = redisService.getData(redisKey, UserAccessDTO.class);
        if (cached != null) return cached;

        User user = userRepository.findByCognitoSub(sub)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));

        List<String> permissions = user.getUserRole().getAccessRoles().stream()
                .map(ar -> ar.getResource() + ":" + ar.getAction())
                .toList();

        UserAccessDTO dto = new UserAccessDTO(
                user.getId(),
                user.getCognitoSub(),
                user.getEmail(),
                user.getUserRole().getName(),
                permissions
        );

        // TODO : the value should be moved to a centralized place.
        redisService.saveData(redisKey, dto, Duration.ofMinutes(60));
        return dto;
    }
}


