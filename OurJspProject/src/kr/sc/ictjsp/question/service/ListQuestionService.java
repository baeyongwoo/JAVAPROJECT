package kr.sc.ictjsp.question.service;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.sc.ictjsp.question.model.QuestionDAO;
import kr.sc.ictjsp.question.model.QuestionVO;

public class ListQuestionService implements QuestionService{
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {

		HttpSession session = request.getSession();
		List<QuestionVO> QList = new ArrayList<>();
		try {
			
			QuestionDAO dao = QuestionDAO.getInstance();
			QList = dao.QuestionGetInfo();
			session.setAttribute("q_l", QList);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

}
