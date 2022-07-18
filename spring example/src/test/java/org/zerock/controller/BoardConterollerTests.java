package org.zerock.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.Model;
import org.springframework.web.context.WebApplicationContext;
import org.zerock.mapper.BoardMapperTests;

import lombok.extern.log4j.Log4j;


//톰캣없이 구동 가능하게 하는 테스트
//컨트롤러에서 자료받아서 정상작동되는지 테스트
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"file:src/main/webapp/WEB-INF/spring/root-context.xml","file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"})
@Log4j
@WebAppConfiguration
public class BoardConterollerTests {
	@Autowired
	private WebApplicationContext ctx;
	
	private MockMvc mockmvc;
	
	@Before
	public void setup() {
		this.mockmvc = MockMvcBuilders.webAppContextSetup(ctx).build();
	}
	
	@Test
	public void testList() throws Exception {
		log.info(
				mockmvc.perform(MockMvcRequestBuilders.get("/board/list")).andReturn().getModelAndView().getModelMap()
				);
		
	
	}
	
	@Test
	public void testregister() throws Exception {
			String resultpage =	mockmvc.perform(MockMvcRequestBuilders.post("/board/register").param("title", "금요일에").param("content","한잔 두잔 술이 생각나네").param("writer", "아..술취")).andReturn().getModelAndView().getViewName();
		
	log.info(resultpage);
	}
	
	@Test
	public void testget() throws Exception {
			String resultpage =	mockmvc.perform(MockMvcRequestBuilders.get("/board/get").param("bno", "5")).andReturn().getModelAndView().getViewName();
		
	log.info(resultpage);
	}
	@Test
	public void testdelete() throws Exception {
			String resultpage =	mockmvc.perform(MockMvcRequestBuilders.post("/board/remove").param("bno", "5")).andReturn().getModelAndView().getViewName();
		
	log.info(resultpage);
	}
	
	@Test
	public void testmodify() throws Exception {
		String resultpage =	mockmvc.perform(MockMvcRequestBuilders.post("/board/modify").param("bno", "5").param("title", "금요일에만나요").param("content", "얼씨구좋다").param("writer", "어절씨고")).andReturn().getModelAndView().getViewName();
		log.info("이거는 수정이야 잘알아둬"+resultpage);
	}
	
}
