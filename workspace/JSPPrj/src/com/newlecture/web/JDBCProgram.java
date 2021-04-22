package com.newlecture.web;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class JDBCProgram {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		/*
		 * 
		 * 사용자의 닉네임 입력받기
		 * 입력받은 사용자의 정보 보여주기
		 * id, nickname, pwd
		 * 
		 */
		
		System.out.print("nickname: ");
		Scanner scan = new Scanner(System.in);
		String nickname = scan.nextLine();
		
		System.out.println("-------[검색된 데이터]-------");
		
		String url = "jdbc:oracle:thin:@hi.namoolab.com:1521/xepdb1";
		String sql = "SELECT * FROM MEMBER WHERE NICNAME=" + "'" + nickname +"'"; // SQL문에서 세미콜론 하지 않기
		
		// API를 이용해 DB와 연결해서 사용하기
		Class.forName("oracle.jdbc.OracleDriver"); // 이 줄은 안 써줘도 됨, 이 코드가 객체화를 시키는 작업은 아니지만 아래 코드가 가능한 이유
		Connection con = DriverManager.getConnection(url, "NEWLEC", "11111"); // JDBC와 연결
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(sql);
		
		// 마지막 데이터인지를 알려줌, 데이터가 다음에 더 있으면 rs.next()가 true를 반환
		// 자바가 데이터를 가져와서 조건 처리하지 않고 SQL로 처리하게 하기
		while(rs.next()) {
			// 멤버 데이터
			int id = rs.getInt("id");
			String nickName = rs.getString("nicname");
			String password = rs.getString("pwd");
			// 콘솔용 코드를 분리하자
			System.out.printf("id: %d, nickname: %s, pwd: %s\n", id, nickName, password);				
		}
	}

}
