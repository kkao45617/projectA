package org.zerock.persistence;

import java.sql.Connection;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class datasourcetests {
	
	@Autowired
	private DataSource dataSource;
	
	@Autowired
	private SqlSessionFactory sqlsessionfactory;
	
	@Test
	public void testconnection() {
		try (Connection con = dataSource.getConnection()){
			log.info("--------------------------");
			log.info(con);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	@Test
	public void testmybatis() {
		try (SqlSession session= sqlsessionfactory.openSession();
				Connection conn = session.getConnection()
				){
			log.info("--------------------------");
			log.info(conn);
			log.info(session);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
