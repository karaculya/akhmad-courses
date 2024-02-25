package com.example.app.dto;

import com.example.app.entity.CourseResult;
import com.example.app.entity.Test;
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
