package com.sapient.controllers;

import com.sapient.beansCreator.QuestionCreator;
import com.sapient.contracts.IQuestionDAO;
import com.sapient.entity.Question;
import com.sapient.services.QuestionService;

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
@WebServlet("/update-question")
public class UpdateQuestion extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateQuestion() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  
		
		
			
//			HttpSession session = request.getSession();
//			String user=    session.getAttribute("user").toString();
//			if(user==null) response.sendRedirect("/WEB-INF/views/login.jsp");
			
			String user = "101";
			IQuestionDAO questionDAO = new QuestionService();
			
		     request.setAttribute("uId", user);

	   String id = request.getParameter("questionId");
	   Question question  =QuestionCreator.questionCreator(request);
	   questionDAO.updateQuestionById(question, id);
	   List<Question> questions = questionDAO.getQuestionByUserId(user);
		request.setAttribute("questions", questions);
	   
	   
	   
	   
	   
	   String URI = "WEB-INF/views/user-questions.jsp";
	   
	   
	     request.getRequestDispatcher(URI).forward(request,response);
	   
	   
	 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
