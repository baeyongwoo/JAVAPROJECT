package kr.sc.ictjsp.test.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.sc.ictjsp.test.model.TestDAO;

public class DeleteTestService implements TestService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		try {
			String DelQcode = (String)request.getParameter("DelQcode");
			int DQcode = Integer.parseInt(DelQcode);
			
			TestDAO dao = TestDAO.getInstance();
			dao.DeleteTest(DQcode);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
