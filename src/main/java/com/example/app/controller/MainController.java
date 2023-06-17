package com.example.app.controller;

import com.example.app.dto.CourseDto;
import com.example.app.entity.Course;
import com.example.app.entity.Professor;
import com.example.app.service.CourseService;
import com.example.app.service.ProfessorService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MainController {

    private final ProfessorService professorService;

    private final CourseService courseService;

    @GetMapping("/greeting/{id}")
    public Professor greeting(@PathVariable Long id) {
        return professorService.getProfessor(id);
    }

    @GetMapping("/course/{id}")
    public CourseDto getCourse(@PathVariable Long id){
        return courseService.getCourse(id);
    }
}
