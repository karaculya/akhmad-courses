package com.example.app.service;

import com.example.app.model.dto.QuestionDto;
import com.example.app.model.dto.TestDto;
import com.example.app.model.entity.Question;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class HelperProcessingService {
    private final QuestionService questionService;

    public int processEnglishTest(TestDto dto) {
        int mark = 0;

        for (int answer : dto.getResult().getUserData().getAnswers()) {
            for (QuestionDto question : dto.getQuestions()) {
                Question questionEntity = questionService.findByQuestionStr(question.getQuestionStr());
                if (questionEntity != null && questionEntity.getCorrectAnswer() == answer) {
                    mark++;
                }
            }
        }

        return mark;
    }

    public String processKeirseyTest(TestDto dto) {
        char[] res = new char[4];

        res[0] = getType(1, 0, dto) ? 'E' : 'I';
        res[1] = getType(2, 3, dto) ? 'S' : 'N';
        res[2] = getType(4, 5, dto) ? 'T' : 'F';
        res[3] = getType(6, 7, dto) ? 'J' : 'P';

        return String.valueOf(res);
    }

    public int processMotivationalTest(int[] answers) {
        int[][] template = {
                {1, 2, 3, 4, 5},
                {3, 2, 5, 4, 1},
                {5, 1, 2, 3, 4},
                {1, 4, 3, 5, 2},
                {2, 1, 3, 5, 4},
                {2, 1, 3, 4, 5},
                {3, 2, 1, 5, 4},
                {4, 1, 3, 5, 2},
                {3, 1, 4, 2, 5},
                {3, 2, 4, 1, 5},
                {1, 2, 4, 5, 3},
                {2, 3, 5, 1, 4},
                {1, 3, 2, 4, 5},
                {4, 3, 2, 1, 5},
        };

        return getType(answers, template);
    }

    public int processTomasTest(int[] answers) {
        int[][] template = {
                {0, 0, 0, 1, 2},
                {0, 2, 1, 0, 0},
                {1, 0, 0, 0, 2},
                {0, 0, 1, 0, 2},
                {0, 1, 0, 2, 0},
                {2, 0, 0, 1, 0},
                {0, 0, 2, 1, 0},
                {1, 2, 0, 0, 0},
                {2, 0, 0, 1, 0},
                {1, 0, 2, 0, 0},
                {0, 1, 0, 0, 2},
                {0, 0, 2, 1, 0},
                {2, 0, 1, 0, 0},
                {2, 1, 0, 0, 0},
                {0, 0, 0, 2, 1},
                {2, 0, 0, 0, 1},
                {1, 0, 0, 2, 0},
                {0, 0, 2, 0, 1},
                {0, 1, 0, 2, 0},
                {0, 1, 2, 0, 0},
                {0, 2, 0, 0, 1},
                {2, 0, 1, 0, 0},
                {0, 1, 0, 2, 0},
                {0, 0, 2, 0, 1},
                {1, 0, 0, 0, 2},
                {0, 2, 1, 0, 0},
                {0, 0, 0, 1, 2},
                {1, 2, 0, 0, 0},
                {0, 0, 1, 2, 0},
                {0, 2, 0, 0, 1},
        };
        return getType(answers, template);
    }

    private boolean getType(int k, int n, TestDto dto) {
        int a = 0, b = 0;
        if (n != 0) {
            for (int i = k, j = n; i < 70 && j < 70; i += 7, j += 7) {
                Question questionEntity = questionService.findByQuestionStr(dto.getQuestions().get(i).getQuestionStr());
                if (questionEntity != null) {
                    if (questionEntity.getCorrectAnswer() == dto.getResult().getUserData().getAnswers()[i]
                            || questionEntity.getCorrectAnswer() == dto.getResult().getUserData().getAnswers()[j])
                        a++;
                    else b++;
                }
            }
        } else {
            for (int i = k; i < 70; i += 7) {
                Question questionEntity = questionService.findByQuestionStr(dto.getQuestions().get(i).getQuestionStr());
                if (questionEntity != null) {
                    if (questionEntity.getCorrectAnswer() == dto.getResult().getUserData().getAnswers()[i])
                        a++;
                    else b++;
                }
            }
        }
        return a > b;
    }

    private int getType(int[] answers, int[][] template) {
        int[] res = {0, 0, 0, 0, 0};

        for (int[] ints : template) {
            for (int j = 0; j < ints.length; j++) {
                for (int answer : answers) {
                    if (answer == ints[j]) {
                        res[j]++;
                    }
                }
            }
        }

        int max = 0;

        for (int i = 0; i < res.length; i++) {
            if (res[i] < res[i + 1]) max = i + 1;
            else max = i;
        }

        return max;
    }
}
