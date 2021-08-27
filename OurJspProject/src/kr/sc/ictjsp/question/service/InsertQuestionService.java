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
			String questiontotalcount = (String) request.getParameter("QTcount"); 

			int ecode = Integer.parseInt(subjectcode);
			int qtcount = Integer.parseInt(questiontotalcount);

			System.out.println("선택한 코드 : " + ecode + "문제 : " + question);
			QuestionDAO dao = QuestionDAO.getInstance();
			QuestionVO Input_question = new QuestionVO(ecode, question, qtcount);

			int result = dao.InsertQuestion(Input_question, ecode);

			if (result == 1) {
				System.out.println("문제 생성 완료");
			} else if(result == 0){
				System.out.println("문제 생성 실패");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
