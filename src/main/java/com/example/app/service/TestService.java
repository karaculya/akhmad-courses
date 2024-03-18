package com.example.app.service;

import com.example.app.exception.LackDataException;
import com.example.app.exception.NotFoundException;
import com.example.app.model.dto.QuestionDto;
import com.example.app.model.dto.TestResultDto;
import com.example.app.model.entity.Question;
import com.example.app.model.mapper.TestMapper;
import com.example.app.model.dto.TestDto;
import com.example.app.model.entity.Test;
import com.example.app.repository.TestRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TestService {
    private final TestRepository testRepository;
    private final QuestionService questionService;

    public TestDto getTest(Long id) {
        Optional<Test> test = testRepository.findById(id);
        if (!test.isPresent()) throw new NotFoundException();
        return TestMapper.toDto(test.get());
    }


    public void saveTest(TestDto testDto) {
        if (testDto.getQuestions() == null || testDto.getQuestions().isEmpty())
            throw new LackDataException();
        testRepository.save(TestMapper.toEntity(testDto));
    }

    public TestResultDto takeEnglishTest(TestDto dto) {
        TestResultDto result = new TestResultDto();
        int mark = 0;
        result.setUserData(dto.getResult().getUserData());

        for (String answer : dto.getResult().getUserData().getAnswers()) {
            for (QuestionDto question : dto.getQuestions()) {
                Question questionEntity = questionService.findByQuestionStr(question.getQuestionStr());
                if (questionEntity != null && questionEntity.getCorrectAnswer().equals(answer)) {
                    mark++;
                }
            }
        }
        result.setResult("Вы набрали " + mark + "баллов из 10");
        return result;
    }

    public TestResultDto takeKeirseyTest(TestDto dto) {
        TestResultDto result = new TestResultDto();
        char[] res = new char[4];
        result.setUserData(dto.getResult().getUserData());

        res[0] = getResByNum(1, 0, dto) ? 'E' : 'I';
        res[1] = getResByNum(2, 3, dto) ? 'S' : 'N';
        res[2] = getResByNum(4, 5, dto) ? 'T' : 'F';
        res[3] = getResByNum(6, 7, dto) ? 'J' : 'P';

        result.setResult(String.valueOf(res));
        return null;
    }

    private boolean getResByNum(int k, int n, TestDto dto) {
        int a = 0, b = 0;
        if (n != 0) {
            for (int i = k, j = n; i < 70 && j < 70; i += 7, j += 7) {
                Question questionEntity = questionService.findByQuestionStr(dto.getQuestions().get(i).getQuestionStr());
                if (questionEntity != null) {
                    if (questionEntity.getCorrectAnswer().equals(dto.getResult().getUserData().getAnswers().get(i))
                            || questionEntity.getCorrectAnswer().equals(dto.getResult().getUserData().getAnswers().get(j)))
                        a++;
                    else b++;
                }
            }
        } else {
            for (int i = k; i < 70; i += 7) {
                Question questionEntity = questionService.findByQuestionStr(dto.getQuestions().get(i).getQuestionStr());
                if (questionEntity != null) {
                    if (questionEntity.getCorrectAnswer().equals(dto.getResult().getUserData().getAnswers().get(i)))
                        a++;
                    else b++;
                }
            }
        }
        return a > b;
    }

    public TestResultDto takeMotivationalTest(TestDto dto) {
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


        return null;
    }
}
