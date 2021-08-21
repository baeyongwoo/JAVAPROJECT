package kr.sc.ictjsp.answer.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface AnswerService {
	void execute(HttpServletRequest request, HttpServletResponse response);
}
