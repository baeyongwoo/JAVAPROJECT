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
	
	private int htmlcode = 1000;
	private int csscode = 2000;
	private int javacode = 3000;
	private int jspcode = 4000;
	
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
	
	public int InsertQuestion(QuestionVO question, int code) {
			
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			
			con = ds.getConnection();
			switch (code) {
			case 1: 
				String sql1 = "INSERT INTO question VALUES("+htmlcode+", ?)";
				pstmt = con.prepareStatement(sql1);
				pstmt.setString(1, question.getquestion());
				
				pstmt.executeUpdate();
				htmlcode++;
				break;
			case 2:
				String sql2 = "INSERT INTO question VALUES("+csscode+", ?)";
				pstmt = con.prepareStatement(sql2);
				pstmt.setString(1, question.getquestion());
				
				pstmt.executeUpdate();
				csscode++;
				break;
			case 3:
				String sql3 = "INSERT INTO question VALUES("+javacode+", ?)";
				pstmt = con.prepareStatement(sql3);
				pstmt.setString(1, question.getquestion());
				
				pstmt.executeUpdate();
				javacode++;
				break;
			case 4:
				String sql4 = "INSERT INTO question VALUES("+jspcode+", ?)";
				pstmt = con.prepareStatement(sql4);
				pstmt.setString(1, question.getquestion());
				
				pstmt.executeUpdate();
				jspcode++;
				break;
			}	
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
		
	
		String sql = "SELECT * FROM question ORDER BY qcode DESC";

		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				QuestionVO questionData = new QuestionVO();
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
	
	
	
	
	public QuestionVO Getquestion(int qcode) {
		
		QuestionVO dbquestion = new QuestionVO();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		
		try {
			
			con = ds.getConnection();
			String sql = "SELECT * FROM question WHERE qcode = ?";

			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, qcode);
					
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				dbquestion.setqcode(qcode);
				dbquestion = Getquestion(qcode);
				System.out.println(dbquestion + "여기는 DAO");
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
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return dbquestion;
		
	} // end Getquestion
}
