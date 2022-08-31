package com.rpa.board.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.rap.board.mapper.CourseMapper;
import com.rpa.board.domain.CourseVO;
import com.rpa.board.domain.DesAndCourseVO;
import com.rpa.board.service.CourseService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Service
@Log4j
@AllArgsConstructor
public class CourseServiceImpl implements CourseService{
	private CourseMapper mapper;

	@Override
	public List<CourseVO> getCourseList() {
		log.info("--------------- CourseList --------------");
		return mapper.getList();
	}

	@Override
	public List<CourseVO> searchCityList(String city) {
		log.info("--------- searchCity -------------");
		return mapper.getCityList(city);
	}

	@Override
	public List<DesAndCourseVO> getDesList(int courseNum) {
		log.info("--------- DestinatinoList -------------");
		return mapper.getDesList(courseNum);
	}

	@Override
	public CourseVO getCourse(int courseNum) {
		log.info("--------- Course -------------");
		return mapper.readCourse(courseNum);
	}

	@Override
	public int likesCourse(int courseNum) {
		log.info("--------- likes Course -------------");
		return mapper.likesCourse(courseNum);
	}

}
