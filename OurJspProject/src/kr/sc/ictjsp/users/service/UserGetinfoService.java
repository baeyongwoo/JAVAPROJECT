package kr.sc.ictjsp.users.service;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.sc.ictjsp.users.model.usersDAO;
import kr.sc.ictjsp.users.model.usersVO;

public class UserGetinfoService implements BUserService {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {

		usersDAO dao = usersDAO.getInstance();
		usersVO user = new usersVO();
		
		HttpSession session = request.getSession();
		String uid = (String)session.getAttribute("u_ids");
		
		user.setUid(uid);
		
		user = dao.usergetinfo(user);
		
		request.setAttribute("u_id", user.getUid());
		request.setAttribute("u_name", user.getUname());
		request.setAttribute("u_email", user.getUemail());
		request.setAttribute("u_subject", user.getSubject());
		request.setAttribute("u_qcode", user.getUqcode());
		request.setAttribute("u_point", user.getUpoint());
		request.setAttribute("u_tier", user.getUtier());
		
		System.out.println("user의 정보 : " + user);

	}
}
