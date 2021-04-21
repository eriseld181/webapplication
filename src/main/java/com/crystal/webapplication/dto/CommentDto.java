package com.crystal.webapplication.dto;

import java.util.Date;

public class CommentDto {
	
	private String comment_text_dto;
	private String comment_author_dto;
	private Date comment_date_dto;
	
	public CommentDto(String comment_text_dto, String comment_author_dto, Date comment_date_dto) {
		this.comment_text_dto = comment_text_dto;
		this.comment_author_dto = comment_author_dto;
		this.comment_date_dto = comment_date_dto;
	}

	public String getComment_text() {
		return comment_text_dto;
	}

	public void setComment_text(String comment_text_dto) {
		this.comment_text_dto = comment_text_dto;
	}

	public String getComment_author() {
		return comment_author_dto;
	}

	public void setComment_author(String comment_author_dto) {
		this.comment_author_dto = comment_author_dto;
	}

	public Date getComment_date() {
		return comment_date_dto;
	}

	public void setComment_date(Date comment_date_dto) {
		this.comment_date_dto = comment_date_dto;
	}
	
}
