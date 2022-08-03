package org.zerock.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.domain.ReplyVO;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class ReplyServiceTests{
	
	@Autowired
	private ReplyService service;
	
	@Test
	public void inserttests() {
		log.info(service);
	}
	
	@Test
	public void testRegister() {
		ReplyVO vo = new ReplyVO();
		vo.setBno(271483L);
		vo.setReply("바보야");
		vo.setReplyer("이바보야~잘지내니");
		service.register(vo);
	}
	@Test
	public void testremove() {
		service.remove(271483L);
	}
}
