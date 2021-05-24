package com.newlecture.web.service;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.newlecture.web.entity.Notice;

public class JdbcNoticeService implements NoticeService {
	
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
			Date regDate = rs.getDate("regDate");
			int hit = rs.getInt("hit");
			String files = rs.getString("files");
			
			// list�� ����ִ� �۾�
			Notice notice = new Notice();
			notice.setId(id);
			notice.setTitle(title);
			notice.setWriterId(writerId);
			notice.setContent(content);
			notice.setRegDate(regDate);
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

	public Notice get(int id) throws ClassNotFoundException, SQLException {
		
		String url = "jdbc:oracle:thin:@hi.namoolab.com:1521/xepdb1";
		String sql = "SELECT * FROM NOTICE WHERE ID = " + id; // ���ڿ� + ���� -> ���ڿ� ��ȯ
		
		Class.forName("oracle.jdbc.OracleDriver"); 
		Connection con = DriverManager.getConnection(url, "NEWLEC", "11111"); // ���� ���μ����� ������ ������ ������
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(sql);
		
		Notice notice = null;
		
		if(rs.next()) {
			
			// Notice ������
			String title = rs.getString("title");
			String writerId = rs.getString("writer_id");
			String content = rs.getString("content");
			Date regDate = rs.getDate("regDate");
			int hit = rs.getInt("hit");
			String files = rs.getString("files");
			
			notice = new Notice();
			notice.setId(id);
			notice.setTitle(title);
			notice.setWriterId(writerId);
			notice.setContent(content);
			notice.setRegDate(regDate);
			notice.setHit(hit);
			notice.setFiles(files);
		}
		
		rs.close();
		st.close();
		con.close();
		
		System.out.println(notice);
		
		return notice;
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

	// �̷��� �ϸ� update�ؾ� �� �÷��� ���������� update �޼ҵ��� ������ ������
//	public int update(int id, String title, String content) { // update�� ���ڵ带 ��ȯ�ϴ� ���� �⺻���� �ؼ� ��ȯ�� int�� �ϱ�
//
//		int result = 0;
//		
//		return result;
//	}
	
	// �������� ���� update�� update�ϰ��� ���� �ʴ� ������ �÷��� �����Ͱ� �������� ����
	// ��ü���� Ư�� �κи� �ٲٴ��� ��ü(notice ��ü)�� �� �Ѱ��ֱ�(������ �÷��� null�� �Ǵ� ���� �����ϱ� ����)
	public int update(Notice notice) throws ClassNotFoundException, SQLException {
		int result = 0;
		
		// �ٲ� �κ��� ?�� ä���ֱ�
		String sql = "UPDATE NOTICE SET TITLE=?, CONTENT=?, HIT=?, FILES=? WHERE ID=?";
		
		String url = "jdbc:oracle:thin:@hi.namoolab.com:1521/xepdb1";	
		Class.forName("oracle.jdbc.OracleDriver"); 
		Connection con = DriverManager.getConnection(url, "NEWLEC", "11111"); // ���� ���μ����� ������ ������ ������

		// statement ����� ��� ������ �����鼭 prepare��� ��ɵ� Ȯ��Ǽ� ������ �ִ� PreparedStatement
		// ������ st�� sql�� ������ ���� ����, ������ preparest�� �¾ ������ sql�� ���� �������, �¾ ������ sql�� �غ�
		// �����͸� �Ⱦ��� �� �ִ� ����� ���ԵǾ�����, �����͸� ������� �ȱ�
		// sql�� ���� �ϼ����� ���� �����̹Ƿ� ������ �� �Ⱦ��ָ� �ȵ�
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, notice.getTitle());
		st.setString(2,  notice.getContent());
		st.setInt(3,  notice.getHit());
		st.setString(4,  notice.getFiles());
		st.setInt(5, notice.getId());
		
		// ������ ���� sql�� ������ �������� ����
		// query�� �ϴ� �� ��������� ���� ���� query�� ��(select�� ���)
		// st.executeQuery(); // select
		// ������Ʈ�� ����� ����(result)�� �˾ƿ��� ��
		result = st.executeUpdate(); // update/delete/insert -> ��������� ����
		
		st.close();
		con.close();
		
		return result;
	}
	
	public int insert(Notice notice) throws ClassNotFoundException, SQLException {
		int result = 0;
		
		// �ٲ� �κ��� ?�� ä���ֱ�
		String sql = "INSERT INTO NOTICE(TITLE, WRITER_ID, CONTENT) VALUES(?, ?, ?)";
		
		String url = "jdbc:oracle:thin:@hi.namoolab.com:1521/xepdb1";	
		Class.forName("oracle.jdbc.OracleDriver"); 
		Connection con = DriverManager.getConnection(url, "NEWLEC", "11111"); // ���� ���μ����� ������ ������ ������

		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, notice.getTitle());
		st.setString(2, notice.getWriterId());
		st.setString(3,  notice.getContent());
		
		result = st.executeUpdate(); // update/delete/insert -> ��������� ����
		
		st.close();
		con.close();
		
		return result; // result�� 1 �̻��� ���ڰ� �ƴ� ��ȿ���� ���� ���ڰ� ������ ���� �߻�
	}
	
	// id�� ������ �ĺ����̹Ƿ� ������ �� �ϳ��� ���ڵ常 ������ ����
	public int delete(int id) throws ClassNotFoundException, SQLException {
		int result = 0;
		
		// �ٲ� �κ��� ?�� ä���ֱ�
		String sql = "DELETE FROM NOTICE WHERE ID=?"; // id�� �Ѱܹ����� ��
		
		String url = "jdbc:oracle:thin:@hi.namoolab.com:1521/xepdb1";	
		Class.forName("oracle.jdbc.OracleDriver"); 
		Connection con = DriverManager.getConnection(url, "NEWLEC", "11111"); // ���� ���μ����� ������ ������ ������

		PreparedStatement st = con.prepareStatement(sql);
		st.setInt(1, id);
		
		result = st.executeUpdate(); // update/delete/insert -> ��������� ����
		
		st.close();
		con.close();
		
		return result;
	}
}
