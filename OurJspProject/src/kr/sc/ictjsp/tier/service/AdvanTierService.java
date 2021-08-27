package kr.sc.ictjsp.tier.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.sc.ictjsp.tier.model.TierDAO;
import kr.sc.ictjsp.tier.model.TierVO;

public class AdvanTierService implements TierService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
			String totalQcount = (String)request.getParameter("totalQcount");
			String solveUQcount = (String)request.getParameter("solveUQcount");
			
			int qtcount = Integer.parseInt(totalQcount);
			int USQcount = Integer.parseInt(solveUQcount);
			
			TierDAO tdao = TierDAO.getInstance();
			tdao.AdvanTier(qtcount, USQcount);
	}
}