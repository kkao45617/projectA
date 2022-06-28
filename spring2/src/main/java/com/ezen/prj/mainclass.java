package com.ezen.prj;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class mainclass {

	public static void main(String[] args) {
		String resource = "com/ezen/prj/mybatis-config.xml";
		InputStream inputStream;
		
		try {
			inputStream = Resources.getResourceAsStream(resource);
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			System.out.println(sqlSessionFactory);
			
			
			SqlSession session = sqlSessionFactory.openSession();
					
			Mapperinterface mapper = session.getMapper(Mapperinterface.class);
			boardVO vo = mapper.selectone(8);
			
			System.out.println(vo.getName());
			System.out.println(vo);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}

}
