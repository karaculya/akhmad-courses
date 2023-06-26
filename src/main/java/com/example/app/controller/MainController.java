package com.example.app.controller;

import com.example.app.dto.CourseDto;
import com.example.app.dto.ProfessorDto;
import com.example.app.dto.ProfessorRequestDto;
import com.example.app.service.CourseService;
import com.example.app.service.ProfessorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class MainController {

    private final ProfessorService professorService;

    private final CourseService courseService;

    @GetMapping("/professor/{id}")
    public ProfessorDto getProfessor(
            @PathVariable Long id,
            @RequestParam(required = false, defaultValue = "false") Boolean includeStudents
    ) {
        return professorService.getProfessor(id, includeStudents);
    }

    @PostMapping("/professor")
    public ProfessorDto saveProfessor(@RequestBody ProfessorRequestDto professorDto){
        return professorService.saveProfessor(professorDto);
    }

    @GetMapping("/course/{id}")
    public CourseDto getCourse(@PathVariable Long id) {
        return courseService.getCourse(id);
    }
}
