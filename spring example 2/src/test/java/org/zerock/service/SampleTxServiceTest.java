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
		String str="�۰�ð�2022-08-19 11:58 ��� �۰�ð�2022-08-19 11:58 ��� �۰�ð�2022-08-19 11:58 ��� �۰�ð�2022-08-19 11:58 ��� �۰�ð�2022-08-19 11:58 ��� �۰�ð�2022-08-19 11:58 ���";
		log.info("lenth : "+str.getBytes().length);
		service.addData(str);
		
	}
}
