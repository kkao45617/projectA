package com.rpa.board.domain;

import lombok.Data;

/*
create table festivaldata (
    num number(5) not null primary key,
    title varchar2(100),
    address varchar2(200),
    firstimg varchar2(2000),
    startdate varchar2(8),
    enddate varchar2(8),
    mapx varchar2(100),
    mapy varchar2(100),
    mlevel number(5)
); 
 */

@Data
public class FesDataDTO {
	private int num;
	private String title;
	private String address;
	private String firstimg;
	private String startdate;
	private String enddate;
	private String mapx;
	private String mapy;
	private int mlevel;
}