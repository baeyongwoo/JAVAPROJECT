package kr.sc.ictjsp.solve.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface SolveService {
	void execute(HttpServletRequest request, HttpServletResponse response);
}
