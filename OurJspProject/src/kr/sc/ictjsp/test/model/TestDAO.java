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
	
	public int InsertTest(int code, String Input_Test, String QCorrect, String submitUser) {
		
		Connection con = null;
		PreparedStatement pstmt = null;
				
		try {
			con = ds.getConnection();
			switch (code) {
			case 1: 
				String sql1 = "INSERT INTO Test VALUES("+htmlcode+", ?, ?, ?)";
				pstmt = con.prepareStatement(sql1);
				pstmt.setString(1, Input_Test);
				pstmt.setString(2, QCorrect);
				pstmt.setString(3, submitUser);
				pstmt.executeUpdate();
				htmlcode++;
				break;
			case 2:
				String sql2 = "INSERT INTO Test VALUES("+csscode+", ?, ?, ?)";
				pstmt = con.prepareStatement(sql2);
				pstmt.setString(1, Input_Test);
				pstmt.setString(2, QCorrect);
				pstmt.setString(3, submitUser);
				pstmt.executeUpdate();
				csscode++;
				break;
			case 3:
				String sql3 = "INSERT INTO Test VALUES("+javacode+", ?)";
				pstmt = con.prepareStatement(sql3);
				pstmt.setString(1, Input_Test);
				pstmt.setString(2, QCorrect);
				pstmt.setString(3, submitUser);
				pstmt.executeUpdate();
				javacode++;
				break;
			case 4:
				String sql4 = "INSERT INTO Test VALUES("+jspcode+", ?)";
				pstmt = con.prepareStatement(sql4);
				pstmt.setString(1, Input_Test);
				pstmt.setString(2, QCorrect);
				pstmt.setString(3, submitUser);
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
	
	public int UpdateTest() {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			
			con = ds.getConnection();
			String sql = "UPDATE Test set Test = ? WHERE qcode = ?";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, Test.getQuestion());
			pstmt.setInt(2, Test.getTcode());
			
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
	} // end UpdateTest
	
	public int DeleteTest(TestVO Test) {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			
			con = ds.getConnection();
			String sql = "DELETE from Test WHERE qcode = ?";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, Test.getqcode());
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
	} // end DeleteTest


	public List<TestVO> TestGetInfo() {
		
		List<TestVO> QList = new ArrayList<>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
	
		String sql = "SELECT * FROM Test ORDER BY qcode DESC";

		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				TestVO TestData = new TestVO();
				TestData.setqcode(rs.getInt("qcode"));
				TestData.setTest(rs.getString("Test"));
				
				QList.add(TestData);
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
	} // end TestGetInfo
		
	public TestVO GetTest(String qcode) {
		
		TestVO Test = new TestVO();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		
		try {
			
			con = ds.getConnection();
			String sql = "SELECT * FROM Test WHERE qcode = ?";

			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, qcode);
					
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				Test.setqcode(rs.getInt("qcode"));
				Test.setTest(rs.getString("Test"));
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
		int qtcount = 0;
		
		try {
			
			con = ds.getConnection();
			String sql = "SELECT COUNT(qcode) as qtcount from Test";
			
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				qtcount = rs.getInt("qtcount");				
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
		return qtcount;
	} 

}
