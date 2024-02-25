package com.example.app.mapper;

import com.example.app.dto.ProfessorDto;
import com.example.app.entity.Professor;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProfessorMapper {

    ProfessorDto toDto(Professor entity);

    Professor toEntity(ProfessorDto dto);
}
