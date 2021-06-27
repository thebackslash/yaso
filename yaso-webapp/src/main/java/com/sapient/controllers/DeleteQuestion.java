package com.sapient.controllers;

import com.sapient.contracts.IAnswerDAO;
import com.sapient.contracts.IQuestionDAO;
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
import java.util.List;

/**
 * @Author: Akhil
 * 
 */
@WebServlet("/delete-question")
public class DeleteQuestion extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteQuestion() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		HttpSession session = request.getSession();
//		String user=    session.getAttribute("user").toString();
//		if(user==null) response.sendRedirect("/WEB-INF/views/login.jsp");
		
		String user = "101";
		
		IQuestionDAO questionDAO  = new QuestionService();
		String id = request.getParameter("questionId");
		Question question = questionDAO.getQuestionById(id);
		if(question.getAnswers()!=null) {
			List<ObjectId> toDelete = question.getAnswers();

			IAnswerDAO answerDAO = new AnswerService();
			for (ObjectId objectId : toDelete) {
				answerDAO.removeAnswerById(objectId.toString());
			}
		}
		questionDAO.removeQuestionById(id);
		List<Question> questions = questionDAO.getQuestionByUserId(user);
		request.setAttribute("questions", questions);
		response.sendRedirect(request.getContextPath() + "/list-questions-user" );
		
	}

	
}
