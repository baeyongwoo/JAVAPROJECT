package kr.sc.ictjsp.solve.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import kr.sc.ictjsp.solve.model.SolveDAO;
import kr.sc.ictjsp.test.model.TestDAO;
import kr.sc.ictjsp.test.model.TestVO;
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
			user.setUid(reuser);

			user = udo.usergetinfo(user);

			//int Tcode = Integer.parseInt(code);
			user.setUqcode(code);

			System.out.println("현재 user 정보" + user);

			SolveDAO sdao = SolveDAO.getInstance();

			TestDAO dao = TestDAO.getInstance();
			TestVO test = new TestVO();
			test = dao.GetTest(code);

			request.setAttribute("question", test);

			int result = sdao.Check(test, solve);

			int checkresult = sdao.SolvedWhether(user, code);
			
			if(result == 1 && checkresult == 1) {
				System.out.println("정답입니다. 포인트 1증가");
				user.setUpoint(user.getUpoint() + 1);
				udo.updatepoint(user);
			} else if(result ==1 && checkresult ==0) {
				System.out.println("정답이지만, 중복으로 풀어서 포인트 없습니다.");
				
			}else {
				System.out.println("오답입니다.");
			}
			
			
//			if (result == 1) {
//				System.out.println("정답입니다.");
//				
//				if (checkresult == 1) {
//					System.out.println("중복");
//					user.setUpoint(user.getUpoint());
//					udo.updatepoint(user);
//					
//				} else if(checkresult == 0){
//					
//					user.setUpoint(user.getUpoint() + 1);
//					udo.updatepoint(user);
//				}
//				System.out.println("정답일때 userpoint 확인" + user);
//			} else {
//				System.out.println("정답이 아닙니다.");
//			}
			
			
			

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
