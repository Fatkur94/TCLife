package com.techcombank.tclife.dataService.repository;

import com.techcombank.tclife.dataService.model.entity.AccessRole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface AccessRoleRepository extends JpaRepository<AccessRole, UUID> {
    List<AccessRole> findByRoleId(UUID roleId);
}
