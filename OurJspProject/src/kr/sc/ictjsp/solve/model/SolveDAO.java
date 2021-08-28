package kr.sc.ictjsp.solve.model;

import javax.naming.*;
import javax.sql.*;

import kr.sc.ictjsp.users.model.usersVO;

import java.sql.*;

public class SolveDAO {

	private DataSource ds;
	
	private final int INSERT_S_SUCCESS = 1;
	private final int INSERT_S_FAIL = 0;
	
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
	
	public int PointUp(int qcode, String solve, int point) {

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		usersVO users = new usersVO();
		
		int upoint = users.getUpoint();
		
		try {
			con = ds.getConnection();
			
			String sql = "SELECT qcode, answer from solve where qcode = ?";

			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, qcode);
			
			pstmt.execute();
			if(rs.next()) {
				String dbAnswer = rs.getString("gAnswer");
				String dbCorrect = rs.getString("gCorrect");
				
				if(dbAnswer == dbCorrect) { // 사용자가 푼 문제의 정답과 주어진 문제의 정답 비교
						upoint++;
					}
				}
			
		}catch (SQLException e) {
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
		return upoint;
		
	}
} // end SolveAnswer
	
//	public int SolvedWhether()
//	
//}
