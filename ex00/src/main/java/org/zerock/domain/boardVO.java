package org.zerock.domain;
/*
 * bno not null number(10)
 * title not null varchar2(200)
 * content not null varchar2(30000)
 * 
 * */

import java.util.Date;

import lombok.Data;

@Data
public class boardVO {
	private long bno;
	private String title, content, writer;
	private Date regdate,updatedate;
}
