package kr.sc.ictjsp.test.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.sc.ictjsp.test.model.TestDAO;
import kr.sc.ictjsp.test.model.TestVO;

public class TestDetailService implements TestService{
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String code = request.getParameter("tcode");
		System.out.println("test code : " + code);
		//int icode = Integer.parseInt(code);
		TestDAO dao = TestDAO.getInstance();
		
		TestVO question = dao.GetTest(code);
		
		request.setAttribute("question", question);
		
		System.out.println(question);
	}

}
