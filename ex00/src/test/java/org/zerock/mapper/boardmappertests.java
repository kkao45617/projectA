package org.zerock.mapper;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.log;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.domain.boardVO;
import org.zerock.persistence.datasourcetests;

import jdk.internal.jline.internal.Log;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@Log4j
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class boardmappertests {
	
	@Autowired
	private boardMapper mapper;
	
	@Test
	public void testgetlist() {
		//mapper.getList().forEach(board->log.info(board));
		
		//log.info("----------------------------------------");
		
		for (boardVO vo : mapper.getList()) {
			log.info(vo);
		}
	}
	//�׳� �μ�Ʈ
	@Test
	public void inserttest() {
		boardVO vo = new boardVO();
		vo.setTitle("ȫ�浿��");
		vo.setContent("�Ƹ��� ����ŷ");
		vo.setWriter("������ ����");
		mapper.insert(vo);
		log.info("-----------------------------------------------------------�μ�Ʈ");
		log.info(vo);
	}
	
	//���� �ڼ��� �μ�Ʈ�� ���� ���� �α׷� ���
	@Test
	public void inserttestkey() {
		boardVO vo = new boardVO();
		vo.setTitle("ȫ�浿��");
		vo.setContent("�Ƹ��� ����ŷ");
		vo.setWriter("������ ����");
		mapper.insertselectkey(vo);
		log.info("-----------------------------------------------------------�μ�Ʈ");
		log.info(vo);
	}
	
	@Test
	public void read() {
		boardVO vo= mapper.read(7L);
		log.info(vo);
	}
	
	//@Test
	/*public void testdelete() {
		int a =mapper.delete(12L);
		log.info("0000000000000000000000000000000000000000000000000000000000000000000000000");
		log.info(a);
	}*/
	
	@Test
	public void testupdate() {
		boardVO vo = new boardVO();
		vo.setBno(14L);
		vo.setTitle("�߻��� �����");
		vo.setContent("�� ����� �� å�� ����");
		vo.setWriter("������ �� �Դϴ�!");
		
		int a= mapper.update(vo);
		log.info(a+"5555555555555555555555555555555555555555555555555555555555");
	}
}
