package kr.sc.ictjsp.correct.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.sc.ictjsp.answer.model.AnswerDAO;
import kr.sc.ictjsp.correct.model.CorrectDAO;
import kr.sc.ictjsp.correct.model.CorrectVO;

public class InsertCorrect implements CorrectService {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		try {
			request.setCharacterEncoding("utf-8");
			response.setCharacterEncoding("utf-8");
			
			String htmlcode = (String) request.getParameter("html");
			String correct = (String) request.getParameter("correct");

			int ccode = Integer.parseInt(htmlcode);

			System.out.println("선택한 코드 : " + ccode + "정답 : " + correct);
			CorrectDAO dao = CorrectDAO.getInstance();
			CorrectVO Input_correct = new CorrectVO(ccode, correct);

			int result = dao.InsertCorrect(Input_correct, ccode);

			if (result == 1) {
				System.out.println("답안지 생성 완료");
			} else if(result == 0){
				System.out.println("답안지 생성 실패");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
