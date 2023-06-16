package com.example.app.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

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
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;
    @OneToMany(mappedBy = "course_result")
    private Set<TaskResult> taskResults;
    @OneToMany(mappedBy = "course_result")
    private Set<TestResult> testResults;

}
