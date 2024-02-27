package com.example.app.model.mapper;

import com.example.app.model.dto.TestDto;
import com.example.app.model.entity.Test;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TestMapper {
    TestDto toDto(Test entity);
    Test toEntity(TestDto dto);
}
