package kr.sc.ictjsp.users.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.sc.ictjsp.users.model.usersDAO;
import kr.sc.ictjsp.users.model.usersVO;

public class UserGetinfoService implements BUserService{
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		//�궡 �젙蹂대낫湲곕줈 �쟾�떖�븯�뒗 濡쒖쭅
		String uid = (String)request.getParameter("uid");
		
		usersDAO dao = usersDAO.getInstance();
		usersVO user = new usersVO();
		
		dao.usergetinfo(user);
		
		
	}

	
}
