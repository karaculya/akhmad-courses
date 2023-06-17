package com.example.app.mapper;

import com.example.app.dto.CourseDto;
import com.example.app.entity.Course;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

import static java.util.Objects.isNull;
import static java.util.stream.Collectors.toList;

public class CourseMapper {

    static public CourseDto toDto(Course course) {

        if (isNull(course))
            return null;

        return new CourseDto(
                course.getId(),
                course.getCourseName(),
                course.getDescription(),
                course.getStudents().stream().map(StudentMapper::toDto).collect(toList())
        );
    }

}
