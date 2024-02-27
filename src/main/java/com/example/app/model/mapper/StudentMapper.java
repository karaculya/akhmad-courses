package com.example.app.model.mapper;

import com.example.app.model.dto.StudentDto;
import com.example.app.model.entity.Student;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface StudentMapper {
    StudentDto toDto(Student entity);
    Student toEntity(StudentDto dto);
}