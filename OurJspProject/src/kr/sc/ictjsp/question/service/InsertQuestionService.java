package kr.sc.ictjsp.question.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.sc.ictjsp.question.model.QuestionDAO;
import kr.sc.ictjsp.question.model.QuestionVO;

public class InsertQuestionService implements QuestionService {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		try {
			request.setCharacterEncoding("utf-8");
			response.setCharacterEncoding("utf-8");
			
			String subjectcode = (String) request.getParameter("subject");
			String question = (String) request.getParameter("question");
			
			int ecode = Integer.parseInt(subjectcode);
				
			System.out.println("선택한 코드 : " + ecode + "문제 : " + question);
			QuestionDAO dao = QuestionDAO.getInstance();
			int result = dao.InsertQuestion(ecode, question);
			
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
