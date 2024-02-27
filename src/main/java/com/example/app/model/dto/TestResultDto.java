package com.example.app.model.dto;

import com.example.app.model.entity.CourseResult;
import com.example.app.model.entity.Test;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TestResultDto {
    private Long id;
    private int mark;
    private Test test;
    private CourseResult courseResult;
}
