package kr.sc.ictjsp.question.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.sc.ictjsp.question.model.QuestionDAO;
import kr.sc.ictjsp.question.model.QuestionVO;

public class QuestionDetailService implements QuestionService{
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String code = request.getParameter("qcode");
		//int icode = Integer.parseInt(code);
		QuestionDAO dao = QuestionDAO.getInstance();
		
		QuestionVO question = dao.Getquestion(code);
		
		request.setAttribute("question", question);
		
		System.out.println(question);
	}

}
