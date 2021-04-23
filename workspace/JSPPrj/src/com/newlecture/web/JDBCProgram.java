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
		
		System.out.println("-------[�˻��� ������]-------");
		
		MemberService memberService = new MemberService();
		Member[] list = memberService.getList();

		
//		String url = "jdbc:oracle:thin:@hi.namoolab.com:1521/xepdb1";
//		String sql = "SELECT * FROM MEMBER WHERE NICNAME=" + "'" + nickname + "'"; // SQL������ �����ݷ� ���� �ʱ�
//		String sql = String.format("SELECT * FROM MEMBER WHERE NICNAME='%s'", nickname);
//		
//		// API�� �̿��� DB�� �����ؼ� ����ϱ�
//		Class.forName("oracle.jdbc.OracleDriver"); // �� ���� �� ���൵ ��
//		Connection con = DriverManager.getConnection(url, "NEWLEC", "11111"); // JDBC�� DB ����
//		Statement st = con.createStatement();
//		ResultSet rs = st.executeQuery(sql);
//		
//		// ������ ������������ �˷���, �����Ͱ� ������ �� ������ rs.next()�� true�� ��ȯ
//		// �ڹٰ� �����͸� �����ͼ� ���� ó������ �ʰ� SQL�� ó���ϰ� �ϱ�
//		while(rs.next()) {
//			// ��� ������
//			int id = rs.getInt("id");
//			String nickName = rs.getString("nicname");
//			String pwd = rs.getString("pwd");
//			// �ֿܼ� �ڵ带 �и�����
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
