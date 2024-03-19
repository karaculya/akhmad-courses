package com.example.app.controller;

import com.example.app.model.dto.TestDto;
import com.example.app.model.dto.TestResultDto;
import com.example.app.service.TestService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/test")
public class MainController {

    private final TestService testService;

    @GetMapping("/{id}")
    public ResponseEntity<TestDto> getTest(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(testService.getTest(id));
    }

    @PostMapping
    public void saveTest(@RequestBody TestDto testDto) {
        testService.saveTest(testDto);
    }

    @GetMapping("/english-test")
    public ResponseEntity<TestResultDto> takeEnglishTest(TestDto dto) {
        return ResponseEntity.status(HttpStatus.OK).body(testService.takeEnglishTest(dto));
    }

    @GetMapping("/keirsey-test")
    public ResponseEntity<TestResultDto> takeKeirseyTest(TestDto dto) {
        return ResponseEntity.status(HttpStatus.OK).body(testService.takeKeirseyTest(dto));
    }

    @GetMapping("/{id}/motivational-test")
    public ResponseEntity<TestResultDto> takeMotivationalTest(@PathVariable Long id, TestDto dto) {
        return ResponseEntity.status(HttpStatus.OK).body(testService.takeMotivationalTest(id, dto));
    }

    @GetMapping("/{id}/tomas-test")
    public ResponseEntity<TestResultDto> takeTomasTest(@PathVariable Long id, TestDto dto) {
        return ResponseEntity.status(HttpStatus.OK).body(testService.takeTomasTest(id, dto));
    }
}
