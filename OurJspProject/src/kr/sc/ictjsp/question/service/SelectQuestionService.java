package kr.sc.ictjsp.question.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.sc.ictjsp.question.model.QuestionDAO;
import kr.sc.ictjsp.question.model.QuestionVO;

public class SelectQuestionService implements QuestionService{
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		try {
			QuestionDAO dao = QuestionDAO.getInstance();
			QuestionVO question = new QuestionVO();
			
			request.setAttribute("s_q", dao.Getquestion(question));
			
			System.out.println(dao.Getquestion(question));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
	}

}
