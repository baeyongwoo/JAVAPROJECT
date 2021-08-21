package kr.sc.ictjsp.correct.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface CorrectService {
	void execute(HttpServletRequest request, HttpServletResponse response);
}
