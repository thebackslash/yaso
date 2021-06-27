package com.sapient.controllers;

import com.sapient.contracts.IAnswerDAO;
import com.sapient.contracts.IQuestionDAO;
import com.sapient.dto.QuestionDto;
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
import java.util.Arrays;
import java.util.List;

@WebServlet("/question")
public class QuestionController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        IQuestionDAO questionDAO = new QuestionService();
        IAnswerDAO answerDAO  = new AnswerService();
        QuestionDto questionDto = new QuestionDto();
        Question question = questionDAO.getQuestionById(id);

        List<String> answerContent = new ArrayList<>();
        List<String> answerAuthor = new ArrayList<>();

        if(question.getAnswers()!=null) {
            for (ObjectId answerId : question.getAnswers()) {
                Answer answer = answerDAO.getAnswerById(answerId.toString());
                answerContent.add(answer.getContent());
                answerAuthor.add("Aarsh");
            }
        }
        questionDto.setQuestionContent(question.getContent());
        questionDto.setQuestionAuthor("Akhil");
        if(question.getAnswers()!=null)  {
            questionDto.setAnswerAuthor(answerAuthor);
            questionDto.setAnswerContent(answerContent);
        } else
        {
            questionDto.setAnswerContent(Arrays.asList(" "));
            questionDto.setAnswerAuthor(Arrays.asList(" "));
        }
        req.setAttribute("questionData", questionDto);
        req.setAttribute("id", id);
        String URI = "WEB-INF/views/single-question.jsp";
        req.getRequestDispatcher(URI).forward(req,resp);


    }
}
