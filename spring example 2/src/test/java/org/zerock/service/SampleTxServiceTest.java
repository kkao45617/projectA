package org.zerock.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class SampleTxServiceTest {
	@Autowired
	private SampleTxService service;
	
	@Test
	public void testing() {
		String str="송고시간2022-08-19 11:58 요약 송고시간2022-08-19 11:58 요약 송고시간2022-08-19 11:58 요약 송고시간2022-08-19 11:58 요약 송고시간2022-08-19 11:58 요약 송고시간2022-08-19 11:58 요약";
		log.info("lenth : "+str.getBytes().length);
		service.addData(str);
		
	}
}
