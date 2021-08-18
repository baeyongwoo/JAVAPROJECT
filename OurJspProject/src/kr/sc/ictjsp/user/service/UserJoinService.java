package kr.sc.ictjsp.user.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.sc.ictjsp.users.model.usersDAO;
import kr.sc.ictjsp.users.model.usersVO;

public class UserJoinService implements BUserService{
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String uid = (String)request.getParameter("id");
		String upw = (String)request.getParameter("pw");
		String uname = (String)request.getParameter("name");
		String uemail = (String)request.getParameter("email");
		String ubirth = (String)request.getParameter("birth");
		String ugender = (String)request.getParameter("gender");
		
		
		usersDAO dao = usersDAO.getInstance();
		usersVO user = new usersVO(uid, upw, uname, uemail, ubirth, ugender);
		
		System.out.println(user);
		int result = dao.joinUsers(user);
		System.out.println("회원가입 성공 여부 : " + result);
			
	}

}
