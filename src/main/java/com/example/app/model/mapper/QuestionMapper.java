package com.example.app.model.mapper;

import com.example.app.model.dto.QuestionDto;
import com.example.app.model.entity.AnswerOption;
import com.example.app.model.entity.Question;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class QuestionMapper {
    public static List<QuestionDto> toDto(List<Question> entityList) {
        List<QuestionDto> dtoList = new ArrayList<>();
        for (Question entity : entityList) {
            dtoList.add(new QuestionDto(
                    entity.getQuestionStr(),
                    entity.getAnswerOptions().stream()
                            .map(AnswerOption::getAnswer)
                            .collect(Collectors.toList()),
                    entity.getCorrectAnswer(),
                    null));
        }
        return dtoList;
    }

    public static List<Question> toEntity(List<QuestionDto> dtoList) {
        List<Question> entityList = new ArrayList<>();
        for (QuestionDto dto : dtoList) {
            Question question = new Question();
            question.setQuestionStr(dto.getQuestionStr());
            List<AnswerOption> answerOptions = new ArrayList<>();
            for (String ans: dto.getAnswerOptions()) {
                AnswerOption answerOption = new AnswerOption();
                answerOption.setAnswer(ans);
                answerOptions.add(answerOption);
            }
            question.setAnswerOptions(answerOptions);
            question.setCorrectAnswer(dto.getCorrectAnswer());
            entityList.add(question);
        }
        return entityList;
    }
}
