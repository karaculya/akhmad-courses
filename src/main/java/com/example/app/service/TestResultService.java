package com.example.app.service;

import com.example.app.model.entity.TestResult;
import com.example.app.repository.TestResultRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TestResultService {
    private final TestResultRepository repository;

    String getKeirseyTestResult(String str) {
        for (TestResult result : repository.findAll()) {
            if (result.getResult().equals(str)) {
                return result.getResultInfo();
            }
        }
        throw new RuntimeException("Ошибка! Невозможно обработать тест");
    }

    String getTestResult(Long id, String str) {
        for (TestResult result : repository.findAll()) {
            if (result.getId().equals(id) && result.getResult().equals(str)) {
                return result.getResultInfo();
            }
        }
        throw new RuntimeException("Ошибка! Невозможно обработать тест");
    }
}
