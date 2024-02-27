package com.example.app.model.mapper;

import com.example.app.model.dto.TestDto;
import com.example.app.model.entity.Test;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = TestMapper.class)
public interface TestListMapper {
    List<Test> toEntityList(List<TestDto> dtos);
    List<TestDto> toDtoList(List<Test> models);
}
