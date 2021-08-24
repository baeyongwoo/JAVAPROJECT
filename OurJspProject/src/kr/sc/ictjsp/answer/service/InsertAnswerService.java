package kr.sc.ictjsp.answer.service;

import java.sql.Timestamp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.sc.ictjsp.answer.model.AnswerDAO;
import kr.sc.ictjsp.answer.model.AnswerVO;


public class InsertAnswerService implements AnswerService{
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String Ssubject = (String)request.getParameter("subject");
		String answer = (String)request.getParameter("answer");
		String sovle = (String)request.getParameter("time");
		String name = (String)request.getParameter(name);
		
		int subject = Integer.parseInt(Ssubject);
		Timestamp sovletime = Timestamp.valueOf(sovle);
		
		AnswerDAO dao = AnswerDAO.getInstance();
		AnswerVO answer = new AnswerVO(null, Ssubject, name, answer, sovletime);
		
		int result = dao.InsertAnswer(answer);
		
		if(result == 1) {
			System.out.println("답안 작성 완료");
		} else if(result ==0) {
			System.out.println("답안 작성 실패");
		}
	}
}
