package com.example.app.model.mapper;

import com.example.app.model.dto.StudentDto;
import com.example.app.model.entity.Student;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = StudentMapper.class)
public interface StudentListMapper {
    List<Student> toEntityList(List<StudentDto> dtos);
    List<StudentDto> toDtoList(List<Student> models);
}
