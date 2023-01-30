package com.example.issue.api.vo;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter @Data
public class NewsVo {
		
	
	private String title;
	private String titlePhotoLink;
	private String titleLink;
	private String writer;
	
	/* 뉴스 구분 parameter */
	private String genre;
	
	
}
