package com.example.app.service;

import com.example.app.dto.ProfessorDto;
import com.example.app.dto.ProfessorRequestDto;
import com.example.app.entity.Professor;
import com.example.app.mapper.ProfessorMapper;
import com.example.app.repository.ProfessorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ProfessorService {
    private final ProfessorRepository repository;
    private final ProfessorMapper mapper;

    public ProfessorDto getProfessor(Long id){
        Professor professor = repository.findProfessorById(id).orElse(null);
        return mapper.toDto(professor);
    }

    @Transactional
    public ProfessorDto saveProfessor(ProfessorDto professorDto){
        Professor professor = mapper.toEntity(professorDto);
        Professor saved = repository.save(professor);
        return mapper.toDto(saved);
    }
}
