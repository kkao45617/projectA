package com.rpa.board.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.rap.board.mapper.FesDataMapper;
import com.rpa.board.domain.FesDataDTO;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

/**
 * Handles requests for the application home page.
 */
@Controller
@Log4j
@AllArgsConstructor
public class HomeController {
	private FesDataMapper mapper;
	
	@RequestMapping(value = "/home.do", method = RequestMethod.GET)
	public String home(Model model) {
		log.info("------ home --------");
		List<FesDataDTO> list = mapper.getList();;
		model.addAttribute("data",list);
				
				
		return "home";
	}
	
}