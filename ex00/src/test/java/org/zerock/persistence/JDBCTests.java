package org.zerock.persistence;

import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.Test;

import lombok.extern.log4j.Log4j;

@Log4j
public class JDBCTests {
	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testconnection() {
		try(Connection conn= DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:xe",
					"system",
					"1234"
				)){
			log.info("-----------------------------");
			log.info("connection: "+conn);
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}