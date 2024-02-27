package com.example.app.repository;

import com.example.app.model.entity.Professor;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface ProfessorRepository extends JpaRepository <Professor, Long> {
    @Query(value = "select p from Professor p where p.id = :id")
    @EntityGraph(value = "professor-entity-graph")
    Optional<Professor> findProfessorById(Long id);
}
