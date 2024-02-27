package com.example.app.controller;

import com.example.app.model.dto.CourseDto;
import com.example.app.model.dto.ProfessorDto;
import com.example.app.service.ProfessorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/professor")
public class ProfessorController {

    private final ProfessorService professorService;

    @GetMapping("/{id}")
    public ProfessorDto getProfessor(@PathVariable Long id) {
        return professorService.getProfessor(id);
    }

    @PostMapping
    public ProfessorDto saveProfessor(@RequestBody ProfessorDto professorDto){
        return professorService.saveProfessor(professorDto);
    }

    @GetMapping("/courses/{id}")
    public List<CourseDto> getCourses(@PathVariable Long id) {
        return professorService.getCourses(id);
    }
}
