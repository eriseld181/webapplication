package com.crystal.webapplication.dto;

import java.util.Date;

//Object that will be returned to the user
public class CommentDto {
	 
	private String comment_text;
	private String author;
	private Date comment_date;
	
	public CommentDto(String comment_text, String author, Date comment_date) {
		this.comment_text = comment_text;
		this.author = author;
		this.comment_date = comment_date;
	}

	@Override
	public String toString() {
		return "CommentDto [comment_text=" + comment_text + ", author=" + author + ", comment_date=" + comment_date
				+ "]";
	}

	public String getComment_text() {
		return comment_text;
	}

	public void setComment_text(String comment_text) {
		this.comment_text = comment_text;
	}

	public String getComment_author() {
		return author;
	}

	public void setComment_author(String author) {
		this.author = author;
	}

	public Date getComment_date() {
		return comment_date;
	}

	public void setComment_date(Date comment_date_dto) {
		this.comment_date = comment_date_dto;
	}
	
}
