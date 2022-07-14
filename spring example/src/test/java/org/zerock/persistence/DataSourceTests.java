package org.zerock.persistence;

import java.sql.Connection;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.log4j.Log4j;


//pom -> xml�� junit 4.12 ���� , log4j 1.2.17 ����
//springframwork -> �����ӿ�ũ -test ���� �߰� �� ����
@Log4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class DataSourceTests {
	
	//������ ����
	@Autowired
	private DataSource datasource;
	
	
	//log4j�� ���� ��� ���� ����
	@Test
	public void testConnection() {
	try(Connection con=datasource.getConnection()) {
		log.info("������ �ҽ� : "+datasource);
		log.info("con : "+con);
		
	}catch(Exception e){
		e.printStackTrace();
		
		}
	}
}
