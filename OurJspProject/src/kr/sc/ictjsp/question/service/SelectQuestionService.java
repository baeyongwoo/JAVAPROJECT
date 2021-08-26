package kr.sc.ictjsp.question.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.sc.ictjsp.question.model.QuestionDAO;
import kr.sc.ictjsp.question.model.QuestionVO;

public class SelectQuestionService implements QuestionService{
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		try {
			
			String q = (request.getParameter("qcode"));
			int inputqcode = Integer.parseInt(q);
			
			QuestionDAO dao = QuestionDAO.getInstance();
			QuestionVO qcodeVO = new QuestionVO();
			qcodeVO = dao.Getquestion(inputqcode);
			
			
			request.setAttribute("qcodeVO", qcodeVO);
			System.out.println(qcodeVO.getqcode() + "두줄은 서비스");
			System.out.println(qcodeVO.getquestion());
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
	}

}
