package kr.sc.ictjsp.test.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.sc.ictjsp.test.model.TestDAO;

public class UpdateTestService implements TestService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {

		try {
			request.setCharacterEncoding("utf-8");
			response.setCharacterEncoding("utf-8");
			
			String utquestion = (String) request.getParameter("utquestion");
			String code = (String) request.getParameter("code");
			int utcode = Integer.parseInt(code);
			
			TestDAO dao = TestDAO.getInstance();
			dao.UpdateTest(utquestion, utcode);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
