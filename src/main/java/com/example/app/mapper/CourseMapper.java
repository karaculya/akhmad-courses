package com.example.app.mapper;

import com.example.app.dto.CourseDto;
import com.example.app.entity.Course;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CourseMapper {

    CourseDto toDto(Course entity);
    Course toEntity(CourseDto dto);

}