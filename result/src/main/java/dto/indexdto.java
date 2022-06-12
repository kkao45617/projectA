package dto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class indexdto {
	private Connection conn=null;
	private PreparedStatement pstm=null;
	
	private final String url="jdbc:mysql://@localhost:3306/mydb";
	private final String name="root";
	private final String pass="1234";
	
	
	public indexdto() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void getconnection() {
		try {
			conn=DriverManager.getConnection(url,name,pass);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
