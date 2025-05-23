package com.techcombank.tclife.authService.middleware;

import com.techcombank.tclife.dataService.model.entity.AccessRole;
import com.techcombank.tclife.dataService.model.entity.User;
import com.techcombank.tclife.dataService.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.core.convert.converter.Converter;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.stereotype.Component;


import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class CustomJwtAuthenticationConverter implements Converter<Jwt, AbstractAuthenticationToken> {

    private final UserRepository userRepository;

    @Override
    public AbstractAuthenticationToken convert(Jwt jwtSource) {
        UUID cognitoSub = UUID.fromString(jwtSource.getSubject());

        User user = userRepository.findByCognitoSub(cognitoSub).orElseThrow(() -> new UsernameNotFoundException("User not found"));

        List<AccessRole> accessRoles = user.getUserRole().getAccessRoles();
        List<GrantedAuthority> authorities = accessRoles.stream()
                .map(ar -> new SimpleGrantedAuthority(ar.getResource() + ":" + ar.getAction()))
                .collect(Collectors.toList());

        return new JwtAuthenticationToken(jwtSource, authorities);
    }
}
