package kr.sc.ictjsp.users.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.sc.ictjsp.users.model.usersDAO;
import kr.sc.ictjsp.users.model.usersVO;

public class UserUpdateService implements BUserService{
	
	public void execute(HttpServletRequest request, HttpServletResponse response) {

		HttpSession session = null;
		session = request.getSession();
		
		try {
			request.setCharacterEncoding("utf-8");
			response.setCharacterEncoding("utf-8");
			String uid = (String) request.getParameter("uid");
			String upw = (String) request.getParameter("upw");
			String uemail = (String)request.getParameter("uemail");
			
			
			System.out.println("수정 요청 uid : " + uid + ", upw : " + upw + ", uemail : "+ uemail);
			
			usersDAO dao = usersDAO.getInstance();
			usersVO user = new usersVO();
			user.setUid(uid);
			user.setUpw(upw);
			user.setUemail(uemail);
			user.setUname(user.getUname());
			
			System.out.println("반영된 정보 : " + user);
			
			int result = dao.usersUpdate(user);
			
			if(result == 1) {
				System.out.println("회원정보 수정완료");
			} else if(result == 0) {
				System.out.println("회원정보 수정실패");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

}
