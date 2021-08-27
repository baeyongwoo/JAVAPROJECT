package kr.sc.ictjsp.tier.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface TierService {
	
	void execute(HttpServletRequest request, HttpServletResponse response);

}