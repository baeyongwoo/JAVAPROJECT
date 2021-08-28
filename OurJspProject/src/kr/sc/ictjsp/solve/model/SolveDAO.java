package kr.sc.ictjsp.solve.model;

import javax.naming.*;
import javax.sql.*;

import kr.sc.ictjsp.test.model.TestVO;

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
			
			String sql = "INSERT INTO solve VALUES (NULL, ?, ?, now(), ?)";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, solve.getTcode());
			pstmt.setString(2, solve.getSolve());
			pstmt.setString(3, user);
			
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
	
	public int Check(int Tcode, String solve) {

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;		
		TestVO correct = new TestVO();
						
		String dbCorrect = null;
		
		try {
			con = ds.getConnection();
			
			String sql = "SELECT qcode, answer from solve where qcode = ?";

			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, Tcode);
			
			rs = pstmt.executeQuery();
			if(rs.next()) {
				dbCorrect = correct.getCorrect();
				if(solve == dbCorrect) { // 사용자가 푼 문제의 정답과 주어진 문제의 정답 비교
					return 1;
				} else {
					return 0;
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
		return 0;
		
	}// end SolveAnswer
	
	public int SolvedWhether(int USNum) {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int Whether = 0;
		
		try {
			con = ds.getConnection();
			
			String sql = "SELECT ? in (SELECT qcode from question where qcode = ?) as whether";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, USNum);
			pstmt.setInt(2, USNum);
			
			rs = pstmt.executeQuery();
//			Whether = rs.getInt("whether");
			if(rs.next()) {
				if(Whether==1) {
					System.out.println("푼 적이 있는 문제입니다.");
					System.out.println("포인트는 중복되서 쌓이지 않습니다.");
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return Whether;
	}

} 