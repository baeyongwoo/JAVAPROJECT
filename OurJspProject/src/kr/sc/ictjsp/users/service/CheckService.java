package kr.sc.ictjsp.users.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.sc.ictjsp.correct.model.CorrectDAO;
import kr.sc.ictjsp.correct.model.CorrectVO;
import kr.sc.ictjsp.question.model.QuestionDAO;
import kr.sc.ictjsp.solve.model.SolveDAO;

public class CheckService implements BUserService{
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {

		CorrectDAO cdao = CorrectDAO.getInstance();
		SolveDAO sdao = SolveDAO.getInstance();
		
//		CorrectVO correct = new CorrectVO(ccode, correct);

		
	}
}
