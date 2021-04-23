package com.newlecture.web.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.newlecture.web.entity.Member;

public class MemberService {
	
	public Member[] getList() throws ClassNotFoundException, SQLException {
		
		// 배열 준비 시 공간을 정의할 수 없는 경우가 있음 - DB에서 계속 변화되는 데이터를 가져와야할 때 
		// 가변크기 배열에 대한 필요성
		Member[] list = new Member[21];
		int i = 0;
		
		String url = "jdbc:oracle:thin:@hi.namoolab.com:1521/xepdb1";
//		String sql = String.format("SELECT * FROM MEMBER WHERE NICNAME='%s'", nickname);
		String sql = "SELECT * FROM MEMBER";
		
		Class.forName("oracle.jdbc.OracleDriver"); 
		Connection con = DriverManager.getConnection(url, "NEWLEC", "11111"); 
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(sql);
		
		while(rs.next()) {
			// 멤버 데이터
			int id = rs.getInt("id");
			String nickName = rs.getString("nicname");
			String pwd = rs.getString("pwd");
			
			// list에 담아주는 작업
			Member member = new Member();
			member.setId(id);
			member.setNickName(nickName);
			member.setPwd(pwd);
			
			list[i++] = member;
//			list[i++] = new Member(id, nickName, pwd);
		}
		
		return list;
	}

}
