package kr.sc.ictjsp.test.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TestCheckService implements TestService{
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		//사용자가 입력한 답과 정답비교하는 서비스
		String ex1 =(String)request.getParameter("ex1");
		String ex2 =(String)request.getParameter("ex2");
		String ex3 =(String)request.getParameter("ex3");
		String ex4 =(String)request.getParameter("ex4");
		String ex5 =(String)request.getParameter("ex5");
		
		htmltestDAO dao = htmltestDAO.getinstance();
		htmltestVO answer = new htmltestVO(ex1, ex2, ex3, ex4, ex5);
		
		dao.answer(answer);
		
		
		
	}
}
