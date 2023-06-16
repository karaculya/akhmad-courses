package com.example.app.service;

import com.example.app.repository.TaskResultRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TaskResultService {
    private final TaskResultRepository repository;
}
