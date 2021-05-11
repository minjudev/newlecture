package com.petharu.web.service;

import java.sql.Connection;
import java.sql.DriverManager;
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
				+ "        ORDER BY DATETIME DESC"
				+ "    ) N"
				+ ") WHERE NUM BETWEEN 1 AND 12";
		
		String url = "jdbc:oracle:thin:@hi.namoolab.com:1521/xepdb1";
		Class.forName("oracle.jdbc.OracleDriver"); 
		Connection con = DriverManager.getConnection(url, "PETHARU", "1357");
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(sql);
		
		while(rs.next()) {
			
			// Knowhow 데이터
			int id = rs.getInt("id");
			String userId = rs.getString("user_id");
			String pet = rs.getString("pet");
			String title = rs.getString("title");
			String content = rs.getString("user_id");
			Date dateTime = rs.getDate("datetime");
			int hit = rs.getInt("hit");
			int like = rs.getInt("like");

			// list에 담아주기
			Knowhow knowhow = new Knowhow();
			knowhow.setId(id);
			knowhow.setUserId(userId);
			knowhow.setPet(pet);
			knowhow.setTitle(title);
			knowhow.setContent(content);
			knowhow.setDateTime(dateTime);
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
			
			// Knowhow 데이터
			String userId = rs.getString("user_id");
			String pet = rs.getString("pet");
			String title = rs.getString("title");
			String content = rs.getString("user_id");
			Date dateTime = rs.getDate("datetime");
			int hit = rs.getInt("hit");
			int like = rs.getInt("like");
			
			// list에 담아주기
			knowhow = new Knowhow();
			knowhow.setId(id);
			knowhow.setUserId(userId);
			knowhow.setPet(pet);
			knowhow.setTitle(title);
			knowhow.setContent(content);
			knowhow.setDateTime(dateTime);
			knowhow.setHit(hit);
			knowhow.setLike(like);	  			
		}
		
		rs.close();
		st.close();
		con.close();
		
		return knowhow;
	}
	 	
	
}
