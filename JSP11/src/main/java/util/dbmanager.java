package util;

import java.sql.*;
import java.sql.Connection;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class dbmanager {
public static Connection getconnection() {
	Connection conn = null;
	try {
		Context initcontext = new InitialContext();
		Context envcontext = (Context)initcontext.lookup("java:/comp/env");
		DataSource ds = (DataSource)envcontext.lookup("jdbc/myoracle");
		conn=ds.getConnection();
	
	}catch (Exception e) {
			e.printStackTrace();
		}
	return conn;
	}

	public static void closeconnection(Connection conn, java.sql.Statement stmt, ResultSet rs) {
		try {
			if(rs!=null)rs.close();
			if(stmt!=null)stmt.close();
			if(conn!=null)conn.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void closeconnection(Connection conn, Statement stmt) {
		try {
			if(stmt!=null)stmt.close();
			if(conn!=null)conn.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

}
