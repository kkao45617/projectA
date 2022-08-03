package org.zerock.mapper;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.domain.Criteria;
import org.zerock.domain.ReplyVO;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class ReplyMapperTests {
	
	@Autowired
	private ReplyMapper mapper;
	
	private Long[] bnoarr= {5L,6L,7L,8L};
	
	@Test
	public void testMapper() {
		log.info(mapper);
	}

	@Test
	public void testCreate() {
		for(int i=0; i<5; i++) {
		ReplyVO vo = new ReplyVO();
		vo.setBno(bnoarr[i]);
		vo.setReply("이재현"+i+1);
		vo.setReplyer("너의 얼굴이에요"+i+1);
		mapper.insert(vo);
		}
		
	}
	
	@Test
	public void testread() {
		ReplyVO vo = mapper.read(3L);
		log.info(vo);
	}
	@Test
	public void testdelete() {
		log.info(mapper.delete(3L));
	}
	
	@Test
	public void testupdate() {
		ReplyVO vo = new ReplyVO();
		vo.setRno(5L);
		vo.setReply("잘생긴");
		log.info(mapper.update(vo));
	}
	
	@Test
	public void testlist() {
		Criteria cri = new Criteria();
		List<ReplyVO> list= mapper.getListwithPaging(cri, 2L);
		log.info(list);
	}
	
}
