package com.example.app.dto;

import com.example.app.entity.Course;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProfessorDto {
    private Long id;
    private String fio;
    private String email;
    private List<CourseDto> courses;
}
