package org.zerock.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.domain.BoardVO;
import org.zerock.mapper.BoardMapperTests;

import lombok.extern.log4j.Log4j;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"file:src/main/webapp/WEB-INF/spring/root-context.xml","file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml" })
@Log4j
public class boardcontrollertests {
	@Autowired
	private WebApplicationContext ctx;
	private MockMvc mockmvc;
	
	
	//@test어노테이션 실행 전에 미리 선행작업 
	@Before
	public void setup() {
		this.mockmvc = MockMvcBuilders.webAppContextSetup(ctx).build();
	}
	
	   @Test
	   public void testList() throws Exception {
	      log.info(
	    		  mockmvc.perform(MockMvcRequestBuilders.get("/board/list"))
	            .andReturn().getModelAndView().getModelMap() );
	   }
	   
	   @Test
	   public void testregister() throws Exception {
		  String resultpage =  mockmvc.perform(MockMvcRequestBuilders.post("/board/register")
	    				  .param("title", "돈가~아스").param("content", "느끼하고 질려")
	    				  .param("writer", "이제는그만")
	    				  ).andReturn().getModelAndView().getViewName();
		  log.info(resultpage);
	   }
	   
	   @Test
	   public void testget() throws Exception {
		   log.info(
				   mockmvc.perform(
						   	MockMvcRequestBuilders.get("/board/get")
						   	.param("bno", "50")).andReturn().getModelAndView().getModelMap());
		   
	   }
	   @Test
	   public void testremove() throws Exception {
		  String resultpage =  mockmvc.perform(MockMvcRequestBuilders.post("/board/remove")
	    				  .param("bno", "50")
	    				  ).andReturn().getModelAndView().getViewName();
		  log.info(resultpage);
	   }
	   
	   @Test
	   public void testmodify() throws Exception {
			  String resultpage =  mockmvc.perform(MockMvcRequestBuilders.post("/board/modify")
		    				  .param("bno", "10")
		    				  .param("title", "씨베루머")
		    				  .param("content", "럭키")
		    				  .param("writer", "뭐라냐")
		    				  ).andReturn().getModelAndView().getViewName();
			  log.info(resultpage);
		  }
}
