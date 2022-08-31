package com.rap.board.mapper;

import java.util.List;

import com.rpa.board.domain.CourseVO;
import com.rpa.board.domain.DesAndCourseVO;

public interface CourseMapper {
	public List<CourseVO> getList();
	public List<CourseVO> getCityList(String city);
	public List<DesAndCourseVO> getDesList(int courseNum);
	public CourseVO readCourse(int courseNum);
	public int likesCourse(int courseNum);
}
