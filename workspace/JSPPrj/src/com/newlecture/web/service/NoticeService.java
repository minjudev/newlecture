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
		
		return getList(1, "title", ""); // getList�� ���ڰ� �ֵ� ����(������� �˻� ��û�� ���� ����) getList �����ε� �Լ��� ��������ֱ� ���� �ش� �ڵ� �ۼ�
	}
	
	public List<Notice> getList(int page, String field, String query) throws SQLException, ClassNotFoundException {
		
		List<Notice> list = new ArrayList<>();
		int size = 10;
		int startNum = 1+(page-1)*size;
		int endNum = page*size;
		
		/*
		 * page : startNum       :       endNum
		 * 1      1                      10
		 * 2      11                     20
		 * 3      21                     30
		 * 
		 *        an=1+(page-1)*size     an=page*size
		 * */
				
		String url = "jdbc:oracle:thin:@hi.namoolab.com:1521/xepdb1";
//		String sql = String.format("SELECT * FROM MEMBER WHERE NICNAME='%s'", nickname);
		
		// ���͸�, ���� �׷���, .... -> SQL���� �ذ�����
		String sql = "SELECT * FROM (" 
				+ "    SELECT ROWNUM NUM, N.* " // ���ٰ� �Ʒ��� ���� ���� �ʿ� ���� �� Ȯ���ϱ�
				+ "    FROM ("
				+ "        SELECT * FROM NOTICE"
				+ "        WHERE "+field+" LIKE '%"+query+"%'" // field(���� or �ۼ���), query(����ڰ� �˻��� ��)
				+ "        ORDER BY REGDATE DESC"
				+ "    ) N "
				+ ")"
				+ "WHERE NUM BETWEEN "+startNum+" AND "+endNum;
		
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
		con.close(); // �������� ���Ƶ� ������ ���������� �ǰ� �Ϸ��� ������ ������� �� 
					 // connection�� ���� �������� ���� ����(���� ���� ���� �������� �����ֱ�)
					 // ���� ���� ����
		return list;
				
	}

	public int getCount(String field, String query) throws SQLException, ClassNotFoundException { // �˻��� ������� �� �� ���������� �˾Ƴ��� ��
		
		int count = 0;
				
		String url = "jdbc:oracle:thin:@hi.namoolab.com:1521/xepdb1";
		
		String sql = "SELECT COUNT(ID) COUNT FROM NOTICE"
				+ "        WHERE "+field+" LIKE '%"+query+"%'";
		
		Class.forName("oracle.jdbc.OracleDriver"); 
		Connection con = DriverManager.getConnection(url, "NEWLEC", "11111"); // ���� ���μ����� ������ ������ ������
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(sql);
		
		if(rs.next())
			count = rs.getInt("COUNT");
	
		rs.close();
		st.close();
		con.close(); 
		
		return count;
	}
}
