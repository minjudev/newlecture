package com.petharu.web.entity;

import java.util.Date;

public class Diary {

	private int id;
	private int memberId;
	private String keyword;
	private String content;
	private Date regDate;
	private String image;
	
	public Diary() {
		// TODO Auto-generated constructor stub
	}

	public Diary(int id, int memberId, String keyword, String content, Date regDate, String image) {
		super();
		this.id = id;
		this.memberId = memberId;
		this.keyword = keyword;
		this.content = content;
		this.regDate = regDate;
		this.image = image;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getMemberId() {
		return memberId;
	}

	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	@Override
	public String toString() {
		return "Diary [id=" + id + ", memberId=" + memberId + ", keyword=" + keyword + ", content=" + content
				+ ", regDate=" + regDate + ", image=" + image + "]";
	}
	
}
