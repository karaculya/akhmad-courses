package com.example.app.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table
public class TestResult {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int mark;
    @OneToOne
    @JoinColumn(name = "test_id")
    private Test test;
    @ManyToOne
    private CourseResult courseResult;
}