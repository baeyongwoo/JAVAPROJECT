package kr.sc.ictjsp.users.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.sc.ictjsp.users.model.usersDAO;
import kr.sc.ictjsp.users.model.usersVO;

public class UserDeleteService implements BUserService{
	
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		try {
		
		String uid = (String)request.getParameter("id");
		String upw = (String)request.getParameter("pw");
		
		System.out.println("삭제할 id : " + uid + "비밀번호 확인 : " + upw);
		HttpSession session = null;
		session = request.getSession();
		
		usersDAO dao = usersDAO.getInstance();
		usersVO user = new usersVO();
		user.setUid(uid);
		user.setUpw(upw);
		
		int result = dao.usersDelete(user, upw);
		
		if(result == 1) {
			session.setAttribute("u_delete", uid);
			System.out.println(uid + "님 회원탈퇴 하셨습니다.");
		} else if(result == 0){
			System.out.println(uid + "님 회원탈퇴 실패");
			session.setAttribute("u_delete_fail", "fail");
		}
		
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
