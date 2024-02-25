package com.example.app.dto;

import com.example.app.entity.Course;
import com.example.app.entity.Student;
import com.example.app.entity.TaskResult;
import com.example.app.entity.TestResult;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CourseResultDto {
    private Long id;
    private int mark;
    private Course course;
    private Student student;
    private List<TaskResult> taskResults;
    private List<TestResult> testResults;
}
