package com.example.app.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table
public class TaskResult {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int mark;
    @OneToOne
    @JoinColumn(name = "task_id")
    private Task task;
    @ManyToOne
    private CourseResult courseResult;
}