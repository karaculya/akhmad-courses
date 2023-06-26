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

    public ProfessorDto getProfessor(Long id, Boolean includeStudents){
        Professor professor = repository.findProfessorById(id).orElse(null);
        return ProfessorMapper.toDto(professor, includeStudents);
    }

    @Transactional
    public ProfessorDto saveProfessor(ProfessorRequestDto professorDto){
        Professor professor = ProfessorMapper.toEntity(professorDto);
        Professor saved = repository.save(professor);
        return ProfessorMapper.toDto(saved, true);
    }
}
