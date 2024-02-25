package com.example.app.dto;

import com.example.app.entity.Course;
import com.example.app.entity.TestResult;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TestDto {
    private Long id;
    private Course course;
    private TestResult result;
}
