package kr.sc.ictjsp.correct.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.sc.ictjsp.answer.model.AnswerDAO;
import kr.sc.ictjsp.correct.model.CorrectDAO;
import kr.sc.ictjsp.correct.model.CorrectVO;

public class CorrectInsert implements CorrectService {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		try {
			request.setCharacterEncoding("utf-8");
			response.setCharacterEncoding("utf-8");
			
			String c_code = (String) request.getParameter("ccode");
			String correct = (String) request.getParameter("correct");

			int ccode = Integer.parseInt(c_code);

			System.out.println("코드 정보 : " + ccode + "정답 : " + correct);
			CorrectDAO dao = CorrectDAO.getInstance();
			CorrectVO Input_correct = new CorrectVO(ccode, correct);

			int result = dao.InsertCorrect(Input_correct);

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
