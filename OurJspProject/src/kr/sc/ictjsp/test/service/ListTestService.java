package kr.sc.ictjsp.test.service;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.sc.ictjsp.test.model.TestDAO;
import kr.sc.ictjsp.test.model.TestVO;



public class ListTestService implements TestService{
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {

		HttpSession session = request.getSession();
		List<TestVO> TList = new ArrayList<>();
		try {
			
			TestDAO dao = TestDAO.getInstance();
			TList = dao.TestGetInfo();
			//session.setAttribute("q_l", QList);
			//TList = session.getAttribute("q_l");
			request.setAttribute("t_l", TList);
			System.out.println(TList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

}
