package kr.sc.ictjsp.question.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.sc.ictjsp.question.model.QuestionDAO;
import kr.sc.ictjsp.question.model.QuestionVO;

public class SelectQuestionService implements QuestionService{
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		try {
			
			String qcode = request.getParameter("qcode");
			//intcode 약자
			QuestionDAO dao = QuestionDAO.getInstance();
			QuestionVO question = new QuestionVO();
			question = dao.Getquestion(qcode);
			
			
			request.setAttribute("question", question);
			
			System.out.println(question);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
