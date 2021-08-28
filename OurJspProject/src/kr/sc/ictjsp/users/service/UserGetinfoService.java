package kr.sc.ictjsp.users.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.sc.ictjsp.users.model.usersDAO;
import kr.sc.ictjsp.users.model.usersVO;

public class UserGetinfoService implements BUserService{
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		usersDAO dao = usersDAO.getInstance();
		usersVO user = new usersVO();
		
		user.setUid(user.getUid());
		user.setUtier(user.getUtier());
		user.setUemail(user.getUemail());
		user.setSubject(user.getSubject());
		dao.usergetinfo(user);
		
		
		System.out.println("user정보 : " + user);
		
	}

	
}
