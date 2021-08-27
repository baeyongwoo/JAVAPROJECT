package kr.sc.ictjsp.board.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.*;

import kr.sc.ictjsp.question.model.QuestionVO;

public class boardDAO {
	
	private DataSource ds;
	
	private boardDAO() {
		
		try {
			Context ct = new InitialContext();
			ds = (DataSource)ct.lookup("ava:/comp/env/jdbc/mysql");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private static boardDAO dao = new boardDAO();
	
	public static boardDAO getInstance() {
		if(dao == null) {
			dao = new boardDAO();
		}
		return dao;
	}
	
public List<boardVO> boardList() {
		
		List<boardVO> Blist = new ArrayList<>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
	
		String sql = "SELECT * FROM board ORDER BY no DESC";

		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				boardVO boardData = new boardVO();
				boardData.setNo(rs.getInt("no"));
				boardData.setBtype(rs.getString("btype"));
				boardData.setBtitle(rs.getString("btitle"));
				boardData.setBwriter(rs.getString("bwriter"));
				boardData.setBcontent(rs.getString("bcontent"));
				boardData.setBhit(rs.getInt("bhit"));
				
				Blist.add(boardData);
			}
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
		return Blist;
	} // end QuestionGetInfo
}
