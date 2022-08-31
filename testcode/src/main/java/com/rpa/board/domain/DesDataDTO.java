package com.rpa.board.domain;

import lombok.Data;

@Data
public class DesDataDTO {
	private Long destinationNum;
	private String destinationTitle;
	private String destinationAddress;
	private String destinationFirstImg;
	private String destinationSecondImg;
	private String destinationMapX;
	private String destinationMapY;
	private String destinationContent;
	private String destinationCity;
	private Long userNum;
}
