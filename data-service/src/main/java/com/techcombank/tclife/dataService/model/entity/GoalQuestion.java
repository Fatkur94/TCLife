package com.techcombank.tclife.dataService.model.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "goal_questions")
public class GoalQuestion {

    @Id
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "goal_id", nullable = false)
    private Goal goal;

    @ManyToOne
    @JoinColumn(name = "parent_question_id")
    private GoalQuestion parentQuestion;

    @OneToMany(mappedBy = "parentQuestion", cascade = CascadeType.ALL)
    private List<GoalQuestion> subQuestions;

    @Column(nullable = false)
    private String title;

    private String description;

    private String type;

    @Column(name = "input_name")
    private String inputName;

    private String regex;

    @Column(name = "is_repeatable")
    private boolean isRepeatable = false;

    @Column(name = "is_required")
    private boolean isRequired = false;

    @Column(name = "is_active")
    private boolean isActive = false;

    @OneToMany(mappedBy = "question", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<GoalQuestionOption> options;
}