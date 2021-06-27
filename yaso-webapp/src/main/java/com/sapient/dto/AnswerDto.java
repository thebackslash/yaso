package com.sapient.dto;


import lombok.Data;
import org.bson.types.ObjectId;

@Data
public class AnswerDto {
    private ObjectId answerId;

    private String answerContent;
    private String questionContent;
    private String answerAuthor;
    private String questionAuthor;


}
