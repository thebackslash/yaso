package com.sapient.controllers;

import com.mongodb.client.MongoCursor;
import com.sapient.contracts.IQuestionDAO;
import com.sapient.entity.Question;
import com.sapient.services.QuestionService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/questions")
public class AllQuestionsController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        IQuestionDAO questionDAO = new QuestionService();
       MongoCursor questions =  questionDAO.getAllQuestions();
        List<Question> questionList = new ArrayList<>();

        while(questions.hasNext()){
            questionList.add((Question) questions.next());

        }
        req.setAttribute("questions", questionList);
        String URI = "WEB-INF/views/questions.jsp";
        req.getRequestDispatcher(URI).forward(req,resp);

    }
}
