package com.example.app.repository;

import com.example.app.entity.TaskResult;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskResultRepository extends JpaRepository<TaskResult, Long> {
}
