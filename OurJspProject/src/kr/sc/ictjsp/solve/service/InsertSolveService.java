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
		
		String recode = (String)request.getParameter("tcode");
		String rsolve = (String)request.getParameter("solve");
		String suser = (String)request.getParameter("suser");
		
		int tcode = Integer.parseInt(recode);
		
		//System.out.println("form에서 입력한 값 " + tcode + rsolve + suser);
		
		SolveDAO dao = SolveDAO.getInstance();
		SolveVO s_user = new SolveVO();
		s_user.setTcode(tcode);
		s_user.setSolve(rsolve);
		s_user.setSuer(suser);
		
		int result = dao.InsertSolve(s_user);
		
		if(result == 1) {
			System.out.println("답안 작성 완료");
			session.setAttribute("check", s_user);
			
		} else if(result ==0) {
			System.out.println("답안 작성 실패");
		}
	}
}


