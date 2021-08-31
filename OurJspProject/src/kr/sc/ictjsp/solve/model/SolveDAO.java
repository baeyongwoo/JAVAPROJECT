package kr.sc.ictjsp.solve.model;

import javax.naming.*;
import javax.sql.*;

import kr.sc.ictjsp.test.model.TestDAO;
import kr.sc.ictjsp.test.model.TestVO;
import kr.sc.ictjsp.users.model.usersVO;

import java.sql.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class SolveDAO {

	private DataSource ds;

	private final int INSERT_S_SUCCESS = 1;
	private final int INSERT_S_FAIL = 0;
	private final int SUCCESS = 1;
	private final int FAIL = 0;

	private SolveDAO() {

		try {
			Context ct = new InitialContext();
			ds = (DataSource) ct.lookup("java:comp/env/jdbc/mysql");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static SolveDAO dao = new SolveDAO();

	public static SolveDAO getInstance() {
		return dao;
	}

	// 정답 입력 메서드
	// 문제 풀이할 때
	//
	public int InsertSolve(SolveVO solve) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = ds.getConnection();

			String sql = "INSERT INTO solve VALUES (NULL, ?, ?, now(), ?)";

			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, solve.getTcode());
			pstmt.setString(2, solve.getSolve());
			pstmt.setString(3, solve.getSuer());

			pstmt.executeUpdate();

			return INSERT_S_SUCCESS;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (con != null && !con.isClosed()) {
					con.close();
				}
				if (pstmt != null && !pstmt.isClosed()) {
					pstmt.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return INSERT_S_FAIL;
	} // end InsertAnswer

	// 정답 확인 메서드

	public int Check(TestVO test, String solve) {

		System.out.println("service에서 받아온 test" + test);
		System.out.println("문제 코드 " + test.getTcode() + "에 대한 정답 입력한 것" + solve);
		System.out.println("정답 : " + test.getCorrect());

		if (solve.equals(test.getCorrect())) {
			return 1; // 정답

		} else {
			return 0;
		}
	}// end SolveAnswer

	//중복체크 검사
	public int duplicate(usersVO user, String code) {
		System.out.println("service에서 전달 받은 값  : " + user.getUqcode());	//qcode
		System.out.println("service에서 전달 받은 code값  : " + code);	//qcode
		String userCode = user.getUqcode();
		
		StringTokenizer st = new StringTokenizer(userCode, " ");

		ArrayList<String> listcode = new ArrayList<>();
		while(st.hasMoreTokens()) {	//토큰이 존재하면 ture 리턴하는 구문
			listcode.add(st.nextToken());
		}
		
		System.out.println(listcode);
		
		if(listcode.contains(code)) {
			System.out.println("중복");
			return 0;
		}else {
			System.out.println("중복아님");
			return 1;
		}
		
	}
	
	
	

	// user정보에 푼 코드 넣기
	public int userInsertCode(usersVO user) {

		Connection con = null;
		PreparedStatement pstmt = null;
		int result =0;
		try {
			System.out.println("solveDao : " + user);
			con = ds.getConnection();
			
			String sql = "update users set uqcode = concat(uqcode," + "space(1)," + "?) where uid=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, user.getUqcode());
			pstmt.setString(2, user.getUid());

			pstmt.executeUpdate();
			return result = 1;//성공
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (con != null && !con.isClosed()) {
					con.close();
				}
				if (pstmt != null && !pstmt.isClosed()) {
					pstmt.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return result = 0;

	}// end userInsertCode

}