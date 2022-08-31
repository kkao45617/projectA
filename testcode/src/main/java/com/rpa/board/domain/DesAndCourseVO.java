package com.rpa.board.domain;

import lombok.Data;

/*
create table des_course(
    pathnum number not null primary key,
    destination_num number not null,
    CONSTRAINT fk_destination_to foreign key(destination_num) references destinatinodata(num),
    course_num number not null,
    CONSTRAINT fk_course_to foreign key(course_num) references course(course_num)
); 
*/

@Data
public class DesAndCourseVO {
	private int pathNum, destinationNum, courseNum;
}
