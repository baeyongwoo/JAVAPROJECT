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
	
	public int joinUsers(usersVO user){
		
		Connection con = null;
		PreparedStatement pstmt = null;
		
		int result = 0;
		
		System.out.println(user);
		
		try {
			
			con = ds.getConnection();

			String sql = "INSERT INTO users VALUES(?, ?, ?, ?, ?, 0, 0, 0)";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, user.getUid());
			pstmt.setString(2, user.getUpw());
			pstmt.setString(3, user.getUname());
			pstmt.setString(4, user.getUemail());
			pstmt.setString(5, user.getSubject());

			pstmt.executeUpdate();
						
			result = JOIN_SUCCESS;
			
		}catch(SQLIntegrityConstraintViolationException e) {
				System.out.println("아이디 중복 에러");
				return result =  2;
				
		}catch (Exception e) {
			System.out.println("에러 : " + e);
			
		} 
		finally {
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
		int resultCode = 0;
		
		//System.out.println("service에서 받아온 id : " + user.getUid());
		//System.out.println("service에서 받아온 pw : " + user.getUpw());
		try {
			
			con = ds.getConnection();
			
			String sql = "SELECT * FROM users WHERE uid = ?";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, user.getUid());
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				
				String dbId = rs.getString("uid");
				String dbPw = rs.getString("upw");
								
				//System.out.println("db에서 아이디 : " + dbId);
				//System.out.println("db에서 비밀번호 : " + dbPw);
				if(user.getUid().equals(dbId) &&
						user.getUpw().equals(dbPw)) {
					//System.out.println("조건 검사 : " + user.getUid());
					//System.out.println("조건 검사 : " + user.getUpw());
					return resultCode = LOGIN_SUCCESS;
				} else {
					return resultCode = LOGIN_FAIL;
				}
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
		return resultCode = LOGIN_FAIL;
	} // end usersLogin

	public int usersDelete(usersVO user, String dpw) {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			if(user.getUpw().equals(dpw)) {
				
				con = ds.getConnection();
				
				String sql = "DELETE from users WHERE uid = ?";
				
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, user.getUid());
				pstmt.executeUpdate();
				
				return DELETE_SUCCESS;
			} else {
				return DELETE_FAIL;
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
		return DELETE_FAIL;
	} // end usersDelete
	
	public int usersUpdate(usersVO user) {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			
			con = ds.getConnection();
			
			String sql = "UPDATE users set upw = ?, uemail = ? WHERE uid = ?";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, user.getUpw());
			pstmt.setString(2, user.getUemail());
			pstmt.setString(3, user.getUid());
			
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
	public String getName(String id) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String uname = null;
		try {
			con = ds.getConnection();
			
			String sql = "SELECT uname FROM users WHERE uid = ?";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				uname = (rs.getString("uname"));
			}
		}
		catch (SQLException e) {
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
		System.out.println(uname);
		return uname;
		
		
	} // end getName
	
	
	
	
	/*
	public usersVO usersFindId(usersVO users) {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		usersVO getId = new usersVO();
		
		try {
			con = ds.getConnection();
			String sql = "SELECT uid FROM users WHERE uname = ? and uemail = ?";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, users.getUname());
			pstmt.setString(2, users.getUemail());
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
					
				getId.setUid(rs.getString("uid"));
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
			String sql = "UPDATE users set upw = ? WHERE uid = ? and uname = ?";
			
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
			
			String sql = "SELECT * FROM users WHERE uid = ?";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, users.getUid());
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				usersData.setUid(rs.getString("uid"));
				usersData.setUpw(rs.getString("upw"));
				usersData.setUname(rs.getString("uname"));
				usersData.setUemail(rs.getString("uemail"));
				usersData.setUqcode(rs.getInt("uqcode"));
				usersData.setUpoint(rs.getInt("upoint"));
				usersData.setUtier(rs.getInt("utier"));
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
