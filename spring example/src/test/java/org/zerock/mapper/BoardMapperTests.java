package org.zerock.mapper;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.domain.BoardVO;

import lombok.extern.log4j.Log4j;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class BoardMapperTests {
	@Autowired
	private BoardMapper mapper;
	
	@Test
	public void TestGetList() {
		log.info("-------------------");
		log.info(mapper.getList());
		
		mapper.getList().forEach(list->log.info(list));
		
	}
	@Test
	public void TestRead() {
		log.info(mapper.read(2L));
	}
	
	@Test
	public void testdelete() {
		log.info(mapper.delete(7L));
	}
	@Test
	public void testinsert() {
		BoardVO vo = new BoardVO();
		vo.setTitle("결혼하고싶다");
		vo.setContent("세상에 가장 예쁜거짓말 씨발");
		vo.setWriter("하..제발.");
		log.info("insert : "+mapper.insert(vo));
		
	}
	@Test
	public void testinsertselectkey() {
		BoardVO vo = new BoardVO();
		vo.setTitle("사람은 이상하고");
		vo.setContent("사랑은 모르겠어");
		vo.setWriter("난잘몰라");
		log.info("key world: "+mapper.insertselectkey(vo));
		
	}
	@Test
	public void testupdate() {
		log.info("--------------update");
		BoardVO vo = new BoardVO();
		vo.setBno(9L);
		vo.setTitle("이런 맙소사");
		vo.setContent("놀라자빠지고마");
		vo.setWriter("이거사줬나");
		log.info(mapper.update(vo));
	}
}
