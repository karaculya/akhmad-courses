package com.example.app.model.mapper;

import com.example.app.model.dto.CourseResultDto;
import com.example.app.model.entity.CourseResult;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CourseResultMapper {
    CourseResultDto toDto(CourseResult entity);
    CourseResult toEntity(CourseResultDto dto);
}
