package com.sapient.beansCreator;

import com.sapient.entity.Answer;
import org.bson.types.ObjectId;

import javax.servlet.http.HttpServletRequest;

public class AnswerCreator {
    private AnswerCreator(){

    }

    public static Answer createAnswer(HttpServletRequest req){
        Answer answer = new Answer();
        answer.setId(new ObjectId());
        answer.setContent(req.getParameter("content"));
        answer.setQuestionId(new ObjectId(req.getParameter("questionId")));
        //answer.setUId(req.getSession(false).getAttribute("userId").toString());
        answer.setUId("101");
        return answer;
    }
}
