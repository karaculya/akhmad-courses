package com.example.app.model.mapper;

import com.example.app.model.dto.ProfessorDto;
import com.example.app.model.entity.Professor;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProfessorMapper {
    ProfessorDto toDto(Professor entity);
    Professor toEntity(ProfessorDto dto);
}
