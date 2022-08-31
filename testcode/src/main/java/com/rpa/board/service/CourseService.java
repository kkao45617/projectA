package com.rpa.board.service;

import java.util.List;

import com.rpa.board.domain.CourseVO;
import com.rpa.board.domain.DesAndCourseVO;

public interface CourseService {
	public List<CourseVO> getCourseList();
	public List<CourseVO> searchCityList(String city);
	public List<DesAndCourseVO> getDesList(int courseNum);
	public CourseVO getCourse(int courseNum);
	public int likesCourse(int courseNum);
}
