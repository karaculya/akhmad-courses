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
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String courseName;
    private String description;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "professor_id")
    private Professor author;
    @OneToMany(mappedBy = "course")
    private Set<Student> students;
    @OneToMany(mappedBy = "course")
    private Set<Lesson> lessons;
    @OneToMany(mappedBy = "course")
    private Set<Task> tasks;
    @OneToMany(mappedBy = "course")
    private Set<Test> tests;
    @JsonIgnore
    @OneToOne
    private CourseResult result;

}
