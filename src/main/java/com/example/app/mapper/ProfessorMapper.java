package com.example.app.mapper;

import com.example.app.dto.CourseDto;
import com.example.app.dto.ProfessorDto;
import com.example.app.dto.ProfessorRequestDto;
import com.example.app.entity.Professor;

import java.util.List;

import static java.util.Objects.isNull;

public class ProfessorMapper {

    public static ProfessorDto toDto(Professor professor, Boolean includeStudents) {
        if (isNull(professor)) return null;

        ProfessorDto professorDto = new ProfessorDto();
        professorDto.setId(professor.getId());
        professorDto.setFio(professor.getFio());
        professorDto.setEmail(professor.getEmail());
        List<CourseDto> courseDtos = professor.getCourses() != null
                ? professor.getCourses().stream()
                    .map(course -> CourseMapper.toDto(course, includeStudents))
                    .toList()
                : null;
        professorDto.setCourses(courseDtos);
        return professorDto;
    }

    public static Professor toEntity(ProfessorRequestDto professorDto) {
        Professor professor = new Professor();
        professor.setId(professorDto.getId());
        professor.setFio(professorDto.getFio());
        professor.setEmail(professorDto.getEmail());
        professor.setLogin(professorDto.getLogin());
        professor.setPassword(professorDto.getPassword());
//  TODO      professor.setCourses();
//   каскадное сохранение
        return professor;
    }
}
