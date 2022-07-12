package org.zerock.persistence;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.mapper.timemapper;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@Log4j
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class timemappertests {
	@Autowired
	private timemapper timemapper;
	
	@Test
	public void testgettime() {
		log.info("-------------------------1");
		log.info("info 1 : "+timemapper.getClass().getName());
		log.info("info 2 : "+timemapper.gettime());
	}

	
	@Test
	public void testgettime2() {
		log.info("-----------------------2");
		log.info("info 1 : "+timemapper.getClass().getName());
		log.info("info 2 : "+timemapper.gettime2());
	}

}
