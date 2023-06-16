package com.example.app.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    @JsonIgnore
    @OneToOne
    @JoinColumn(name = "task_id")
    private Task task;
    @JsonIgnore
    @ManyToOne
    private CourseResult result;
}
