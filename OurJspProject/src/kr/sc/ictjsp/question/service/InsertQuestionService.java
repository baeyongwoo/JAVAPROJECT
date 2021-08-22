package kr.sc.ictjsp.question.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.sc.ictjsp.question.model.QuestionDAO;
import kr.sc.ictjsp.question.model.QuestionVO;
import kr.sc.ictjsp.users.model.usersDAO;
import kr.sc.ictjsp.users.model.usersVO;

public class InsertQuestionService implements QuestionService {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		try {
			request.setCharacterEncoding("utf-8");
			response.setCharacterEncoding("utf-8");
			
			String q_code = (String) request.getParameter("qcode");
			String question = (String) request.getParameter("question");

			int qcode = Integer.parseInt(q_code);

			QuestionDAO dao = QuestionDAO.getInstance();
			QuestionVO Input_question = new QuestionVO(qcode, question);

			int result = dao.InsertQuestion();

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
