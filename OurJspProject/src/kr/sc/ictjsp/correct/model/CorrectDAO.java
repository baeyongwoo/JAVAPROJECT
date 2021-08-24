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
	
	private int htmlcode = 1000;
	private int csscode = 2000;
	private int javacode = 3000;
	private int jspcode = 4000;
	
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
	
	public int InsertCorrect(CorrectVO correct, int code) {
		
		Connection con = null;
		PreparedStatement pstmt = null;
	
		try {
			
			con = ds.getConnection();
			switch (code) {
			case 1: 
				String sql1 = "INSERT INTO correct VALUES("+htmlcode+", ?)";
				pstmt = con.prepareStatement(sql1);
				pstmt.setString(1, correct.getCorrect());
				
				pstmt.executeUpdate();
				htmlcode++;
				break;
			case 2:
				String sql2 = "INSERT INTO correct VALUES("+csscode+", ?)";
				pstmt = con.prepareStatement(sql2);
				pstmt.setString(1, correct.getCorrect());
				
				pstmt.executeUpdate();
				csscode++;
				break;
			case 3:
				String sql3 = "INSERT INTO correct VALUES("+javacode+", ?)";
				pstmt = con.prepareStatement(sql3);
				pstmt.setString(1, correct.getCorrect());
				
				pstmt.executeUpdate();
				javacode++;
				break;
			case 4:
				String sql4 = "INSERT INTO correct VALUES("+jspcode+", ?)";
				pstmt = con.prepareStatement(sql4);
				pstmt.setString(1, correct.getCorrect());
				
				pstmt.executeUpdate();
				jspcode++;
				break;
			}	
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
