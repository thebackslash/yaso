package com.sapient.controllers;

import com.mongodb.client.MongoCursor;
import com.mongodb.client.model.Filters;
import com.sapient.contracts.IAnswerDAO;
import com.sapient.contracts.IQuestionDAO;
import com.sapient.dto.AnswerDto;
import com.sapient.entity.Answer;
import com.sapient.entity.Question;
import com.sapient.services.AnswerService;
import com.sapient.services.QuestionService;
import org.bson.conversions.Bson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/user-answers")
public class UserAnswersController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        IAnswerDAO answerDAO = new AnswerService();
        IQuestionDAO questionDAO = new QuestionService();
        String userId = "101";
        Bson condition = Filters.eq("uId" , userId);
        MongoCursor listOfAnswers = answerDAO.getByCondition(condition, 0);
        List<AnswerDto> answers = new ArrayList<>();
        while(listOfAnswers.hasNext()){
            Answer ans = (Answer) listOfAnswers.next();
            Question question = questionDAO.getQuestionById(ans.getQuestionId().toString());

            AnswerDto answerDto = new AnswerDto();

            answerDto.setAnswerAuthor("Aarsh");
            answerDto.setQuestionAuthor("Akhil");
            answerDto.setAnswerContent(ans.getContent());
            answerDto.setQuestionContent(question.getContent());
            answerDto.setAnswerId(ans.getId());

            answers.add(answerDto);

        }

         req.setAttribute("answers", answers);

        String URI = "WEB-INF/views/user-answers.jsp";
        req.getRequestDispatcher(URI).forward(req,resp);
    }
}
