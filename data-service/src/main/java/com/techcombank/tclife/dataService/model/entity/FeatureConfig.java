package com.techcombank.tclife.dataService.model.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "feature_config",
        uniqueConstraints = @UniqueConstraint(columnNames = {"feature_name", "scope"}))
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@Builder
public class FeatureConfig {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "feature_name", nullable = false)
    private String featureName;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Column(nullable = false)
    private String scope = "global"; // e.g., global, user, group, VN only, EN only

    @Column(name = "is_enabled", nullable = false)
    private boolean isEnabled = false;

    @Column(columnDefinition = "jsonb")
    private String config;

    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
}
