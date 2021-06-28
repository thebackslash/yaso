package com.sapient.controllers;

import com.sapient.beansCreator.AnswerCreator;
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
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/add-answer")
public class AddAnswer extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);

        if(session.getAttribute("user")==null){
            resp.sendRedirect(req.getContextPath() + "/login");
        }
        Answer answer = AnswerCreator.createAnswer(req);
        IAnswerDAO answerDAO = new AnswerService();
        IQuestionDAO questionDAO = new QuestionService();
        answerDAO.addAnswer(answer);
        Question question = questionDAO.getQuestionById(answer.getQuestionId().toString());

        List<ObjectId> anslist;
       if(question.getAnswers()!=null) {
           anslist = question.getAnswers();
       } else{
           anslist = new ArrayList<>();
       }
        anslist.add(answer.getId());
        question.setAnswers(anslist);
        questionDAO.updateQuestionById(question, req.getParameter("questionId"));

        resp.sendRedirect(req.getContextPath() + "/question?id=" + req.getParameter("questionId"));
    }

}
