package com.sapient.beansCreator;

import com.sapient.entity.Question;
import org.bson.types.ObjectId;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author: Akhil
 * 
 */


public class QuestionCreator {
	
	public static Question questionCreator(HttpServletRequest req) {
		  Question question = new Question();
		  question.setId(new ObjectId());
		  question.setContent(req.getParameter("content"));
		  question.setStatus(req.getParameter("status"));
		
		  question.setUId(req.getParameter("userId"));
		  
		  return question;
	}

}
