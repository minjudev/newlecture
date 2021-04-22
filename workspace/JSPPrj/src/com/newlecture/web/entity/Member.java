package com.newlecture.web.entity;

import java.util.Date;

// 자바에서도 MEMBER 데이터를 사용할 것이므로 SQL의 MEMBER 테이블과 동일한 구조를 만들어주기
public class Member {
	private int id;
	private String nickName;
	private String pwd;
	private String name;
	private String gender;
	private String birthday;
	private String phone;
	private String email;
	private Date regdate;
	private String address;
	
	public Member() {

	}

	public Member(int id, String nickName, String pwd, String name, String gender, String birthday, String phone,
			String email, Date regdate, String address) {
		super();
		this.id = id;
		this.nickName = nickName;
		this.pwd = pwd;
		this.name = name;
		this.gender = gender;
		this.birthday = birthday;
		this.phone = phone;
		this.email = email;
		this.regdate = regdate;
		this.address = address;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNicName(String nickName) {
		this.nickName = nickName;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getRegdate() {
		return regdate;
	}

	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Member [id=" + id + ", nickName=" + nickName + ", pwd=" + pwd + ", name=" + name + ", gender=" + gender
				+ ", birthday=" + birthday + ", phone=" + phone + ", email=" + email + ", regdate=" + regdate
				+ ", address=" + address + "]";
	}
	
}
