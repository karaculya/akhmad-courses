package com.example.app.model.dto;

import com.example.app.model.entity.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProfessorDto {
    private Long id;
    private String fio;
    private String email;
    private Professor professor;
    private List<Student> students;
    private List<Lesson> lessons;
    private List<Test> tests;
    private CourseResult result;
}
