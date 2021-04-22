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
		 * ������� �г��� �Է¹ޱ�
		 * �Է¹��� ������� ���� �����ֱ�
		 * id, nickname, pwd
		 * 
		 */
		
		System.out.print("nickname: ");
		Scanner scan = new Scanner(System.in);
		String nickname = scan.nextLine();
		
		System.out.println("-------[�˻��� ������]-------");
		
		String url = "jdbc:oracle:thin:@hi.namoolab.com:1521/xepdb1";
		String sql = "SELECT * FROM MEMBER WHERE NICNAME=" + "'" + nickname +"'"; // SQL������ �����ݷ� ���� �ʱ�
		
		// API�� �̿��� DB�� �����ؼ� ����ϱ�
		Class.forName("oracle.jdbc.OracleDriver"); // �� ���� �� ���൵ ��, �� �ڵ尡 ��üȭ�� ��Ű�� �۾��� �ƴ����� �Ʒ� �ڵ尡 ������ ����
		Connection con = DriverManager.getConnection(url, "NEWLEC", "11111"); // JDBC�� ����
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(sql);
		
		// ������ ������������ �˷���, �����Ͱ� ������ �� ������ rs.next()�� true�� ��ȯ
		// �ڹٰ� �����͸� �����ͼ� ���� ó������ �ʰ� SQL�� ó���ϰ� �ϱ�
		while(rs.next()) {
			// ��� ������
			int id = rs.getInt("id");
			String nickName = rs.getString("nicname");
			String password = rs.getString("pwd");
			// �ֿܼ� �ڵ带 �и�����
			System.out.printf("id: %d, nickname: %s, pwd: %s\n", id, nickName, password);				
		}
	}

}
