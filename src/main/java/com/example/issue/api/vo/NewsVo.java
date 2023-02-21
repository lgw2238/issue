package com.example.issue.api.vo;

public class NewsVo {
		
	
	private String title;
	private String titlePhotoLink;
	private String titleLink;
	private String writer;
	
	/* 뉴스 구분 parameter */
	private String genre;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getTitlePhotoLink() {
		return titlePhotoLink;
	}

	public void setTitlePhotoLink(String titlePhotoLink) {
		this.titlePhotoLink = titlePhotoLink;
	}

	public String getTitleLink() {
		return titleLink;
	}

	public void setTitleLink(String titleLink) {
		this.titleLink = titleLink;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}
	
	
}
