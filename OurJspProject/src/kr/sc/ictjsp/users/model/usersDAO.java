package kr.sc.ictjsp.users.model;

import java.sql.*;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.*;

public class usersDAO {
	
	private DataSource ds;
	
	private static final int JOIN_SUCCESS = 1;
	private static final int JOIN_FAIL = 0;
	private static final int LOGIN_SUCCESS = 1;
	private static final int LOGIN_FAIL = 0;
	private static final int DELETE_SUCCESS = 1;
	private static final int DELETE_FAIL = 0;
	private static final int UPDATE_SUCCESS = 1;
	private static final int UPDATE_FAIL = 0;
	private static final int PwChange_SUCCESS = 1;
	private static final int PwChange_FAIL = 0;
	
	private usersDAO() {
		
		try {
			Context ct = new InitialContext();
			ds = (DataSource)ct.lookup("java:comp/env/jdbc/mysql");
		} catch (Exception e) {	
			e.printStackTrace();
		}
	}
	
	private static usersDAO dao = new usersDAO();
	
	public static usersDAO getInstance() {
		return dao;
	}
	
	public int joinUsers(usersVO user) {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		
		int result = 0;
		
		System.out.println(user);
		
		try {
			
			con = ds.getConnection();

			String sql = "INSERT INTO users VALUES(?, ?, ?, ?, ?)";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, user.getUid());
			pstmt.setString(2, user.getUpw());
			pstmt.setString(3, user.getUname());
			pstmt.setString(4, user.getUemail());
			pstmt.setInt(5, user.getSubject());

			pstmt.executeUpdate();
						
			result = JOIN_SUCCESS;
		} catch (SQLException e) {
			System.out.println("에러 : " + e);
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
			result = JOIN_FAIL;
		}
		return result;
	} // end joinUsers;
	
	public int usersLogin(usersVO user) {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = ds.getConnection();
			
			String sql = "SELECT * FROM users WHERE uid = ?";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, user.getUid());
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				
				String dbId = rs.getString("uid");
				String dbPw = rs.getString("upw");
				
				if(user.getUid().equals(dbId) &&
						user.getUpw().equals(dbPw)) {
					return LOGIN_SUCCESS;
				} else {
					return LOGIN_FAIL;
				} 
				
			}else {
					return LOGIN_FAIL;
						
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
		return LOGIN_FAIL;
	} // end usersLogin

	public int usersDelete(usersVO users, String dpw) {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			if(users.getUpw().equals(dpw)) {
				
				con = ds.getConnection();
				String sql = "DELETE from project WHERE uid = ?";
				
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, users.getUid());
				pstmt.executeUpdate();
				
				return DELETE_SUCCESS;
			} else {
				return DELETE_FAIL;
			}
		} catch (Exception e) {
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
		return DELETE_FAIL;
	} // end usersDelete
	
	public int usersUpdate(usersVO users) {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			
			con = ds.getConnection();
			String sql = "UPDATE users set upw = ?, uemail = ? WHERE uid = ?";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, users.getUpw());
			pstmt.setString(2, users.getUemail());
			pstmt.setString(3, users.getUid());
			
			pstmt.executeUpdate();
			return UPDATE_SUCCESS;
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
		return UPDATE_FAIL;
	} // end usersUpdate
	/*
	public usersVO usersFindId(usersVO users) {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		usersVO getId = new usersVO();
		
		try {
			con = ds.getConnection();
			String sql = "SELECT id FROM users WHERE name = ? and email = ?";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, users.getUname());
			pstmt.setString(2, users.getUemail());
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
					
				getId.setUid(rs.getString("id"));
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
		return getId;
	} // end usersFindId
	*/
	/*
	public int usersPwChange(usersVO users) {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = ds.getConnection();
			String sql = "UPDATE users set upw = ? WHERE id = ? and name = ?";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, users.getUpw());
			pstmt.setString(2, users.getUid());
			pstmt.setString(3, users.getUname());
			
			pstmt.executeUpdate();
			return PwChange_SUCCESS;
			
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
		return PwChange_FAIL;
	} // end usersPwChange
	*/
	
	public usersVO usergetinfo(usersVO users) {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		usersVO usersData = new usersVO();
		
		try {
			con = ds.getConnection();
			String sql = "SELECT * FROM users WHERE id = ?";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, users.getUid());
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				usersData.setUid("id");
				usersData.setUpw("pw");
				usersData.setUname("name");
				usersData.setUemail("email");
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
		return usersData;
	} // end getUserInfo
	
}
