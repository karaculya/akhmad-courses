package com.example.app.model.mapper;

import com.example.app.model.dto.CourseDto;
import com.example.app.model.entity.Course;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = CourseMapper.class)
public interface CourseListMapper {
    List<Course> toEntityList(List<CourseDto> dtos);
    List<CourseDto> toDtoList(List<Course> models);
}