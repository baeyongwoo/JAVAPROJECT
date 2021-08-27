package kr.sc.ictjsp.tier.model;

import javax.naming.*;
import javax.sql.*;

import kr.sc.ictjsp.question.model.QuestionVO;
import kr.sc.ictjsp.users.model.usersVO;

import java.sql.*;
public class TierDAO {
	
	private DataSource ds;
	
	private final int ADVANCEMENT_FAIL = 0;
	
	private TierDAO() {
	
		try {
			Context ct = new InitialContext();
			ds = (DataSource)ct.lookup("java:comp/env/jdbc/mysql");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static TierDAO dao = new TierDAO();
	
	public static TierDAO getInstance() {
		return dao;
	}
	
	public int AdvanTier(TierVO tier, QuestionVO question, usersVO user) {
		
		Connection con = null;
		int supoint = user.getPoint();
		int qtcount = question.getQtcount();
				
		try {
			con = ds.getConnection();
			if(supoint <= (qtcount*0.05)) {
				return tier.getUnranked();
			} else if(supoint <= (qtcount*0.15)) {
				return tier.getBronze();
			} else if(supoint <= (qtcount*0.4)) {
				return tier.getSilver();
			} else if(supoint <= (qtcount*0.65)) {
				return tier.getGold();
			} else if(supoint <= (qtcount*0.85)) {
				return tier.getPlatinum();
			} else if(supoint <= (qtcount*0.95)) {
				return tier.getDiamond();
			} else {
				return tier.getRuby();
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(con != null && !con.isClosed()) {
					con.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return ADVANCEMENT_FAIL;
			
	}

}
