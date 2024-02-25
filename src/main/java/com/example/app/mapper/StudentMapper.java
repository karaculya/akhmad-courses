package com.example.app.mapper;

import com.example.app.dto.StudentDto;
import com.example.app.entity.Student;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface StudentMapper {
    StudentDto toDto(Student entity);
    Student toEntity(StudentDto dto);
}