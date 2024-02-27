package com.example.app.model.mapper;

import com.example.app.model.dto.TestResultDto;
import com.example.app.model.entity.TestResult;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TestResultMapper {
    TestResultDto toDto(TestResult entity);
    TestResult toEntity(TestResultDto dto);
}
