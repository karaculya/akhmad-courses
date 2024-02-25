package com.example.app.service;

import com.example.app.dto.CourseDto;
import com.example.app.entity.Course;
import com.example.app.mapper.CourseListMapper;
import com.example.app.mapper.CourseMapper;
import com.example.app.repository.CourseRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.Objects.isNull;

@Slf4j
@Service
@RequiredArgsConstructor
public class CourseService {
    private final CourseRepository repository;
    private final CourseMapper mapper;
    private final CourseListMapper listMapper;

    public CourseDto getCourse(Long id) {
        return mapper.toDto(repository.findById(id).orElse(null));
    }

    public CourseDto saveCourse(CourseDto dto) {
        log.debug(dto.toString());
        return mapper.toDto(repository.save(mapper.toEntity(dto)));
    }

    public List<CourseDto> showCourses() {
        return listMapper.toDtoList(repository.findAll());
    }
}
