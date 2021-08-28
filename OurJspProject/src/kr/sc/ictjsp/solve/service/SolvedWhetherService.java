package kr.sc.ictjsp.solve.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.sc.ictjsp.solve.model.SolveDAO;

public class SolvedWhetherService implements SolveService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		String UserSNum = (String)request.getParameter("qcode");
		int USNum = Integer.parseInt(UserSNum);
		
		SolveDAO dao = SolveDAO.getInstance();
		int result = dao.SolvedWhether(USNum);
		
		request.setAttribute("SW", result);
	}

	
}
