package com.petharu.web.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.petharu.web.entity.Knowhow;

public class KnowhowService {

	public List<Knowhow> getList() throws ClassNotFoundException, SQLException {
		
		List<Knowhow> list = new ArrayList<>();
		
		String sql = "SELECT * FROM ("
				+ "    SELECT ROWNUM NUM, N.* FROM ("
				+ "        SELECT * FROM KNOWHOW"
				+ "        ORDER BY REGDATE DESC"
				+ "    ) N"
				+ ") WHERE NUM BETWEEN 1 AND 12";
		
		String url = "jdbc:oracle:thin:@hi.namoolab.com:1521/xepdb1";
		Class.forName("oracle.jdbc.OracleDriver"); 
		Connection con = DriverManager.getConnection(url, "PETHARU", "1357");
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(sql);
		
		while(rs.next()) {
			
			// Knowhow ������
			int id = rs.getInt("id");
			String userId = rs.getString("user_id");
			String pet = rs.getString("pet");
			String title = rs.getString("title");
			String content = rs.getString("user_id");
			Date regDate = rs.getDate("regDate");
			int hit = rs.getInt("hit");
			int like = rs.getInt("like");

			// list�� ����ֱ�
			Knowhow knowhow = new Knowhow();
			knowhow.setId(id);
			knowhow.setUserId(userId);
			knowhow.setPet(pet);
			knowhow.setTitle(title);
			knowhow.setContent(content);
			knowhow.setRegDate(regDate);
			knowhow.setHit(hit);
			knowhow.setLike(like);
			
			list.add(knowhow);
		}
		
		rs.close();
		st.close();
		con.close();
		
		return list;
	}
	
	
	public Knowhow get(int id) throws ClassNotFoundException, SQLException {
	  	  
		String sql = "SELECT * FROM KNOWHOW WHERE ID =" + id;
			
		String url = "jdbc:oracle:thin:@hi.namoolab.com:1521/xepdb1";
		Class.forName("oracle.jdbc.OracleDriver"); 
		Connection con = DriverManager.getConnection(url, "PETHARU", "1357");
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(sql);
		
		Knowhow knowhow = null;
		
		if(rs.next()) {
			
			// Knowhow ������
			String userId = rs.getString("user_id");
			String pet = rs.getString("pet");
			String title = rs.getString("title");
			String content = rs.getString("content");
			Date regDate = rs.getDate("regdate");
			int hit = rs.getInt("hit");
			int like = rs.getInt("like");
			
			// list�� ����ֱ�
			knowhow = new Knowhow();
			knowhow.setId(id);
			knowhow.setUserId(userId);
			knowhow.setPet(pet);
			knowhow.setTitle(title);
			knowhow.setContent(content);
			knowhow.setRegDate(regDate);
			knowhow.setHit(hit);
			knowhow.setLike(like);	  			
		}
		
		rs.close();
		st.close();
		con.close();
		
		return knowhow;
	}

	public int insert(Knowhow knowhow) throws ClassNotFoundException, SQLException {
		
		int result = 0;
		
//		String sql = String.format("INSERT INTO KNOWHOW(ID, USER_ID, PET, TITLE, CONTENT, HIT, %s) VALUES(KNOWHOW_SEQ.NEXTVAL, ?, ?, ?, ?, ?, ?)", "LIKE");  

		String sql = "INSERT INTO KNOWHOW(ID, USER_ID, PET, TITLE, CONTENT, HIT, \"LIKE\") VALUES(KNOWHOW_SEQ.NEXTVAL, ?, ?, ?, ?, ?, ?)";
		
		String url = "jdbc:oracle:thin:@hi.namoolab.com:1521/xepdb1";
		Class.forName("oracle.jdbc.OracleDriver"); 
		Connection con = DriverManager.getConnection(url, "PETHARU", "1357");
		
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, knowhow.getUserId());
		st.setString(2, knowhow.getPet());
		st.setString(3, knowhow.getTitle());
		st.setString(4, knowhow.getContent());
		st.setInt(5, knowhow.getHit());
		st.setInt(6, knowhow.getLike());

		result = st.executeUpdate();
		
		st.close();
		con.close();
		
		return result;
	}

	public int update(Knowhow knowhow) throws ClassNotFoundException, SQLException {
		int result = 0;

		String sql = "UPDATE KNOWHOW SET USER_ID=?, PET=?, TITLE=?, CONTENT=? WHERE ID=?";
		
		String url = "jdbc:oracle:thin:@hi.namoolab.com:1521/xepdb1";
		Class.forName("oracle.jdbc.OracleDriver"); 
		Connection con = DriverManager.getConnection(url, "PETHARU", "1357");
		
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, knowhow.getUserId());
		st.setString(2, knowhow.getPet());
		st.setString(3, knowhow.getTitle());
		st.setString(4, knowhow.getContent());
		st.setInt(5, knowhow.getId());

		result = st.executeUpdate();
		
		st.close();
		con.close();
		
		return result;
	}


	public int delete(int id) throws ClassNotFoundException, SQLException {
		int result  = 0;
		
		String sql = "DELETE KNOWHOW WHERE ID=?";
		
		String url = "jdbc:oracle:thin:@hi.namoolab.com:1521/xepdb1";
		Class.forName("oracle.jdbc.OracleDriver"); 
		Connection con = DriverManager.getConnection(url, "PETHARU", "1357");
		
		PreparedStatement st = con.prepareStatement(sql);
		st.setInt(1, id);
		
		result = st.executeUpdate();
		
		st.close();
		con.close();
		
		return result;
	}
}
