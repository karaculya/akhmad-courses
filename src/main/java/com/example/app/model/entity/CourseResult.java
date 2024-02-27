package com.example.app.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@Table
public class CourseResult {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int mark;
    @OneToOne
    private Course course;
    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;
    @OneToMany(mappedBy = "courseResult")
    private List<TestResult> testResults;

}