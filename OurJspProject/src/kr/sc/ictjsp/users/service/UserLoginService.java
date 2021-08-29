package kr.sc.ictjsp.users.service;

import java.text.SimpleDateFormat;

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
			System.out.println("사용자 입력 아이디 : " + uid + "//사용자 입력 비번 : " + upw);
			
			usersDAO dao = usersDAO.getInstance();
			usersVO user = new usersVO();
			
			user.setUid(uid);
			user.setUpw(upw);
			
			
			int result = dao.usersLogin(user);
			
			if(result == 1) {
				
				session.setAttribute("u_ids", uid);
				session.setAttribute("u_pws", upw);
				request.setAttribute("u_id", user.getUid());
				request.setAttribute("u_name", user.getUname());
				request.setAttribute("u_email", user.getUemail());
				request.setAttribute("u_subject", user.getSubject());
				request.setAttribute("u_qcode", user.getUqcode());
				request.setAttribute("u_point", user.getUpoint());
				request.setAttribute("u_tier", user.getUtier());
				
				user = dao.usergetinfo(user);
				System.out.println(user.getUid() + "의 정보 : " + user);
				

				SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
				
				String time = formatter.format(session.getCreationTime());
				request.setAttribute("login", time);
				System.out.println("최초 로그인 시간 : " + time);
			} 
			else if(result == 0){
				System.out.println(uid + "님 로그인 실패");
				session.setAttribute("l_f", "fail");
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}
