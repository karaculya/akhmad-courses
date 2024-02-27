package com.example.app.model.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
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
    @NotBlank(message = "Поле ФИО не должно быть пустым")
    private String fio;
    @Email
    @NotBlank(message = "Поле email не должно быть пустым")
    private String email;
    @NotBlank(message = "Поле логин не должно быть пустым")
    private String login;
    @NotBlank(message = "Поле пароль не должно быть пустым")
    private String password;
    private List<CourseDto> courses;
}
