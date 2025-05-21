package com.techcombank.tclife.dataService.model.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "goals")
@Setter
@Getter
public class Goal {
    @Id
    private UUID id;

    @Column(nullable = false)
    private String title;

    private String description;

    @Column(name = "image_url")
    private String imageUrl;

    @Column(name = "is_active")
    private boolean isActive;

    @OneToMany(mappedBy = "goal", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<GoalQuestion> questions;
}
