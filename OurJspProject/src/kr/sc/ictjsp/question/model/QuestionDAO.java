package kr.sc.ictjsp.question.model;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.*;
import java.sql.*;

public class QuestionDAO {

	//문제들 처음 db에 입력하기, 문제들 오류수정하기, 문제 삭제하기, 문제 보기
	
	private DataSource ds;
	
	private static final int INSERTQSUCCESS = 1;
	private static final int INSERTQFAIL = 0;
	private static final int UPDATEQSUCCESS = 1;
	private static final int UPDATEQFAIL = 0;
	private static final int DELETEQSUCCESS = 1;
	private static final int DELETEQFAIL = 0;
	
	private QuestionDAO() {
		
		try {
			Context ct = new InitialContext();
			ds = (DataSource)ct.lookup("java:comp/env/jdbc/mysql");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static QuestionDAO dao = new QuestionDAO();
	
	public static QuestionDAO getInstance() {
		return dao;
	}
	
	public int InsertQuestion(QuestionVO question) {
			
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			
			con = ds.getConnection();
			
			String sql = "INSERT INTO question VALUES(NULL, ?)";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, question.getquestion());
			
			pstmt.executeUpdate();
			
			return INSERTQSUCCESS;
			
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
		return INSERTQFAIL;
	} // end InsertQuestion
	
	public int UpdateQuestion(QuestionVO question) {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			
			con = ds.getConnection();
			String sql = "UPDATE question set question = ? WHERE qcode = ?";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, question.getquestion());
			pstmt.setInt(2, question.getqcode());
			
			pstmt.executeUpdate();
			return UPDATEQSUCCESS;
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
		return UPDATEQFAIL;
	} // end UpdateQuestion
	
	public int DeleteQuestion(QuestionVO question) {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			
			con = ds.getConnection();
			String sql = "DELETE from question WHERE qcode = ?";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, question.getqcode());
			pstmt.executeUpdate();
			
			return DELETEQSUCCESS;
		} catch (Exception e) {
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
		return DELETEQFAIL;
	} // end DeleteQuestion

/*
	public QuestionVO QuestionGetInfo(QuestionVO question) {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		QuestionVO questionData = new QuestionVO();
	
		try {
			con = ds.getConnection();
			String sql = "SELECT * FROM question WHERE qcode = ?";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, question.getqcode());
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				questionData.setqcode();
				questionData.setquestion("question");
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
		return questionData;
	} // end QuestionGetInfo
*/
}
