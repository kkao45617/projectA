package com.springbook.view.board;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.springbook.diz.board.boardVO;
import com.springbook.diz.board.boardservice;
import com.springbook.diz.board.impl.boardDAO;

@Controller
@SessionAttributes("board")
public class boardcontroller {
	
	@Autowired
	private boardservice boardservice;
	
	@RequestMapping("/datatransform.do")
	@ResponseBody
	public List<boardVO> datatransform(boardVO vo){
		vo.setSerchcondition("title");
		vo.setSerchkeyword("");
		List<boardVO> boardlist = boardservice.getboardlist(vo);
		return boardlist;
	}
	
	
	@RequestMapping("/insertboard.do")
	public String insertboard(boardVO vo) throws IOException {
		MultipartFile uploadfile = vo.getUploadfile();
		if(!uploadfile.isEmpty()) {
			String filename = uploadfile.getOriginalFilename();
			uploadfile.transferTo(new File("c:/upload/"+filename));
		}
		
		boardservice.insertboard(vo);
		return "getlistboard.do";
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
	public String getboardlist(boardVO vo, Model model) {
		if(vo.getSerchcondition()==null)vo.setSerchcondition("title");
		if(vo.getSerchkeyword()==null)vo.setSerchkeyword("");
		
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
