package com.springbook.diz.board;

import java.sql.Date;

import lombok.Data;

@Data
public class boardVO {
	private int seq,cnt;
	private String title, writer, content;
	private Date regdate;	
	private String serchcondition;
	private String serchkeyword;
}
