package kr.sc.ictjsp.users.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.sc.ictjsp.users.model.usersDAO;
import kr.sc.ictjsp.users.model.usersVO;

public class UserLoginService implements BUserService{
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = null;
		session = request.getSession();
		

		try {
			request.setCharacterEncoding("utf-8");
			response.setCharacterEncoding("utf-8");
			String uid = (String)request.getParameter("id");
			String upw = (String)request.getParameter("pw");
			System.out.println("폼에서 날린 아이디 : " + uid + "//폼에서 날린 비번 : " + upw);
			
			usersDAO dao = usersDAO.getInstance();
			usersVO user = new usersVO();
			
			user.setUid(uid);
			user.setUpw(upw);
			
			System.out.println("user 객체 디버깅 : " + user);
			
			int result = dao.usersLogin(user);
			user = dao.usergetinfo(user);
			
			if(result == 1) {
				session.setAttribute("u_id", uid);
				session.setAttribute("u_pw", upw);
				session.setAttribute("u_name", dao.getName(uid));
				
				request.setAttribute("u_qcode", user.getQcode());
				request.setAttribute("u_point", user.getPoint());
				
			} else if(result == 0){
				System.out.println(uid + "님 로그인 실패");
				session.setAttribute("l_f", "fail");
//				long time = session.getLastAccessedTime();
//				System.out.println(time);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}
