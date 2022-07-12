package org.zerock.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.log;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import jdk.internal.jline.internal.Log;
import lombok.extern.log4j.Log4j;


@Controller
@Log4j
@RequestMapping("/sample/*")
public class samplecontroller {
	
	@RequestMapping("/basic")
	public void basic() {
		log.info("basic----");
	}
	
	
	@RequestMapping("/basic2")
	public String basic2() {
		log.info("basic----");
		
		return "basic";
	}
}
