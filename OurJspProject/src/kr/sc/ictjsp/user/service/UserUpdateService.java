package kr.sc.ictjsp.user.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.sc.ictjsp.users.model.usersDAO;
import kr.sc.ictjsp.users.model.usersVO;

public class UserUpdateService implements BUserService{
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {

		HttpSession session = null;
		session = request.getSession();
		
		try {
			request.setCharacterEncoding("utf-8");
			response.setCharacterEncoding("utf-8");
			String uid = (String) request.getParameter("id");
			String upw = (String) request.getParameter("pw");
			String uname = (String) request.getParameter("name");
			String uemail = (String) request.getParameter("email");
			String ubirth = (String) request.getParameter("birth");
			String ugender = (String) request.getParameter("gender");
			
			usersDAO dao = usersDAO.getInstance();
			usersVO user = new usersVO(uid, upw, uname, uemail, ubirth, ugender);
			
			int result = dao.usersUpdate(user);
			System.out.println(uid);
			System.out.println(upw);
			System.out.println(uname);
			System.out.println(ubirth);
			System.out.println(ugender);
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
