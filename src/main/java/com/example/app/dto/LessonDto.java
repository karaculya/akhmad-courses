package com.example.app.dto;

import com.example.app.entity.Course;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.File;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LessonDto {
    private Long id;
    private String lessonName;
    private String description;
    private File lessonFile;
    private Course course;
}
