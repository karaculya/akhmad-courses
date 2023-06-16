package com.example.app.service;

import com.example.app.entity.Course;
import com.example.app.repository.CourseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CourseService {
    private final CourseRepository repository;

    public void showCourses() {
        Iterable<Course> courses = repository.findAll();
    }
}
