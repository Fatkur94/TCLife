package com.techcombank.tclife.dataService.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "user_role")
@NoArgsConstructor
@Setter @Getter
public class UserRole {

    @Id
    @GeneratedValue
    @Column(columnDefinition = "UUID", updatable = false, nullable = false)
    private UUID id;

    @Column(nullable = false)
    private String name;

    private String description;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt = LocalDateTime.now();

    private LocalDateTime updatedAt;
    private String createdBy;
    private String updatedBy;
    private LocalDateTime deletedAt;

    @OneToMany(mappedBy = "userRole", fetch = FetchType.LAZY)
    private List<User> users;

    @OneToMany(mappedBy = "role", fetch = FetchType.LAZY)
    private List<AccessRole> accessRoles;
}

