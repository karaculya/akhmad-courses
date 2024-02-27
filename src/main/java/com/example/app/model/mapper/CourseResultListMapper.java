package com.example.app.model.mapper;

import com.example.app.model.dto.CourseResultDto;
import com.example.app.model.entity.CourseResult;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = CourseResultMapper.class)
public interface CourseResultListMapper {
    List<CourseResult> toEntityList(List<CourseResultDto> dtos);
    List<CourseResultDto> toDtoList(List<CourseResult> models);
}
