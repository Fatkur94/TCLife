package com.techcombank.tclife.dataService.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@NoArgsConstructor
@Setter @Getter
public class GoalSummary {
    private UUID id;
    private String title;
    private String description;
    private String imageUrl;

    public GoalSummary(UUID id, String title, String description, String imageUrl) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.imageUrl = imageUrl;
    }
}
