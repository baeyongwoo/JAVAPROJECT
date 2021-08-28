package kr.sc.ictjsp.solve.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import kr.sc.ictjsp.solve.model.SolveDAO;


public class CheckService implements SolveService{
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		//정답 체크해주는 서비스
		try {
			String code = (String)request.getParameter("qcode");
			String solve =(String)request.getParameter("answer");
			
			int Tcode = Integer.parseInt(code);
			
			System.out.println("checkservice에서 코드" + Tcode);
			System.out.println("checkservice에서 답" + solve);
			
			SolveDAO sdao = SolveDAO.getInstance();
		
			sdao.Check(Tcode, solve);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
