package kr.sc.ictjsp.test.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.sc.ictjsp.test.model.TestDAO;
import kr.sc.ictjsp.test.model.TestVO;
import kr.sc.ictjsp.users.model.usersDAO;
import kr.sc.ictjsp.users.model.usersVO;

public class TestDetailService implements TestService {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String code = request.getParameter("tcode");
		System.out.println("test code : " + code);
		// int icode = Integer.parseInt(code);
		TestDAO dao = TestDAO.getInstance();

		TestVO question = dao.GetTest(code);

		// user.setUid(uid);

		request.setAttribute("question", question);

		System.out.println("문제 정보 : " + question);

		usersDAO udao = usersDAO.getInstance();
		usersVO user = new usersVO();

		HttpSession session = request.getSession();
		String uid = (String) session.getAttribute("u_id");

		user.setUid(uid);

		request.setAttribute("u_id", user.getUid());
		System.out.println("유저 아이디 : " + user.getUid());
	}

}
