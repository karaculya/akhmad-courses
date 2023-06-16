package com.example.app.service;

import com.example.app.repository.TestResultRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TestResultService {
    private final TestResultRepository repository;
}
