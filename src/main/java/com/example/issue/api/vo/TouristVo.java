package com.example.issue.api.vo;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter @Data
public class TouristVo {
	private int num;
	private String resultCode;
	private String resultMsg;
	private String standardAddr;
	private String detailAddr;
	private String areacode;
	private String contenttypeId;
	private String firstimage;
	private String firstimage2;
	private String telNum;
	private String title;
	private String zipcode;
	private String sigungucode;
	
}
