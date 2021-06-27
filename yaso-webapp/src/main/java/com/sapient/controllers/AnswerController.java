package com.sapient.controllers;


import com.sapient.dto.AnswerDto;
import org.bson.types.ObjectId;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/answer")
public class AnswerController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String answerId =  req.getParameter("answerId");
        String answerContent =  req.getParameter("answerContent");
        String questionContent =  req.getParameter("questionContent");
        String questionAuthor =  req.getParameter("questionAuthor");
        String answerAuthor =  req.getParameter("answerAuthor");
       AnswerDto answerDto = new AnswerDto();
        answerDto.setAnswerId(new ObjectId(answerId));
        answerDto.setAnswerAuthor(answerAuthor);
        answerDto.setQuestionContent(questionContent);
        answerDto.setAnswerContent(answerContent);
        answerDto.setQuestionAuthor(questionAuthor);
        req.setAttribute("answer", answerDto);
        String URI = "WEB-INF/views/answer.jsp";

        req.getRequestDispatcher(URI).forward(req,resp);
    }


}
