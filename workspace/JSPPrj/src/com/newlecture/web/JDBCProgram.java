package com.newlecture.web;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.newlecture.web.entity.Member;
import com.newlecture.web.service.MemberService;

public class JDBCProgram {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		System.out.print("nickname: ");
		Scanner scan = new Scanner(System.in);
		String nickname = scan.nextLine();
		
		System.out.println("-------[검색된 데이터]-------");
		
		MemberService memberService = new MemberService();
		Member[] list = memberService.getList();

		
//		String url = "jdbc:oracle:thin:@hi.namoolab.com:1521/xepdb1";
//		String sql = "SELECT * FROM MEMBER WHERE NICNAME=" + "'" + nickname + "'"; // SQL문에서 세미콜론 하지 않기
//		String sql = String.format("SELECT * FROM MEMBER WHERE NICNAME='%s'", nickname);
//		
//		// API를 이용해 DB와 연결해서 사용하기
//		Class.forName("oracle.jdbc.OracleDriver"); // 이 줄은 안 써줘도 됨
//		Connection con = DriverManager.getConnection(url, "NEWLEC", "11111"); // JDBC와 DB 연결
//		Statement st = con.createStatement();
//		ResultSet rs = st.executeQuery(sql);
//		
//		// 마지막 데이터인지를 알려줌, 데이터가 다음에 더 있으면 rs.next()가 true를 반환
//		// 자바가 데이터를 가져와서 조건 처리하지 않고 SQL로 처리하게 하기
//		while(rs.next()) {
//			// 멤버 데이터
//			int id = rs.getInt("id");
//			String nickName = rs.getString("nicname");
//			String pwd = rs.getString("pwd");
//			// 콘솔용 코드를 분리하자
//			System.out.printf("id: %d, nickname: %s, pwd: %s\n", id, nickName, pwd);				
//		}
	
		for(int i=0; i<list.length; i++) {
			Member member = list[i];
			int id = member.getId();
			String nickName = member.getNickName();
			String pwd = member.getPwd();
			
			System.out.printf("id: %d, nickname: %s, pwd: %s\n", id, nickName, pwd);				
		}	
	}

}
