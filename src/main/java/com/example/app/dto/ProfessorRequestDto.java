package com.example.app.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProfessorRequestDto {
    private Long id;
    private String fio;
    private String email;
    private String login;
    private String password;
    private List<CourseDto> courses;
}
