package kr.sc.ictjsp.solve.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import kr.sc.ictjsp.solve.model.SolveDAO;
import kr.sc.ictjsp.test.model.TestDAO;
import kr.sc.ictjsp.test.model.TestVO;
import kr.sc.ictjsp.users.model.usersDAO;
import kr.sc.ictjsp.users.model.usersVO;


public class CheckService implements SolveService{
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		//정답 체크해주는 서비스
		try {
			
			String code = (String)request.getParameter("code");
			String solve =(String)request.getParameter("solve");
			String reuser = (String)request.getParameter("suser");
			
			System.out.println("test " + reuser);
			
			usersDAO udo = usersDAO.getInstance();
			usersVO user = new usersVO();
			user.setUid(reuser);
			
			
			user = udo.usergetinfo(user);
			
			int Tcode = Integer.parseInt(code);
			user.setUqcode(Tcode);
			
			System.out.println("현재 user 정보" + user);
			System.out.println("checkservice에서 코드" + Tcode);
			System.out.println("checkservice에서 답" + solve);
			
			SolveDAO sdao = SolveDAO.getInstance();
		
			TestDAO dao = TestDAO.getInstance();
			TestVO test = new TestVO();
			test = dao.GetTest(code);
			
			request.setAttribute("question", test);
			
			System.out.println(code + "에 대한 문제" + test);
			
			int result = sdao.Check(test, solve);
			
			if(result==1) {
				System.out.println("정답입니다.");
				sdao.SolvedWhether(Tcode);
			}else {
				System.out.println("정답이 아닙니다.");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
