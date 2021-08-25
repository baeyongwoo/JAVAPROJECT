package kr.sc.ictjsp.answer.service;

import java.sql.Timestamp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import kr.sc.ictjsp.answer.model.AnswerDAO;
import kr.sc.ictjsp.answer.model.AnswerVO;


public class InsertAnswerService implements AnswerService{
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = null;
		session = request.getSession();
		
		String Ssubject = (String)request.getParameter("subject");
		String answer = (String)request.getParameter("answer");
		//String sovle = (String)request.getParameter("time");
		//String name = (String)request.getParameter(name);
		
		int subject = Integer.parseInt(Ssubject);
		//Timestamp sovletime = Timestamp.valueOf(sovle);
		
		AnswerDAO dao = AnswerDAO.getInstance();
		AnswerVO u_answer = new AnswerVO();
		u_answer.setQcode(subject);
		u_answer.setAnswer(answer);
		//u_answer.setSolvedate(sovletime);
		
		int result = dao.InsertAnswer(u_answer);
		
		if(result == 1) {
			System.out.println("답안 작성 완료");
			session.setAttribute("q_code", subject);
			
		} else if(result ==0) {
			System.out.println("답안 작성 실패");
		}
	}
}
