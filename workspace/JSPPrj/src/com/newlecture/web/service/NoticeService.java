package com.newlecture.web.service;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.newlecture.web.entity.Notice;

public class NoticeService {
	
	public List<Notice> getList() throws ClassNotFoundException, SQLException {
		
		return getList("title", ""); // getList�� ���ڰ� �ֵ� ����(������� �˻� ��û�� ���� ����) getList �����ε� �Լ��� ��������ֱ� ���� �ش� �ڵ� �ۼ�
	}
	
	public List<Notice> getList(String field, String query) throws SQLException, ClassNotFoundException {
		
		List<Notice> list = new ArrayList<>();
				
		String url = "jdbc:oracle:thin:@hi.namoolab.com:1521/xepdb1";
//		String sql = String.format("SELECT * FROM MEMBER WHERE NICNAME='%s'", nickname);
		
		// ���͸�, ���� �׷���, .... -> SQL���� ������ ��
		String sql = "SELECT * FROM NOTICE";
		
		Class.forName("oracle.jdbc.OracleDriver"); 
		Connection con = DriverManager.getConnection(url, "NEWLEC", "11111"); // ���� ���μ����� ������ ������ ������
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(sql);
		
		while(rs.next()) {
			
			// Notice ������
			int id = rs.getInt("id");
			String title = rs.getString("title");
			String writerId = rs.getString("writer_id");
			String content = rs.getString("content");
			Date redDate = rs.getDate("regDate");
			int hit = rs.getInt("hit");
			String files = rs.getString("files");
			
			// list�� ����ִ� �۾�
			Notice notice = new Notice();
			notice.setId(id);
			notice.setTitle(title);
			notice.setWriterId(writerId);
			notice.setContent(content);
			notice.setRegDate(redDate);
			notice.setHit(hit);
			notice.setFiles(files);
			
			list.add(notice);
		}
	
		rs.close();
		st.close();
		con.close(); // �������� ���� �Ϸ��� ������ ������� �� 
					 // connection�� ���� �������� ���� ����(���� ���� ���� �������� �����ֱ�)
					 // ���� ����
		return list;
				
	}

}
