package com.rpa.board.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.rap.board.mapper.FesDataMapper;
import com.rpa.board.domain.CityVO;
import com.rpa.board.domain.Criteria;
import com.rpa.board.domain.FesDataDTO;
import com.rpa.board.domain.PageDTO;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@AllArgsConstructor
@RequestMapping(value = "/festival/*")
public class FestivalController {
	private FesDataMapper mapper;

	@GetMapping("page.do")
	public String list(Criteria cri, Model model, String fesCity) {
		log.info("지역 : " + fesCity);
		List<FesDataDTO> list = mapper.getListWithPagging(cri);
		CityVO city = new CityVO();
		city.setAddress(fesCity);
		log.info(city.getAddress());
		city.setPageNum(cri.getPageNum());
		city.setAmount(cri.getAmount());
		
		if (fesCity != null) {
		switch (fesCity) {
		case "경기":
			city.setCity("인천");
			log.info(city.getAddress());
			list = mapper.getAddressList(city);
			log.info(list.get(0));
			break;
		case "충청북":
			city.setCity("세종");
			list = mapper.getAddressList(city);
			break;
		case "충청남":
			city.setCity("대전");
			list = mapper.getAddressList(city);
			break;
		case "경상북":
			city.setCity("대구");
			list = mapper.getAddressList(city);
			break;
		case "경상남":
			city.setCity("울산 부산");
			list = mapper.getAddressList(city);
			break;
		case "전라남":
			city.setCity("광주");
			list = mapper.getAddressList(city);
			break;
		default:
			list = mapper.getAddressList(city);
		}
	}
		
		int total = mapper.getTotalCount(city);
		
		log.info("total :" + total);
		
		model.addAttribute("list", list);
		model.addAttribute("pageMaker", new PageDTO(cri, total, city));
		
		return "festival/festival";
	}

	@GetMapping(value = "detail.do")
	   public String read(@RequestParam("num") int num, Model model) {
//	      System.out.println(num);
	      FesDataDTO dto = mapper.selectOne(num);
	      model.addAttribute("data",dto);
//	      model.addAttribute("data", dto);
	      return "/festival/list";
	   }
}
