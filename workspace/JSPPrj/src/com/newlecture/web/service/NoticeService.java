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
		
		return getList("title", ""); // getList의 인자가 있든 없든(사용자의 검색 요청이 없을 때도) getList 오버로드 함수를 실행시켜주기 위해 해당 코드 작성
	}
	
	public List<Notice> getList(String field, String query) throws SQLException, ClassNotFoundException {
		
		List<Notice> list = new ArrayList<>();
				
		String url = "jdbc:oracle:thin:@hi.namoolab.com:1521/xepdb1";
//		String sql = String.format("SELECT * FROM MEMBER WHERE NICNAME='%s'", nickname);
		
		// 필터링, 정렬 그룹핑, .... -> SQL에서 진행할 것
		String sql = "SELECT * FROM NOTICE";
		
		Class.forName("oracle.jdbc.OracleDriver"); 
		Connection con = DriverManager.getConnection(url, "NEWLEC", "11111"); // 서블릿 프로세스가 끝나면 연결이 끊어짐
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(sql);
		
		while(rs.next()) {
			
			// Notice 데이터
			int id = rs.getInt("id");
			String title = rs.getString("title");
			String writerId = rs.getString("writer_id");
			String content = rs.getString("content");
			Date redDate = rs.getDate("regDate");
			int hit = rs.getInt("hit");
			String files = rs.getString("files");
			
			// list에 담아주는 작업
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
		con.close(); // 동접가가 많게 하려면 연결을 끊어줘야 함 
					 // connection은 제일 마지막에 연결 끊기(연결 끊을 때는 역순으로 끊어주기)
					 // 성능 개선
		return list;
				
	}

}
