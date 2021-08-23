package kr.sc.ictjsp.answer.model;

import javax.naming.*;
import javax.sql.*;
import java.sql.*;

public class AnswerDAO {

	private DataSource ds;
	
	//문제 코드, 누적문제코드, 풀은 사용자 아이디, 사용자가 푼 답, 풀은 날짜
	
	private final int INSERT_A_SUCCESS = 1;
	private final int INSERT_A_FAIL = 0;
	private final int EDIT_A_SUCCESS = 1;
	private final int EDIT_A_FAIL = 1;
	private final int DELETE_A_SUCCESS = 1;
	private final int DELETE_A_FAIL = 0;
	
	private AnswerDAO() {
		
		try {
			Context ct = new InitialContext();
			ds = (DataSource)ct.lookup("java:comp/env/jdbc/mysql");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static AnswerDAO dao = new AnswerDAO();
	
	public static AnswerDAO getInstance() {
		return dao;
	}
	
	public int InsertAnswer(AnswerVO answer) {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			
			con = ds.getConnection();
			
			String sql = "INSERT INTO answer VALUES (NULL, ?)";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, answer.getAnswer());
			
			pstmt.executeUpdate();
			
			return INSERT_A_SUCCESS;
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
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return INSERT_A_FAIL;
	} // end InsertAnswer
	
	public int EditAnswer(AnswerVO answer) {
		 
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			
			con = ds.getConnection();
			
			String sql = "UPDATE answer set answer = ? WHERE acode = ?";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, answer.getAnswer());
			pstmt.setInt(2, answer.getAcode());
			
			pstmt.executeUpdate();
			return EDIT_A_SUCCESS;
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
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return EDIT_A_FAIL;
	} // end EditAnswer
	
	public int DeleteAnswer(AnswerVO answer) {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			
			con = ds.getConnection();
			
			String sql = "DELETE from answer WHERE acode = ?";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, answer.getAcode());
			pstmt.executeUpdate();
			
			return DELETE_A_SUCCESS;
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
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		return DELETE_A_FAIL;
	} // end DeleteAnswer
}
