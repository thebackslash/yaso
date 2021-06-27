package com.sapient.controllers;

import com.sapient.contracts.IAnswerDAO;
import com.sapient.contracts.IQuestionDAO;
import com.sapient.entity.Answer;
import com.sapient.entity.Question;
import com.sapient.services.AnswerService;
import com.sapient.services.QuestionService;
import org.bson.types.ObjectId;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/update-ans")

public class AnswerUpdateController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String answerId = req.getParameter("answerId");
        IAnswerDAO answerDAO = new AnswerService();
        Answer answer = answerDAO.getAnswerById(answerId);

        if(req.getParameter("delete")!=null){
            IQuestionDAO questionDAO = new QuestionService();
            Question question = questionDAO.getQuestionById(answer.getQuestionId().toString());
            List<ObjectId> oldList = question.getAnswers();
            List<ObjectId> newList = new ArrayList<>();

            for(ObjectId object : oldList){
                if(object.toString().equals(answerId))
                {
                    continue;
                }
                newList.add(object);
            }
            question.setAnswers(newList);

            answerDAO.removeAnswerById(answerId);
            questionDAO.updateQuestionById(question, question.getId().toString());
        } else if(req.getParameter("update")!=null){
           answer.setContent(req.getParameter("content"));
           answerDAO.updateAnswerById(answerId, answer);
        }
        resp.sendRedirect(req.getContextPath() + "/user-answers");
    }
}
