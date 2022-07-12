package org.zerock.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.zerock.domain.sampleDTO;

import lombok.extern.java.Log;
import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/sample/*")
@Log4j
public class samplecontroller {
	
	@RequestMapping(value = "basic", method = RequestMethod.GET)
	public String basic() {
		log.info("basic------------------------");
		return "basic";
	}
	@RequestMapping(value = "basic", method = RequestMethod.POST)
	public void basic2() {
		log.info("basic------------------------");
	}
	
	
	@GetMapping("/basiconlyget")
	public void basicget2() {
		log.info("basicget2()----------------");
	}
	
	@GetMapping("/ex00")
	public String ex00(sampleDTO dto, Model model) {
		log.info("dto------- :"+dto);
		model.addAttribute("model",model);
		return "ex00";
	}
	
	@GetMapping("/ex03")
	public void ex03(@ModelAttribute("dto") sampleDTO dto,@ModelAttribute("page") int page) {
		log.info(dto);
		log.info(page);
		
		//return "ex03";
	}
	@GetMapping("/ex04")
	public @ResponseBody sampleDTO ex04() {
		log.info("ex04------------: " );
		sampleDTO dto= new sampleDTO();
		dto.setName("홍길동이올시다");
		dto.setAge(1000000000);
		return dto;
	}
}

