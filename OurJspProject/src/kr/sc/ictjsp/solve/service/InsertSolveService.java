package kr.sc.ictjsp.solve.service;

import java.security.Timestamp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import kr.sc.ictjsp.solve.model.SolveDAO;
import kr.sc.ictjsp.solve.model.SolveVO;
import kr.sc.ictjsp.test.model.TestDAO;
import kr.sc.ictjsp.test.model.TestVO;


public class InsertSolveService implements SolveService{
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = null;
		session = request.getSession();
		
		String code = (String)request.getParameter("tcode");
		String rsolve = (String)request.getParameter("solve");
		String suser = (String)request.getParameter("suser");
		
		TestDAO dao = TestDAO.getInstance();
		TestVO question = new TestVO();
		question = dao.GetTest(code);
		
		request.setAttribute("question", question);
		
		//intcode의 줄인말
		System.out.println("사용자가 풀고 있는 코드 : " + code);
		int icode = Integer.parseInt(code);
		
		SolveDAO dao1 = SolveDAO.getInstance();
		SolveVO solve = new SolveVO();
		
		
		
		solve.setTcode(icode);
		solve.setSolve(rsolve);
		solve.setSuer(suser);
		
		int result = dao1.InsertSolve(solve);
		
		if(result == 1) {
			System.out.println("답안 작성 완료");
			session.setAttribute("check", solve);
			
		} else if(result ==0) {
			System.out.println("답안 작성 실패");
		}
	}
}
