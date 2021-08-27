package kr.sc.ictjsp.solve.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.sc.ictjsp.correct.model.CorrectDAO;
import kr.sc.ictjsp.correct.model.CorrectVO;
import kr.sc.ictjsp.solve.model.SolveDAO;
import kr.sc.ictjsp.solve.model.SolveVO;
import kr.sc.ictjsp.users.model.usersDAO;
import kr.sc.ictjsp.users.model.usersVO;

public class CheckService implements SolveService{
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		//정답 체크해주는 서비스
		String qcode = (String)request.getParameter("qcode");
		String solve =(String)request.getParameter("answer");
		System.out.println("checkservice에서 코드" + qcode);
		System.out.println("checkservice에서 답" + solve);
		
		CorrectDAO dao = CorrectDAO.getInstance();
		CorrectVO correct = new CorrectVO();
		//정답 추출하는 로직 dao 만들기?
		
		SolveDAO sdao = SolveDAO.getInstance();
		SolveVO solve1 = new SolveVO();
		sdao.check(Solve, correct, question, users, code)
		
		//
		
	}

}
