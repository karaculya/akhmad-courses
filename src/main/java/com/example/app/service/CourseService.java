package com.example.app.service;

import com.example.app.dto.CourseDto;
import com.example.app.entity.Course;
import com.example.app.mapper.CourseMapper;
import com.example.app.repository.CourseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static java.util.Objects.isNull;

@Service
@RequiredArgsConstructor
public class CourseService {
    private final CourseRepository repository;
    public CourseDto getCourse(Long id) {
        Course course = repository.findById(id).orElse(null);

        return CourseMapper.toDto(course, false);
    }

    public void showCourses() {
        Iterable<Course> courses = repository.findAll();
    }
}
