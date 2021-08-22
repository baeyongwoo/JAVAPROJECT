package kr.sc.ictjsp.question.model;

import javax.naming.*;
import javax.sql.*;
import java.sql.*;
import java.util.*;

public class QuestionDAO {
	
	private DataSource ds;
	
	private static final int INSERT_Q_SUCCESS = 1;
	private static final int INSERT_Q_FAIL = 0;
	private static final int UPDATE_Q_SUCCESS = 1;
	private static final int UPDATE_Q_FAIL = 0;
	private static final int DELETE_Q_SUCCESS = 1;
	private static final int DELETE_Q_FAIL = 0;
	
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
			
			return INSERT_Q_SUCCESS;
			
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
		return INSERT_Q_FAIL;
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
			return UPDATE_Q_SUCCESS;
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
		return UPDATE_Q_FAIL;
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
			
			return DELETE_Q_SUCCESS;
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
		return DELETE_Q_FAIL;
	} // end DeleteQuestion


	public List<QuestionVO> QuestionGetInfo() {
		
		List<QuestionVO> QList = new ArrayList<>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		QuestionVO questionData = new QuestionVO();
	
		String sql = "SELECT * FROM question ORDER BY qcode DESC";

		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				questionData.setqcode(rs.getInt("qcode"));
				questionData.setquestion(rs.getString("question"));
				
				QList.add(questionData);
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
		return QList;
	} // end QuestionGetInfo

}
