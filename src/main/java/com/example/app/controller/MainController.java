package com.example.app.controller;

import com.example.app.model.dto.TestDto;
import com.example.app.model.dto.TestResultDto;
import com.example.app.service.TestService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/api/test", produces = "application/json")
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

    @PostMapping("/english-test")
    public ResponseEntity<TestResultDto> takeEnglishTest(@RequestBody TestDto dto) {
        return ResponseEntity.status(HttpStatus.OK).body(testService.takeEnglishTest(dto));
    }

    @PostMapping("/keirsey-test")
    public ResponseEntity<TestResultDto> takeKeirseyTest(@RequestBody TestDto dto) {
        return ResponseEntity.status(HttpStatus.OK).body(testService.takeKeirseyTest(dto));
    }

    @PostMapping("/{id}/motivational-test")
    public ResponseEntity<TestResultDto> takeMotivationalTest(@PathVariable Long id, @RequestBody TestDto dto) {
        return ResponseEntity.status(HttpStatus.OK).body(testService.takeMotivationalTest(id, dto));
    }

    @PostMapping("/{id}/tomas-test")
    public ResponseEntity<TestResultDto> takeTomasTest(@PathVariable Long id, @RequestBody TestDto dto) {
        return ResponseEntity.status(HttpStatus.OK).body(testService.takeTomasTest(id, dto));
    }
}
