package org.zerock.persistence;

import java.sql.Connection;

import javax.sql.CommonDataSource;
import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@Log4j
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class datasourcetests {
	@Autowired
	private DataSource datasource;
	@Autowired
	private SqlSessionFactory sqlsessionfactory;
	
	
	@Test
	public void testconnection() {
		try (Connection conn=datasource.getConnection()){
			log.info("--------------------------");
			log.info(conn);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	@Test
	public void testmybatis() {
		try (SqlSession session=sqlsessionfactory.openSession(); Connection conn =session.getConnection() ){
			log.info("+++++++++++++++++++++++");
			log.info(session);
			log.info(conn);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

}
