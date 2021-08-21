package kr.sc.ictjsp.board.model;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.*;

public class boardDAO {
	
	private DataSource ds;
	
	private boardDAO() {
		
		try {
			Context ct = new InitialContext();
			ds = (DataSource)ct.lookup("ava:/comp/env/jdbc/mysql");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private static boardDAO dao = new boardDAO();
	
	public static boardDAO getInstance() {
		if(dao == null) {
			dao = new boardDAO();
		}
		return dao;
	}
	
	
	
	
}
