package com.example.app.mapper;

import com.example.app.dto.StudentDto;
import com.example.app.entity.Student;
import org.springframework.stereotype.Service;

import static java.util.Objects.isNull;

public class StudentMapper {
    static public StudentDto toDto(Student student) {
        if (isNull(student))
            return null;

        return new StudentDto(
                student.getId(),
                student.getFio(),
                student.getEmail()
        );
    }


}
