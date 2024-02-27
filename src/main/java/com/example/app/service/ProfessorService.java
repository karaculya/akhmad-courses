package com.example.app.service;

import com.example.app.exception.NotFoundException;
import com.example.app.model.dto.CourseDto;
import com.example.app.model.dto.ProfessorDto;
import com.example.app.model.entity.Professor;
import com.example.app.model.mapper.CourseListMapper;
import com.example.app.model.mapper.ProfessorMapper;
import com.example.app.repository.ProfessorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProfessorService {
    private final ProfessorRepository repository;
    private final ProfessorMapper mapper;
    private final CourseListMapper courseListMapper;

    public ProfessorDto getProfessor(Long id){
        Professor professor = repository.findProfessorById(id).orElse(null);
        if (professor == null) throw new NotFoundException();
        return mapper.toDto(professor);
    }

    public List<CourseDto> getCourses(Long id) {
        Professor professor = repository.findProfessorById(id).orElse(null);
        if (professor == null) throw new NotFoundException();
        return courseListMapper.toDtoList(professor.getCourses());
    }

    @Transactional
    public ProfessorDto saveProfessor(ProfessorDto professorDto){
        Professor professor = mapper.toEntity(professorDto);
        Professor saved = repository.save(professor);
        return mapper.toDto(saved);
    }
}
