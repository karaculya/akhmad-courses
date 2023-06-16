package com.example.app.repository;

import com.example.app.entity.Professor;
import com.example.app.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
