package kr.sc.ictjsp.tier.model;

import kr.sc.ictjsp.test.model.TestVO;
import kr.sc.ictjsp.users.model.usersVO;
import java.util.List;
public class TierDAO {
	
	
	private TierDAO() {
	

	}
	
	public static TierDAO dao = new TierDAO();
	
	
	public static TierDAO getInstance() {
		return dao;
	}
	
	public int AdvanTier(usersVO user, List<TestVO> Tlst) {
				
		TierVO tier = new TierVO();
		int point = user.getUpoint();
		int tlistsize = Tlst.size();
		
		System.out.println("user 포인트 : " + point);
		System.out.println("tlst 사이즈 : " + Tlst.size());
		
				if(point <= tlistsize*0.05) {
					return tier.getUnranked();
				} else if(point <= tlistsize*0.15) {
					return tier.getBronze();
				} else if(point <= tlistsize*0.4) {
					return tier.getSilver();
				} else if(point <= tlistsize*0.65) {
					return tier.getGold();
				} else if(point <= tlistsize*0.85) {
					return tier.getPlatinum();
				} else if(point <= tlistsize*0.95) {
					return tier.getDiamond();
				} else 
					return tier.getRuby();
	}
}
