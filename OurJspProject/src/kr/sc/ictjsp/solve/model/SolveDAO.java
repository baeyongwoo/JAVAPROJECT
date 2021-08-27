package kr.sc.ictjsp.solve.model;

import javax.naming.*;
import javax.sql.*;

import kr.sc.ictjsp.correct.model.CorrectVO;
import kr.sc.ictjsp.question.model.QuestionVO;
import kr.sc.ictjsp.users.model.usersVO;

import java.sql.*;

public class SolveDAO {

	private DataSource ds;
	
	private final int INSERT_S_SUCCESS = 1;
	private final int INSERT_S_FAIL = 0;
	private final int CHECK_S_SUCCESS = 1;
	private final int CHECK_S_FAIL = 0;
	
	private SolveDAO() {
		
		try {
			Context ct = new InitialContext();
			ds = (DataSource)ct.lookup("java:comp/env/jdbc/mysql");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static SolveDAO dao = new SolveDAO();
	
	public static SolveDAO getInstance() {
		return dao;
	}
	//정답 입력 메서드
	//문제 풀이할 때
	//
	public int InsertSolve(SolveVO solve) {

		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			
			con = ds.getConnection();
			
			String sql = "INSERT INTO solve VALUES (NULL, ?, ?, now())";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, solve.getQcode());
			pstmt.setString(2, solve.getAnswer());
			
			pstmt.executeUpdate();
			
			return INSERT_S_SUCCESS;
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
		return INSERT_S_FAIL;
	} // end InsertAnswer
	
	//정답 확인 메서드
	
	public int check(SolveVO Solve, CorrectVO correct, 
				QuestionVO question, usersVO users, int code) {

		Connection con = null;
		int upoint = users.getPoint();
		
		try {
			con = ds.getConnection();
			switch (code) {
			case 1:
				if(Solve.getQcode()  == question.getqcode()) { // 사용자가 푼 문제 코드와 주어진 문제의 코드 비교
					if(Solve.getQcode() == correct.getCcode()) { // 사용자가 푼 문제 코드와 문젱에 대한 정답코드 비교
						if(Solve.getAnswer() == correct.getCorrect()) { // 사용자가 푼 문제의 정답과 주어진 문제의 정답 비교
							upoint++;
							break;
						}
					}
				}
				return CHECK_S_SUCCESS;
			case 2: 
				if(Solve.getQcode()  == question.getqcode()) {
					if(Solve.getQcode() == correct.getCcode()) {
						if(Solve.getAnswer() == correct.getCorrect()) {
							upoint++;
							break;
						}	
					}
				}
				return CHECK_S_SUCCESS;
			case 3:
				if(Solve.getQcode()  == question.getqcode()) {
					if(Solve.getQcode() == correct.getCcode()) {
						if(Solve.getAnswer() == correct.getCorrect()) {
							upoint++;
							break;
						}
					}
				}
				return CHECK_S_SUCCESS;
			case 4:
				if(Solve.getQcode()  == question.getqcode()) {
					if(Solve.getQcode() == correct.getCcode()) {
						if(Solve.getAnswer() == correct.getCorrect()) {
							upoint++;
							break;
						}
					}
				}
			}
			return CHECK_S_SUCCESS;
			
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
		return CHECK_S_FAIL;
		
	} // end SolveAnswer
	
}
