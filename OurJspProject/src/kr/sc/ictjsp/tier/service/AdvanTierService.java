package kr.sc.ictjsp.tier.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.sc.ictjsp.tier.model.TierDAO;
import kr.sc.ictjsp.tier.model.TierVO;



public class AdvanTierService implements TierService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		try {
			request.setCharacterEncoding("utf-8");
			response.setCharacterEncoding("utf-8");
		
			
			
			TierDAO dao = TierDAO.getInstance();
			TierVO Advan_tier = new TierVO();
			
			
		}
	}
}