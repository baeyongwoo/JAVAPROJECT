package kr.sc.ictjsp.users.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.sc.ictjsp.solve.model.SolveDAO;
import kr.sc.ictjsp.test.model.TestDAO;

public class CheckService implements BUserService{
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {

		TestDAO tdao = TestDAO.getInstance();
		SolveDAO sdao = SolveDAO.getInstance();
		
//		CorrectVO correct = new CorrectVO(ccode, correct);

		
	}
}
