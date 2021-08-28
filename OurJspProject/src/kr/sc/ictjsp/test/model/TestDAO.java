package kr.sc.ictjsp.test.model;

import javax.naming.*;
import javax.sql.*;
import java.sql.*;
import java.util.*;

public class TestDAO {
	
	private DataSource ds;
	
	private static final int INSERT_T_SUCCESS = 1;
	private static final int INSERT_T_FAIL = 0;
	private static final int UPDATE_T_SUCCESS = 1;
	private static final int UPDATE_T_FAIL = 0;
	private static final int DELETE_T_SUCCESS = 1;
	private static final int DELETE_T_FAIL = 0;
	
	private int htmlcode = 1000;
	private int csscode = 2000;
	private int javacode = 3000;
	private int jspcode = 4000;

	private TestDAO() {
		
		try {
			Context ct = new InitialContext();
			ds = (DataSource)ct.lookup("java:comp/env/jdbc/mysql");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static TestDAO dao = new TestDAO();
	
	public static TestDAO getInstance() {
		return dao;
	}
	
	public int InsertTest(int code, String Input_Test, String QCorrect) {
		
		Connection con = null;
		PreparedStatement pstmt = null;
				
		try {
			con = ds.getConnection();
			switch (code) {
			case 1: 
				String sql1 = "INSERT INTO Test VALUES(null, "+htmlcode+", ?, ?, "+"test)";
				
				pstmt = con.prepareStatement(sql1);
				pstmt.setString(1, Input_Test);
				pstmt.setString(2, QCorrect);
//				pstmt.setString(3, submitUser);
				pstmt.executeUpdate();
				htmlcode++;
				break;
			case 2:
				String sql2 = "INSERT INTO Test VALUES(null, "+csscode+", ?, ?, ?)";
				pstmt = con.prepareStatement(sql2);
				pstmt.setString(1, Input_Test);
				pstmt.setString(2, QCorrect);
//				pstmt.setString(3, submitUser);
				pstmt.executeUpdate();
				csscode++;
				break;
			case 3:
				String sql3 = "INSERT INTO Test VALUES(null, "+javacode+", ?, ?, ?)";
				pstmt = con.prepareStatement(sql3);
				pstmt.setString(1, Input_Test);
				pstmt.setString(2, QCorrect);
//				pstmt.setString(3, submitUser);
				pstmt.executeUpdate();
				javacode++;
				break;
			case 4:
				String sql4 = "INSERT INTO Test VALUES(null, "+jspcode+", ?, ?, ?)";
				pstmt = con.prepareStatement(sql4);
				pstmt.setString(1, Input_Test);
				pstmt.setString(2, QCorrect);
//				pstmt.setString(3, submitUser);
				pstmt.executeUpdate();
				jspcode++;
				break;
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
		return INSERT_T_FAIL;
	} // end InsertTest
	
	public int UpdateTest(String utquestion, int utcode) {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			
			con = ds.getConnection();
			String sql = "UPDATE Test set Test = ? WHERE qcode = ?";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, utquestion);
			pstmt.setInt(2, utcode);
			
			pstmt.executeUpdate();
			return UPDATE_T_SUCCESS;
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
		return UPDATE_T_FAIL;
	} // end UpdateTest
	
	public int DeleteTest(int DQcode) {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			
			con = ds.getConnection();
			String sql = "DELETE from Test WHERE qcode = ?";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, DQcode);
			pstmt.executeUpdate();
			
			return DELETE_T_SUCCESS;
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
		return DELETE_T_FAIL;
	} // end DeleteTest


	public List<TestVO> TestGetInfo() {
		
		List<TestVO> TList = new ArrayList<>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
	
		String sql = "SELECT * FROM Test ORDER BY Tcode DESC";

		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				TestVO TestData = new TestVO();
				
				TestData.setId(rs.getInt("id"));
				TestData.setTcode(rs.getInt("tcode"));
				TestData.setQuestion(rs.getString("question"));
				TestData.setS_user(rs.getString("s_user"));
				
				TList.add(TestData);
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
		return TList;
	} // end TestGetInfo
		
	public TestVO GetTest(String code) {
		
		TestVO Test = new TestVO();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		
		try {
			
			con = ds.getConnection();
			String sql = "SELECT * FROM Test WHERE tcode = ?";

			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, code);
					
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				Test.setId(rs.getInt("id"));
				Test.setTcode(rs.getInt("Tcode"));
				Test.setQuestion(rs.getString("question"));
				Test.setCorrect(rs.getString("correct"));
				Test.setS_user(rs.getString("s_user"));
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
		return Test;
		
	} // end GetTest
	
	public int CountTTest() {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int TestTcount = 0;
		
		try {
			
			con = ds.getConnection();
			String sql = "SELECT COUNT(Tcode) as TestTcount from Test";
			
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				TestTcount = rs.getInt("TestTcount");				
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
		return TestTcount;
	} 

}
