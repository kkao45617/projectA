package org.zerock.controller;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.zerock.domain.SampleVO;
import org.zerock.domain.Ticket;

import lombok.extern.log4j.Log4j;

//@Controller
@RestController //controller+resoponsebody
@RequestMapping("/sample")
@Log4j
public class RestSampleController {
	
	@ResponseBody
									//반환형 *produces*
	@GetMapping(value = "/getText" , produces = {MediaType.TEXT_PLAIN_VALUE})
	public String getText() {
		log.info("miny type : "+MediaType.TEXT_PLAIN_VALUE);
		return "안녕하세요";
	}
	
	//객체반환
	@GetMapping(value = "/getSample", produces = {
				//MediaType.APPLICATION_JSON_UTF8_VALUE,
				MediaType.APPLICATION_XML_VALUE,
				MediaType.APPLICATION_JSON_VALUE
	})
	//@ResponseBody
	public SampleVO getSample() {
		return new SampleVO(111,"홍","길동");
	}
	
	@GetMapping(value = "/getlist",produces = {
			MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE
	})
	public List<SampleVO> getlist(){
		List<SampleVO> list = new ArrayList<SampleVO>();
		SampleVO vo = new SampleVO();
		vo.setMno(000);
		vo.setFirstName("박");
		vo.setLastName("찬호");
		list.add(vo);
		
		SampleVO vo2 = new SampleVO();
		vo.setMno(111);
		vo.setFirstName("이");
		vo.setLastName("재현");
		list.add(vo2);
		
		SampleVO vo3 = new SampleVO();
		vo.setMno(222);
		vo.setFirstName("여");
		vo.setLastName("수밤바다");
		list.add(vo3);
		
		return list;
	}
	
	@GetMapping(value = "/getmap",produces = {
			MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE
	})
	public Map<String, SampleVO> getmap(){
		Map<String, SampleVO> map = new HashMap<String, SampleVO>();
		map.put("first", new SampleVO(111,"이","재현"));
		map.put("second", new SampleVO(222,"갑","빠깡"));
		return map;
	}
	
	@GetMapping(value = "/check", params = {"height","weight"})
	public ResponseEntity<SampleVO> check(double height, double weight){
		SampleVO vo = new SampleVO(1,""+height,""+weight);
		ResponseEntity<SampleVO> result = null;
		
		if(height<150) {
			result = ResponseEntity.status(HttpStatus.BAD_GATEWAY).body(vo);
		}else {
			result= ResponseEntity.status(HttpStatus.OK).body(vo);
			
		}
		
		return result;
	}
	
	@GetMapping(value = "/product/{cat}/{pid}")
	public String[] getpath(
			@PathVariable("cat")String cat,
			@PathVariable("pid")String pid
			) {
		return new String[] {"category : "+cat,"productid : "+pid};
	}
	
	@PostMapping("/ticket")
	public Ticket convert(@RequestBody Ticket ticket) {
		log.info("convert : "+ticket);
		return ticket;
	}
	
	
	
	
}
