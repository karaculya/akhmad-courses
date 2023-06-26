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
public class Lesson {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String lessonName;
    private String description;
    private File lessonFile;
    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;

}
