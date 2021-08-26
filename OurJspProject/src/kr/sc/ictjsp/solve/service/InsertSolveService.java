package kr.sc.ictjsp.solve.service;

import java.sql.Timestamp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.sc.ictjsp.question.model.QuestionDAO;
import kr.sc.ictjsp.question.model.QuestionVO;
import kr.sc.ictjsp.solve.model.SolveDAO;
import kr.sc.ictjsp.solve.model.SolveVO;


public class InsertSolveService implements SolveService{
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = null;
		session = request.getSession();
		
		String code = (String)request.getParameter("qcode");
		String answer = (String)request.getParameter("answer");
		
	
		QuestionDAO dao = QuestionDAO.getInstance();
		QuestionVO question = new QuestionVO();
		question = dao.Getquestion(code);
		
		request.setAttribute("question", question);
		
		//intcode의 줄인말
		System.out.println(code);
		int icode = Integer.parseInt(code);
		
		
		SolveVO solve = new SolveVO();
		
		solve.setQcode(icode);
		solve.setAnswer(answer);
		
		request.setAttribute("squestion", solve);
		
		int result = dao.InsertSolve(solve);
		
		if(result == 1) {
			System.out.println("답안 작성 완료");
			//session.setAttribute("q_code", solve);
			
		} else if(result ==0) {
			System.out.println("답안 작성 실패");
		}
	}
}
