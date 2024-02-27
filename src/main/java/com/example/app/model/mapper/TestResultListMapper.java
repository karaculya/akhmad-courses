package com.example.app.model.mapper;

import com.example.app.model.dto.TestResultDto;
import com.example.app.model.entity.TestResult;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = TestResultMapper.class)
public interface TestResultListMapper {
    List<TestResult> toEntityList(List<TestResultDto> dtos);
    List<TestResultDto> toDtoList(List<TestResult> models);
}
