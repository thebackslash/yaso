package com.sapient.dto;

import lombok.Data;

import java.util.List;

@Data
public class QuestionDto {
    private String questionContent;
    private String questionAuthor;
    private List<String> answerContent;
    private List<String> answerAuthor;
}
