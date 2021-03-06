package kr.sc.ictjsp.users.service;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.sc.ictjsp.users.model.usersDAO;
import kr.sc.ictjsp.users.model.usersVO;

public class UserJoinService implements BUserService {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		try {
			request.setCharacterEncoding("utf-8");
			response.setCharacterEncoding("utf-8");
			String uid = (String)request.getParameter("uid");
			String upw = (String)request.getParameter("upw");
			String uname = (String)request.getParameter("uname");
			String uemail = (String)request.getParameter("uemail");
			String usubject = (String)request.getParameter("subject");
					
			usersDAO dao = usersDAO.getInstance();
			usersVO user = new usersVO(uid, upw, uname, uemail, usubject, null, 0, 0);
			System.out.println(user);

			int result = dao.joinUsers(user);
		
			System.out.println("회원가입 성공 여부 : " + result);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
