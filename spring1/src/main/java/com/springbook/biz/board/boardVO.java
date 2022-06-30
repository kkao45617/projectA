package com.springbook.biz.board;

import java.sql.Date;

import lombok.Data;

@Data
public class boardVO {
	private int seq,cnt;
	private String title, writer, content;
	private Date regdate;	
}
