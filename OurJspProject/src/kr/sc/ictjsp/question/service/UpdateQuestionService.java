package kr.sc.ictjsp.question.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UpdateQuestionService implements QuestionService{
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {

		try {
			request.setCharacterEncoding("utf-8");
			response.setCharacterEncoding("utf-8");
			
			
		}
		
	}

}
