package com.example.app.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.util.List;

@Entity
@Getter
@Setter
@Table
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String courseName;
    private String description;
    @ManyToOne
    @JoinColumn(name = "professor_id")
    private Professor professor;
    @OneToMany(mappedBy = "course", fetch = FetchType.LAZY)
    @Fetch(FetchMode.SUBSELECT)
    private List<Student> students;
    @OneToMany(mappedBy = "course", fetch = FetchType.LAZY)
    private List<Test> tests;
    @OneToOne
    private CourseResult result;

}