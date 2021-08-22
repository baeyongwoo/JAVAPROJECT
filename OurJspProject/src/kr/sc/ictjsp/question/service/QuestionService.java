package kr.sc.ictjsp.question.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface QuestionService {

	void execute(HttpServletRequest request, HttpServletResponse response);
}
