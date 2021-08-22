package kr.sc.ictjsp.correct.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class CorrectDAO {

	//정답들 처음 db에 입력하기, 문제들 오류수정하기, 문제 삭제하기,
	private DataSource ds;
	
	private static final int INSERT_Co_SUCCESS = 1;
	private static final int INSERT_Co_FAIL = 0;
	private static final int UPDATE_Co_SUCCESS = 1;
	private static final int UPDATE_Co_FAIL = 0;
	private static final int DELETE_Co_SUCCESS = 1;
	private static final int DELETE_Co_FAIL = 0;
	
	private CorrectDAO () {
		
		try {
			Context ct = new InitialContext();
			ds = (DataSource)ct.lookup("java:comp/env/jdbc/mysql");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static CorrectDAO dao = new CorrectDAO();
	
	public static CorrectDAO getInstance() {
		return dao;
	}
	
	public int InsertCorrect(CorrectVO correct) {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			
			con = ds.getConnection();
			
			String sql = "INSERT INTO answer VALUES(NULL, ?)";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, correct.getCorrect());
			
			pstmt.executeUpdate();
			
			return INSERT_Co_SUCCESS;
		
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
		return INSERT_Co_FAIL;
	} // end InsertCorrect
	
	public int UpdateCorrect(CorrectVO correct) {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			
			con = ds.getConnection();
			
			String sql = "UPDATE correct set correct = ? WHERE ccode = ?";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, correct.getCorrect());
			pstmt.setInt(2, correct.getCcode());
			
			pstmt.executeUpdate();
			return UPDATE_Co_SUCCESS;
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
		return UPDATE_Co_FAIL;
	} // end UpdateCorrect
	
	public int DeleteCorrect(CorrectVO correct) {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			
			con = ds.getConnection();
			
			String sql = "DELETE from correct WHERE ccode = ?";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, correct.getCcode());
			pstmt.executeUpdate();
			
			return DELETE_Co_SUCCESS;
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
		return DELETE_Co_FAIL;
	} // end DeleteCorrect
}
