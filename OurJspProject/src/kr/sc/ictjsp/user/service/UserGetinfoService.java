package kr.sc.ictjsp.user.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.sc.ictjsp.users.model.usersDAO;
import kr.sc.ictjsp.users.model.usersVO;

public class UserGetinfoService implements BUserService{
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		//내 정보보기로 전달하는 로직
		String uid = (String)request.getParameter("uid");
		
		usersDAO dao = usersDAO.getInstance();
		usersVO user = new usersVO();
		
		dao.usergetinfo(user);
		
		
	}

	
}
