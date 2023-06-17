package com.example.app.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.util.List;
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
    private Professor professor;
    @OneToMany(mappedBy = "course", fetch = FetchType.EAGER)
    @Fetch(FetchMode.JOIN)
    private List<Student> students;
    @OneToMany(mappedBy = "course", fetch = FetchType.EAGER)
    @Fetch(FetchMode.JOIN)
    private List<Lesson> lessons;
    @JsonIgnore
    @OneToMany(mappedBy = "course")
    private Set<Task> tasks;
    @JsonIgnore
    @OneToMany(mappedBy = "course")
    private Set<Test> tests;
    @JsonIgnore
    @OneToOne
    private CourseResult result;

}
