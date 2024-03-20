package com.example.app.service;

import com.example.app.model.dto.TestDto;
import com.example.app.model.dto.TestResultDto;
import com.example.app.model.entity.Test;
import com.example.app.model.mapper.TestMapper;
import com.example.app.repository.TestRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TestService {
    private final TestRepository testRepository;
    private final HelperProcessingService processingService;

    public TestDto getTest(Long id) {
        Optional<Test> test = testRepository.findById(id);
        if (!test.isPresent()) throw new RuntimeException("Not found. Sorry :c");
        return TestMapper.toDto(test.get());
    }


    public void saveTest(TestDto testDto) {
        if (testDto.getQuestions() == null || testDto.getQuestions().isEmpty())
            throw new RuntimeException("Сould not be found");
        testRepository.save(TestMapper.toEntity(testDto));
    }

    public TestResultDto takeEnglishTest(TestDto dto) {
        TestResultDto result = new TestResultDto();
        result.setUserData(dto.getResult().getUserData());
        result.setResult("Вы набрали " + processingService.processEnglishTest(dto) + " баллов из 10");
        return result;
    }

    public TestResultDto takeKeirseyTest(TestDto dto) {
        TestResultDto result = new TestResultDto();
        result.setUserData(dto.getResult().getUserData());
        result.setResult(processingService.processKeirseyTest(dto));
        return result;
    }

    public TestResultDto takeMotivationalTest(Long id, TestDto dto) {
        TestResultDto result = new TestResultDto();
        result.setUserData(dto.getResult().getUserData());
        result.setResult(processingService.processMotivationalTest(id, dto.getResult().getUserData().getAnswers()));

        return result;
    }

    public TestResultDto takeTomasTest(Long id, TestDto dto) {
        TestResultDto result = new TestResultDto();
        result.setUserData(dto.getResult().getUserData());
        result.setResult(processingService.processTomasTest(id, dto.getResult().getUserData().getAnswers()));
        return result;
    }
}
