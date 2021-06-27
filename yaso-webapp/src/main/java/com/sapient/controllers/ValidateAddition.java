package com.sapient.controllers;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author: Akhil
 * 
 */

@WebServlet("/validate-addition")
public class ValidateAddition extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ValidateAddition() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		HttpSession session = request.getSession();
//		String loggedInUser = session.getAttribute("user").toString();
		
//		if(loggedInUser==null)
//		if(user==null) response.sendRedirect("/WEB-INF/views/login.jsp");
		
		
		String user = "102";
		request.setAttribute("user", user);
		 String URI = "WEB-INF/views/add-question.jsp";
	        request.getRequestDispatcher(URI).forward(request,response);
		
	}

	

}
