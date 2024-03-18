package com.example.app.service;

import com.example.app.model.dto.QuestionDto;
import com.example.app.model.entity.Question;
import com.example.app.repository.QuestionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class QuestionService {
    private final QuestionRepository repository;

    Question findByQuestionStr(String s) {
        for (Question question : repository.findAll()) {
            if (question.getQuestionStr().equals(s))
                return question;
        }
        return null;
    }
}
