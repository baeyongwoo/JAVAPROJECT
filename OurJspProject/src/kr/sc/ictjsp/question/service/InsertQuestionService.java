package kr.sc.ictjsp.question.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.sc.ictjsp.test.model.TestDAO;



public class InsertQuestionService implements QuestionService {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		try {
			request.setCharacterEncoding("utf-8");
			response.setCharacterEncoding("utf-8");
			
			String subjectcode = (String) request.getParameter("subject");
			String question = (String) request.getParameter("question");
			String correct = (String) request.getParameter("correct");
			String qsuser = (String) request.getParameter("qsuser");
			
			int ecode = Integer.parseInt(subjectcode);
				
			System.out.println("선택한 코드 : " + ecode + "문제 : " + question);
			TestDAO dao = TestDAO.getInstance();
			int result = dao.InsertTest(ecode, question, correct, qsuser);
			
			if (result == 1) {
				System.out.println("문제 생성 완료");
			} else if(result == 0){
				System.out.println("문제 생성 실패");
			}
			int Qtcount = dao.CountTQuestion();
			System.out.println("총 문제 갯수 : " + Qtcount);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
