package com.example.app.service;

import com.example.app.entity.Professor;
import com.example.app.repository.ProfessorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProfessorService {
    private final ProfessorRepository repository;

    public Professor getProfessor(Long id){
        return repository.findById(id).orElse(null);
    }

}
