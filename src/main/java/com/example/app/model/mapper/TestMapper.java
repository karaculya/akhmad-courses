package com.example.app.model.mapper;

import com.example.app.model.dto.TestDto;
import com.example.app.model.entity.Test;

public class TestMapper {

    public static TestDto toDto(Test entity) {
        return new TestDto(QuestionMapper.toDto(entity.getQuestions()), null);
    }

    public static Test toEntity(TestDto dto) {
        Test test = new Test();
        test.setQuestions(QuestionMapper.toEntity(dto.getQuestions()));
        return test;
    }
}
