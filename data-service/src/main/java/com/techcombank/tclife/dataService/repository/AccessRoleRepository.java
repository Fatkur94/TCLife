package com.techcombank.tclife.dataService.repository;

import com.techcombank.tclife.dataService.model.entity.AccessRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface AccessRoleRepository extends JpaRepository<AccessRole, UUID> {
    List<AccessRole> findByRoleId(UUID roleId);
}
