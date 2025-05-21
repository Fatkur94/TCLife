package com.techcombank.tclife.dataService.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "goal_question_options")
@Setter @Getter
public class GoalQuestionOption {

    @Id
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "question_id", nullable = false)
    private GoalQuestion question;

    private String value;

    private String label;

    @Column(name = "sort_order")
    private int sortOrder = 0;
}