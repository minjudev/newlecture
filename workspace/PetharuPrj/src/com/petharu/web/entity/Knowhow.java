package com.petharu.web.entity;

import java.util.Date;

public class Knowhow {

	private int id;
	private String userId;
	private String pet;
	private String title;
	private String content;
	private Date dateTime;
	private int hit;
	private int like;
	
	public Knowhow() {
		
	}

	public Knowhow(int id, String userId, String pet, String title, String content, Date dateTime) {
		super();
		this.id = id;
		this.userId = userId;
		this.pet = pet;
		this.title = title;
		this.content = content;
		this.dateTime = dateTime;
		this.hit = hit;
		this.like = like;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPet() {
		return pet;
	}

	public void setPet(String pet) {
		this.pet = pet;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getDateTime() {
		return dateTime;
	}

	public void setDateTime(Date dateTime) {
		this.dateTime = dateTime;
	}
	
	public int getHit() {
		return hit;
	}

	public void setHit(int hit) {
		this.hit = hit;
	}

	public int getLike() {
		return like;
	}

	public void setLike(int like) {
		this.like = like;
	}

	@Override
	public String toString() {
		return "{\"id\":" + id + ", \"userId\":\"" + userId + "\", \"pet\":\"" + pet + "\", \"title\":\"" + title + "\", \"content\":\"" + content
				+ "\", \"dateTime\":\"" + dateTime + "\", \"hit\":" + hit + ", \"like\":" + like + "}";
	}
	
}
