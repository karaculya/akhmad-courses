package com.example.app.controller;

import com.example.app.entity.Professor;
import com.example.app.service.ProfessorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MainController {
    private final ProfessorService professorService;
    @GetMapping("/greeting/{id}")
    public Professor greeting(@PathVariable Long id) {
        return professorService.getProfessor(id);
    }
}
