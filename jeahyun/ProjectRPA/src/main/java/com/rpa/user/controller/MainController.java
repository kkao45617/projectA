package com.rpa.user.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MainController {

private static final Logger log = LoggerFactory.getLogger(MainController.class);
	
	@RequestMapping(value = "/mainTEST", method = RequestMethod.GET)
	public void mainPageGET() {
		log.info("main");
	}
}
