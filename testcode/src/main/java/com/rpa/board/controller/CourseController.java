  package com.rpa.board.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.rap.board.mapper.CourseMapper;
import com.rap.board.mapper.DesDataMapper;
import com.rpa.board.domain.CourseVO;
import com.rpa.board.domain.DesAndCourseVO;
import com.rpa.board.domain.DesDataDTO;
import com.rpa.board.service.CourseService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@AllArgsConstructor
@RequestMapping("/course/*")
public class CourseController {
	private CourseService service;
	private DesDataMapper desMapper;
	
	@RequestMapping("list.do")
	public String list(Model model, String city) {
		log.info(city);
		
		List<CourseVO> list = service.getCourseList();	//코스 리스트를 list에 담는다.
		if(city != null) {
			list = service.searchCityList(city);
		}
		int i = 0;
		
		for (CourseVO vo : list) {
			log.info(vo);
			int courseNum = list.get(i).getCourseNum();
			List<DesAndCourseVO> desNumList = service.getDesList(courseNum);
			List<DesDataDTO> desList = new ArrayList<DesDataDTO>(); //여행지 리스트를 desList에 담는다.(코스VO의 desList에 담기위해 생성)
			for(DesAndCourseVO destinations : desNumList) {
				Long long1 = (long) destinations.getDestinationNum();
				DesDataDTO dto = desMapper.read(long1);
				desList.add(dto);
			}
			
			list.get(i).setDesList(desList); // 여행지 리스트를 List객체값을 setter 메소드를 통해 채워준다.
			i++;
		}
		model.addAttribute("list", list);
		log.info("------- courseList -------");
		return "course/courseList";
	}
	
	@RequestMapping("page.do")
	public String page(Model model, int num) {
		log.info("------- coursePage -------");
		
		double numMapX = 0;	//center좌표 설정에 사용할 mapX값
		double numMapY = 0; //center좌표 설정에 사용할 mapY값
		
		CourseVO vo = service.getCourse(num);
		
		List<DesAndCourseVO> desNumList = service.getDesList(num);
		List<DesDataDTO> desList = new ArrayList<DesDataDTO>(); //여행지 리스트를 desList에 담는다.(코스VO의 desList에 담기위해 생성)
		for(DesAndCourseVO destinations : desNumList) {
			Long long1 = (long) destinations.getDestinationNum();
			DesDataDTO dto = desMapper.read(long1);
			desList.add(dto);
			
			numMapX += Double.parseDouble(dto.getDestinationMapX());
			numMapY += Double.parseDouble(dto.getDestinationMapY());
		}
		vo.setDesList(desList);
		log.info(vo);
		
		String resultMapX = String.format("%.6f", numMapX/desNumList.size());
		String resultMapY = String.format("%.6f", numMapY/desNumList.size());
		
		model.addAttribute("course", vo);
		model.addAttribute("resultMapX", resultMapX);
		model.addAttribute("resultMapY", resultMapY);
		return "course/coursePage";
	}
	
	@GetMapping(value = "/page/{num}",
			produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<List<DesDataDTO>> desList(@PathVariable("num") int num) {
		log.info("getList.........." + num);
		
		List<DesAndCourseVO> desNumList = service.getDesList(num);
		List<DesDataDTO> desList = new ArrayList<DesDataDTO>(); //여행지 리스트를 desList에 담는다.(코스VO의 desList에 담기위해 생성)
		for(DesAndCourseVO destinations : desNumList) {
			Long long1 = (long) destinations.getDestinationNum();
			DesDataDTO dto = desMapper.read(long1);
			desList.add(dto);
		}
		
		return new ResponseEntity<>(desList, HttpStatus.OK);
	}
	
	@RequestMapping(method = {RequestMethod.PUT, RequestMethod.PATCH},
			value = "/{num}", produces = {MediaType.TEXT_PLAIN_VALUE})
	public ResponseEntity<String> like(@PathVariable("num") int num) {
		int check = service.likesCourse(num);
		log.info(check);
		return check == 1 ? new ResponseEntity<String>("success", HttpStatus.OK) :
									new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
}