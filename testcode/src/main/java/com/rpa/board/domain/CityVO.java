package com.rpa.board.domain;

import lombok.Data;

@Data
public class CityVO {
	private String address, city;
	private int pageNum;
	private int amount;

	public String[] getCityArr() {
		return city == null ? new String[] {} : city.split(" ");
	}
	
}