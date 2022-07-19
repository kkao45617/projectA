package org.zerock.mapper;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;
import org.zerock.domain.pageDTO;
import org.zerock.persistence.TimeMapperTests;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class BoardMapperTests {
	@Autowired
	private BoardMapper mapper;
	
	@Test
	public void testGetList() {
		log.info("----------------------------------");
		//log.info(mapper.getList());
	}
	@Test
	public void testRead() {
		log.info("----------------------------------");
		log.info(mapper.read(6L));
	}
	@Test
	public void testDelete() {
		log.info("----------------------------------");
	    log.info("delete : " + mapper.delete(6L));
	}
	@Test
	public void testInsert() {
		BoardVO vo  =  new BoardVO();
		vo.setTitle("spring2");
		vo.setContent("��ƴ�2");
		vo.setWriter("��ſ�2");
		log.info("----------------------------------");
		log.info("insert : " + mapper.insert(vo));
	}
	@Test
	public void testInsertSelectKey() {
		BoardVO vo  =  new BoardVO();
		vo.setTitle("java");
		vo.setContent("java");
		vo.setWriter("java2");
		log.info("----------------------------------");
		log.info("insert : " + mapper.insertSelectKey(vo));
	}
	@Test
	public void testupdate() {
		BoardVO vo  =  new BoardVO();
		vo.setBno(9L);
		vo.setTitle("aa");
		vo.setContent("bbb........");
		vo.setWriter("cc");
		log.info("----------------------------------");
		log.info("insert : " + mapper.update(vo));
	}
	
	@Test
	public void testPaging() {
		Criteria cri = new Criteria();
		cri.setPageNum(3);
		cri.setAmount(10);
		List<BoardVO> list = mapper.getListWithPagging(cri);
		log.info(list);
	}
	
	@Test
	public void testpageDTO() {
		Criteria cri= new Criteria();
		cri.setPageNum(15);
		cri.setAmount(10);
		pageDTO pageDTO = new pageDTO(cri, 316);
		log.info(pageDTO);
	}
}




