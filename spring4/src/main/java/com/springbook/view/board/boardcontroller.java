package com.springbook.view.board;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.springbook.diz.board.boardVO;
import com.springbook.diz.board.boardservice;
import com.springbook.diz.board.impl.boardDAO;

@Controller
@SessionAttributes("board")
public class boardcontroller {
	
	@Autowired
	private boardservice boardservice;
	
	@RequestMapping("/insertboard.do")
	public String insertboard(boardVO vo) {
		boardservice.insertboard(vo);
		return "getboardlist.do";
	}
	
	@RequestMapping("/deleteboard.do")
	public String deleteboard(boardVO vo) {
		System.out.println("湲� �궘�젣 泥섎━");
		
		boardservice.deleteboard(vo);
		return "getboardlist.do";
	}
	
	
	@RequestMapping("/getboard.do")
	public String getboard(boardVO vo, ModelAndView mav, Model model){
		System.out.println("湲��긽�꽭議고쉶泥섎━");
		model.addAttribute("board",boardservice.getboard(vo));
		return "getboard.jsp";
	}
	
	@ModelAttribute("conditionmap")
	public Map<String, String> searchconditionmap(){
		Map<String, String> conditionmap = new HashMap<String, String>();
		conditionmap.put("제목", "title");
		conditionmap.put("내용", "content");
		conditionmap.put("작성자","writer" );
		return conditionmap;
	}
	
	@RequestMapping("/getlistboard.do")
	public String getboardlist(@RequestParam(value = "serchcondition",defaultValue = "title", required = false) 
	String condition,@RequestParam(value = "serchkeyword",defaultValue = "",required = false) String keyword , 
	 boardVO vo,Model model) {
		System.out.println("湲�紐⑸줉 寃��깋 泥섎━");
		System.out.println("검색 조건"+condition);
		System.out.println("검색 단어"+keyword);
		
		model.addAttribute("boardlist",boardservice.getboardlist(vo));
		
		return "getboardlist.jsp";
		
		//HttpSession session = request.getSession();
		//session.setAttribute("boardlist", boardlist);
		//return "old/getboardlist";
		
		
	}

	@RequestMapping("/updateboard.do")
	public String updateboard(@ModelAttribute("board") boardVO vo){
		System.out.println("湲� �닔�젙 泥섎━");
		System.out.println("번호"+vo.getSeq());
		System.out.println("제목"+vo.getTitle());
		System.out.println("내용"+vo.getContent());
		System.out.println("작성자"+vo.getWriter());
		System.out.println("등록일"+vo.getRegdate());
		System.out.println("조회수"+vo.getCnt());
		boardservice.updateboard(vo);
		return "getlistboard.do";
	}

	
}
