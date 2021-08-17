package users.model;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.*;

public class usersDAO {
	
	private DataSource ds;
	
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
	
	

}
