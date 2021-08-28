package kr.sc.ictjsp.tier.model;

import javax.naming.*;
import javax.sql.*;

import java.sql.*;
public class TierDAO {
	
	private DataSource ds;
	
	private final int ADVANCEMENT_SUCCESS = 1;
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
	
	public int AdvanTier(int qtcount, int USQcount) {
				
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		TierVO tier = new TierVO();
		
		try {
			con = ds.getConnection();
			
			String sql = "SELECT count(?) from question";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, qtcount);
			
			pstmt.execute();
			if(rs.next()) {
				int dbqtcount = rs.getInt(qtcount);
				int dbusqcount = rs.getInt(USQcount);
				
				if(dbusqcount <= dbqtcount*0.05) {
					return tier.getUnranked();
				} else if(dbusqcount <= dbqtcount*0.15) {
					return tier.getBronze();
				} else if(dbusqcount <= dbqtcount*0.4) {
					return tier.getSilver();
				} else if(dbusqcount <= dbqtcount*0.65) {
					return tier.getGold();
				} else if(dbusqcount <= dbqtcount*0.85) {
					return tier.getPlatinum();
				} else if(dbusqcount <= dbqtcount*0.95) {
					return tier.getDiamond();
				} else 
					return tier.getRuby();
			}
			return ADVANCEMENT_SUCCESS;
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(con != null && !con.isClosed()) {
					con.close();
				}
				if(pstmt != null && !pstmt.isClosed()) {
					pstmt.close();
				}
				if(rs != null && !rs.isClosed()) {
					rs.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return ADVANCEMENT_FAIL;
					
	}

}
