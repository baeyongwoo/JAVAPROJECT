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

			String sql = "INSERT INTO users VALUES(?, ?, ?, ?, ?, ?)";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, user.getId());
			pstmt.setString(2, user.getPw());
			pstmt.setString(3, user.getName());
			pstmt.setString(4, user.getEmail());
			pstmt.setString(5, user.getBirth());
			pstmt.setString(6, user.getGender());
			
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
			
			String sql = "SELECT * FROM users WHERE id = ?";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, user.getId());
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				
				String dbId = rs.getString("id");
				String dbPw = rs.getString("pw");
				
				if(user.getId().equals(dbId) &&
						user.getPw().equals(dbPw)) {
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
			if(users.getPw().equals(dpw)) {
				
				con = ds.getConnection();
				String sql = "DELETE from project WHERE id = ?";
				
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, users.getId());
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
			String sql = "UPDATE users set pw = ?, email = ? WHERE id = ?";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, users.getPw());
			pstmt.setString(2, users.getEmail());
			pstmt.setString(3, users.getId());
			
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
	
	
	
}
