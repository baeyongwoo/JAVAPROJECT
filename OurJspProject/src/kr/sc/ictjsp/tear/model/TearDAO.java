package kr.sc.ictjsp.tear.model;

import java.sql.*;

import javax.naming.*;
import javax.sql.*;

public class TearDAO {
	
	private DataSource ds;
	
	private TearDAO() {
	
		try {
			Context ct = new InitialContext();
			ds = (DataSource)ct.lookup("java:comp/env/jdbc/mysql");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static TearDAO dao = new TearDAO();
	
	public static TearDAO getInstance() {
		return dao;
	}
	
	public int AdvanTear(TearVO tear) {
		
		Connection con 
	}

}
