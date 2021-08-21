package kr.sc.ictjsp.quest.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface QuestService {

	void execute(HttpServletRequest request, HttpServletResponse response);
}
