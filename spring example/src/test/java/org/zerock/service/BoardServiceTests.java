package org.zerock.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.domain.BoardVO;
import org.zerock.mapper.BoardMapper;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@Log4j
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class BoardServiceTests {
	@Autowired
	private BoardService service;
	
	@Test
	public void testread() {
		
		log.info("검색된 게시물 번호 : "+service.get(3L));
	}
	
	@Test
	public void testRegister() {
		BoardVO vo = new BoardVO();
		vo.setTitle("어머나 세상에");
		vo.setContent("요소 섹시한 사람");
		vo.setWriter("황치아");
		service.register(vo);
		
		log.info("생성된 게시물 번호 : "+vo.getBno());
	}
	
	@Test
	public void testdelete() {
		
		log.info("삭제된 게시물 번호 : "+service.remove(3L));
	}
	@Test
	public void testmodify() {
		BoardVO vo = new BoardVO();
		vo.setBno(20L);
		vo.setTitle("머리짱이다");
		vo.setContent("돈 많았으면");
		vo.setWriter("아쉽다");
		log.info( "생성된 수정 사항 : "+ service.modify(vo));
		
	}
	
	@Test
	public void testGet() {
		log.info("생성된 리스트 : "+service.getList());
	}
}
