package kr.sc.ictjsp.answer.model;

import javax.naming.*;
import javax.sql.*;

import kr.sc.ictjsp.correct.model.CorrectDAO;
import kr.sc.ictjsp.correct.model.CorrectVO;
import kr.sc.ictjsp.question.model.QuestionVO;
import kr.sc.ictjsp.users.model.usersVO;

import java.sql.*;

public class AnswerDAO {

	private DataSource ds;
	
	private final int INSERT_A_SUCCESS = 1;
	private final int INSERT_A_FAIL = 0;
	private final int COMPARE_A_SUCCESS = 1;
	private final int COMPARE_A_FAIL = 0;
	
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
	
	public int AnswerComp(AnswerVO answer, CorrectVO correct, 
				QuestionVO question, usersVO users, int code) {
		
		Connection con = null;
		int uhtmlcount = users.getHtmlcount();
		int ucsscount = users.getCsscount();
		int ujavacount = users.getJavacount();
		int ujspcount = users.getJspcount();
		
		try {
			
			con = ds.getConnection();
			switch (code) {
			case 1:
				if(answer.getQcode()  == question.getqcode()) { // 사용자가 푼 문제 코드와 주어진 문제의 코드 비교
					if(answer.getQcode() == correct.getCcode()) { // 사용자가 푼 문제 코드와 문젱에 대한 정답코드 비교
						if(answer.getAnswer() == correct.getCorrect()) { // 사용자가 푼 문제의 정답과 주어진 문제의 정답 비교
							uhtmlcount++;
							break;
						}
					}
				}
			case 2: 
				if(answer.getQcode()  == question.getqcode()) {
					if(answer.getQcode() == correct.getCcode()) {
						if(answer.getAnswer() == correct.getCorrect()) {
							ucsscount++;
							break;
						}	
					}
				}
			case 3:
				if(answer.getQcode()  == question.getqcode()) {
					if(answer.getQcode() == correct.getCcode()) {
						if(answer.getAnswer() == correct.getCorrect()) {
							ujavacount++;
							break;
						}
					}
				}
			case 4:
				if(answer.getQcode()  == question.getqcode()) {
					if(answer.getQcode() == correct.getCcode()) {
						if(answer.getAnswer() == correct.getCorrect()) {
							ujspcount++;
							break;
						}
					}
				}
			}
			return COMPARE_A_SUCCESS;
			
		}catch (SQLException e) {
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
		return COMPARE_A_FAIL;
	} // end SolveAnswer
}
