package com.rpa.board.domain;

import java.util.List;

import lombok.Data;

/*
CREATE TABLE course (
   coursenum number NOT NULL primary key,
   coursetitle varchar2(150) NOT NULL,
   coursecontent varchar2(4000) NOT NULL,
   courseimage varchar2(4000) NULL,
   courselike number NOT NULL,
   coursecity varchar2(50) not null
);
*/

@Data
public class CourseVO {
	private int courseNum, courseLike;
	private String courseTitle, courseContent, courseImage, courseCity;
	private List<DesDataDTO> desList;
}
