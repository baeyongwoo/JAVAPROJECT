package kr.sc.ictjsp.solve.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import kr.sc.ictjsp.solve.model.SolveDAO;
import kr.sc.ictjsp.test.model.TestDAO;
import kr.sc.ictjsp.test.model.TestVO;
import kr.sc.ictjsp.tier.model.TierDAO;
import kr.sc.ictjsp.tier.model.TierVO;
import kr.sc.ictjsp.users.model.usersDAO;
import kr.sc.ictjsp.users.model.usersVO;

public class CheckService implements SolveService {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// 정답 체크해주는 서비스
		try {

			String code = (String) request.getParameter("code");
			String solve = (String) request.getParameter("solve");
			String reuser = (String) request.getParameter("suser");

			System.out.println("test " + reuser);

			usersDAO udo = usersDAO.getInstance();
			usersVO user = new usersVO();
			SolveDAO sdao = SolveDAO.getInstance();
			
			TestDAO dao = TestDAO.getInstance();
			
			TestVO test = new TestVO();
			
			user.setUid(reuser);
			user = udo.usergetinfo(user);
			System.out.println("현재 담겨져 있는 user 정보 : " + user);
			//int Tcode = Integer.parseInt(code);
			//user.setUqcode(code);
			//정답체크
			test = dao.GetTest(code);
			request.setAttribute("question", test);
			//정답체크
				int result = sdao.Check(test, solve);
				if(result == 1) {
					System.out.println("현재 유저 포인트 : " + user.getUpoint());
					user.setUpoint(user.getUpoint() + 1);
					System.out.println("포인트 적립 완료");
					udo.updatepoint(user);
					System.out.println("유저 포인트 획득 확인: " + user.getUpoint());
					
					System.out.println("TestList : " + dao.TestGetInfo());
					
					TierDAO tdo = TierDAO.getInstance();
					int tier = tdo.AdvanTier(user, dao.TestGetInfo());
					System.out.println("tier int형 " + tier);
					request.setAttribute("u_tier", tier);
					
				} else if(result == 0) {
					System.out.println("오답입니다.");
				}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
