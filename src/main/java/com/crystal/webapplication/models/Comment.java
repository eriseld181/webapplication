package com.crystal.webapplication.models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity(name= "comments")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})

public class Comment {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	private int id;
	private String comment_text;
	private String author;
	private Date comment_date;
	private String approved_by;
	private Date approved_date;
	
	@ManyToOne
	@JoinColumn(name="news_id")
	@JsonIgnore //If we use this annotation, news will be ignored and will not be showed
	private News news;
	
	public Comment() {
		
	}
	public int getComment_id() {
		return id;
	}

	public void setComment_id(int id) {
		this.id = id;
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

	public void setComment_date(Date comment_date) {
		this.comment_date = comment_date;
	}

	public String getComment_approved_by() {
		return approved_by;
	}

	public void setComment_approved_by(String approved_by) {
		this.approved_by = approved_by;
	}

	public Date getComment_approved_date() {
		return approved_date;
	}

	public void setComment_approved_date(Date approved_date) {
		this.approved_date = approved_date;
	}

	public News getNews() {
		return news;
	}
	public void setNews(News news) {
		this.news = news;
	}
	
}
