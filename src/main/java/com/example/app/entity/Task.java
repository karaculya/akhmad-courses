package com.example.app.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.File;

@Entity
@Getter
@Setter
@Table
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String taskName;
    private String benchmarkData;
    private File templateFile;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;
    @OneToOne
    private TaskResult result;
}
