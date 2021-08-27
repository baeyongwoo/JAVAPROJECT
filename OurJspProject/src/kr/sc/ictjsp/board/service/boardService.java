package kr.sc.ictjsp.board.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface boardService {
	void execute(HttpServletRequest requset, HttpServletResponse response);
}
