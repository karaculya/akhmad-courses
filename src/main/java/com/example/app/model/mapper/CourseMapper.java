package com.example.app.model.mapper;

import com.example.app.model.dto.CourseDto;
import com.example.app.model.entity.Course;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CourseMapper {
    CourseDto toDto(Course entity);
    Course toEntity(CourseDto dto);
}