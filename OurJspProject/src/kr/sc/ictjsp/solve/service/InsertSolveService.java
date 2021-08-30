package kr.sc.ictjsp.solve.service;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import kr.sc.ictjsp.solve.model.SolveDAO;
import kr.sc.ictjsp.solve.model.SolveVO;
import kr.sc.ictjsp.users.model.usersDAO;
import kr.sc.ictjsp.users.model.usersVO;


public class InsertSolveService implements SolveService{
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = null;
		session = request.getSession();
		
		String recode = (String)request.getParameter("tcode");
		String rsolve = (String)request.getParameter("solve");
		String suser = (String)request.getParameter("suser");
		
		int tcode = Integer.parseInt(recode);
		
		System.out.println("form에서 입력한 값 " + tcode + rsolve + suser);
		
		SolveDAO sdao = SolveDAO.getInstance();
		SolveVO s_user = new SolveVO();
		s_user.setTcode(tcode);
		s_user.setSolve(rsolve);
		s_user.setSuer(suser);
		
		usersDAO udo = usersDAO.getInstance();
		usersVO user = new usersVO();
		
		int result = sdao.InsertSolve(s_user);
		
		if(result == 1) {
			System.out.println("답안 작성 완료");
			request.setAttribute("solve_code", s_user.getTcode());
			request.setAttribute("solve_solve", s_user.getSolve());
			request.setAttribute("solve_user", s_user.getSuer());
			System.out.println("푼사람 " + s_user.getSuer());
			
			//답안 작성 후 uid를 가지고 Uqcode를 userVO에 데이터 저장
			user.setUid(suser);
			System.out.println(user.getUid() + "의 저장된  정보");
			udo.usergetinfo(user);
			
			user.setUqcode(recode);
			sdao.userInsertCode(user);
			
			request.setAttribute("userInsert", user.getUqcode());
			System.out.println("답안 제출 후 유저 정보 : " + user);
		} else if(result ==0) {
			System.out.println("답안 작성 실패");
		}
	}
}


