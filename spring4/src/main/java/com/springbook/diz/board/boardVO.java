package com.springbook.diz.board;

import java.sql.Date;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreType;

import lombok.Data;


@Data
public class boardVO {
	private int seq,cnt;
	private String title, writer, content;
	private Date regdate;	
	@JsonIgnore
	private String serchcondition;
	@JsonIgnore
	private String serchkeyword;
	private MultipartFile uploadfile;
	
}
