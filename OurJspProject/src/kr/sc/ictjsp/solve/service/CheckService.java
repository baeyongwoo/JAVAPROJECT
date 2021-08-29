package kr.sc.ictjsp.solve.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import kr.sc.ictjsp.solve.model.SolveDAO;


public class CheckService implements SolveService{
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		//정답 체크해주는 서비스
		try {
			String code = (String)request.getParameter("code");
			String solve =(String)request.getParameter("solve");
			
			int Tcode = Integer.parseInt(code);
			
			System.out.println("checkservice에서 코드" + Tcode);
			System.out.println("checkservice에서 답" + solve);
			
			SolveDAO sdao = SolveDAO.getInstance();
		
			int result = sdao.Check(Tcode, solve);
			if(result==1) {
				System.out.println("정답입니다.");
				
			}else {
				System.out.println("정답이 아닙니다.");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
