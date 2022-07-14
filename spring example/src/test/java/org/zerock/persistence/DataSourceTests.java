package org.zerock.persistence;

import java.sql.Connection;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.log4j.Log4j;


//pom -> xml에 junit 4.12 변경 , log4j 1.2.17 변경
//springframwork -> 프레임워크 -test 버전 추가 및 변경
@Log4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class DataSourceTests {
	
	//의존성 주입
	@Autowired
	private DataSource datasource;
	
	
	//log4j가 들어올 경우 같이 따라감
	@Test
	public void testConnection() {
	try(Connection con=datasource.getConnection()) {
		log.info("데이터 소스 : "+datasource);
		log.info("con : "+con);
		
	}catch(Exception e){
		e.printStackTrace();
		
		}
	}
}
