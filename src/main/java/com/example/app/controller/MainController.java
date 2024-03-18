package com.example.app.controller;

import com.example.app.model.dto.TestDto;
import com.example.app.model.dto.TestResultDto;
import com.example.app.service.TestService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/test")
public class MainController {

    private final TestService testService;

    @GetMapping("/{id}")
    public TestDto getTest(@PathVariable Long id) {
        return testService.getTest(id);
    }

    @PostMapping
    public void saveTest(@RequestBody TestDto testDto) {
        testService.saveTest(testDto);
    }

    @GetMapping("/english-test")
    public TestResultDto takeEnglishTest(TestDto dto) {
        return testService.takeEnglishTest(dto);
    }

    @GetMapping("/keirsey-test")
    public TestResultDto takeKeirseyTest(TestDto dto) {
        return testService.takeKeirseyTest(dto);
    }

    @GetMapping("/motivational-test")
    public TestResultDto takeMotivationalTest(TestDto dto) {
        return testService.takeMotivationalTest(dto);
    }

    @GetMapping("/tomas-test")
    public TestResultDto takeTomasTest(TestDto dto) {
        return null;
    }
}
