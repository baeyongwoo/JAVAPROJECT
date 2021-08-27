package kr.sc.ictjsp.users.service;

import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



public class UserLogoutService implements BUserService{
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		HttpSession session = request.getSession();
				
		//(HttpSession) request.getAttribute("login_start");
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
		String time = formatter.format(session.getLastAccessedTime());
		request.setAttribute("logout", time);
		System.out.println("로그아웃 시간 : " + time);
		
		request.setAttribute("logout", time);
		session.invalidate();
		
	}

}
