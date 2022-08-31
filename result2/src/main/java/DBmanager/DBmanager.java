package DBmanager;

import java.sql.Connection;

import javax.naming.Context;
import javax.naming.InitialContext;



public class DBmanager {
	public static Connection getconnection() {
		Connection conn=null;
		try {
			Context init = new InitialContext();
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	
	
	
}
