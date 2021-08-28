package kr.sc.ictjsp.test.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.sc.ictjsp.test.model.TestDAO;
import kr.sc.ictjsp.test.model.TestVO;

public class SelectTestService implements TestService{
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		try {
			
			String Tcode = request.getParameter("Tcode");
			//intcode 약자
			TestDAO dao = TestDAO.getInstance();
			TestVO question = new TestVO();
			question = dao.GetTest(Tcode);
			
			
			request.setAttribute("question", question);
			
			System.out.println(question);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
