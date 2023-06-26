package com.example.app.mapper;

import com.example.app.dto.CourseDto;
import com.example.app.entity.Course;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

import static java.util.Objects.isNull;
import static java.util.stream.Collectors.toList;

public class CourseMapper {

    static public CourseDto toDto(Course course, Boolean includeStudents) {
        if (isNull(course))
            return null;

        CourseDto courseDto = new CourseDto();
        courseDto.setId(course.getId());
        courseDto.setCourseName(course.getCourseName());
        courseDto.setDescription(course.getDescription());
        if (includeStudents)
            courseDto.setStudents(course.getStudents().stream()
                    .map(StudentMapper::toDto)
                    .collect(toList()));
        return courseDto;
    }

}
