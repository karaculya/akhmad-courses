package com.example.app.service;

import com.example.app.repository.CourseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CourseResultService {
    private final CourseRepository repository;
}
