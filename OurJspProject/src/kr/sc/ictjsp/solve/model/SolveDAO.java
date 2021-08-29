package kr.sc.ictjsp.solve.model;

import javax.naming.*;
import javax.sql.*;

import kr.sc.ictjsp.test.model.TestDAO;
import kr.sc.ictjsp.test.model.TestVO;
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
			
			String sql = "INSERT INTO solve VALUES (NULL, ?, ?, now(), ?)";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, solve.getTcode());
			pstmt.setString(2, solve.getSolve());
			pstmt.setString(3, solve.getSuer());
			
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
	
	public int Check(TestVO test, String solve) {
	
		System.out.println("service에서 받아온 test" + test);
		System.out.println("문제 코드 " + test.getTcode() + "에 대한 정답 입력한 것" + solve);
		System.out.println("정답 : " + test.getCorrect());

			if(solve.equals(test.getCorrect())) {
				return 1;	//정답
				
			}else {
				return 0;
			}
	}// end SolveAnswer
	
	public int SolvedWhether(int USNum) {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int Whether = 0;
		
		try {
			con = ds.getConnection();
			
			String sql = "SELECT ? in (SELECT tcode from test where tcode = ?) as whether";
			
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