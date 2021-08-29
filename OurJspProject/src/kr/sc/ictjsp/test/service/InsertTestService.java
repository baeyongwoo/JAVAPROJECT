package kr.sc.ictjsp.test.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.sc.ictjsp.test.model.TestDAO;
import kr.sc.ictjsp.test.model.TestVO;

public class InsertTestService implements TestService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		try {
			request.setCharacterEncoding("utf-8");
			response.setCharacterEncoding("utf-8");	
			
			String subjectcode = (String) request.getParameter("subject");
			String question = (String) request.getParameter("question");
			String correct = (String) request.getParameter("correct");
			String tuser = (String) request.getParameter("tuser");
			int tcode = Integer.parseInt(subjectcode);
			
			System.out.println("선택한 코드 : " + tcode + "문제 : " + question + "정답 : " + correct);
			TestDAO dao = TestDAO.getInstance();
			TestVO quser = new TestVO();	//quser 출제자
			quser.set
			
			int result = dao.InsertTest(tcode, question, correct);
			
			if(result == 1) {
				System.out.println("문제 생성 완료");
			} else if(result == 0) {
				System.out.println("문제 생성 실패");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
