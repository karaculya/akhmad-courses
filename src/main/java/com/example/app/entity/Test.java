package com.example.app.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table
public class Test {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
//    private List<String> answerOptions;
//    private List<String> questions;
    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;
    @OneToOne
    private TestResult result;
}