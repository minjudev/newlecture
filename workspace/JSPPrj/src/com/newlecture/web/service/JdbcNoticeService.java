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
		
		return getList(1, "title", ""); // getList의 인자가 있든 없든(사용자의 검색 요청이 없을 때도) getList 오버로드 함수를 실행시켜주기 위해 해당 코드 작성
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
		
		// 필터링, 정렬 그룹핑, .... -> SQL에서 해결하자
		String sql = "SELECT * FROM (" 
				+ "    SELECT ROWNUM NUM, N.* " // 윗줄과 아랫줄 사이 공백 필요 여부 잘 확인하기
				+ "    FROM ("
				+ "        SELECT * FROM NOTICE"
				+ "        WHERE "+field+" LIKE '%"+query+"%'" // field(제목 or 작성자), query(사용자가 검색한 값)
				+ "        ORDER BY REGDATE DESC"
				+ "    ) N "
				+ ")"
				+ "WHERE NUM BETWEEN "+startNum+" AND "+endNum;
		
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
			Date regDate = rs.getDate("regDate");
			int hit = rs.getInt("hit");
			String files = rs.getString("files");
			
			// list에 담아주는 작업
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
		con.close(); // 동접가가 많아도 접속이 정상적으로 되게 하려면 연결을 끊어줘야 함 
					 // connection은 제일 마지막에 연결 끊기(연결 끊을 때는 역순으로 끊어주기)
					 // 성능 개선 가능
		return list;
				
	}

	public Notice get(int id) throws ClassNotFoundException, SQLException {
		
		String url = "jdbc:oracle:thin:@hi.namoolab.com:1521/xepdb1";
		String sql = "SELECT * FROM NOTICE WHERE ID = " + id; // 문자열 + 정수 -> 문자열 변환
		
		Class.forName("oracle.jdbc.OracleDriver"); 
		Connection con = DriverManager.getConnection(url, "NEWLEC", "11111"); // 서블릿 프로세스가 끝나면 연결이 끊어짐
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(sql);
		
		Notice notice = null;
		
		if(rs.next()) {
			
			// Notice 데이터
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
	
	public int getCount(String field, String query) throws SQLException, ClassNotFoundException { // 검색한 결과값이 총 몇 페이지인지 알아내야 함
		
		int count = 0;
				
		String url = "jdbc:oracle:thin:@hi.namoolab.com:1521/xepdb1";
		
		String sql = "SELECT COUNT(ID) COUNT FROM NOTICE"
				+ "        WHERE "+field+" LIKE '%"+query+"%'";
		
		Class.forName("oracle.jdbc.OracleDriver"); 
		Connection con = DriverManager.getConnection(url, "NEWLEC", "11111"); // 서블릿 프로세스가 끝나면 연결이 끊어짐
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(sql);
		
		if(rs.next())
			count = rs.getInt("COUNT");
	
		rs.close();
		st.close();
		con.close(); 
		
		return count;
	}

	// 이렇게 하면 update해야 할 컬럼이 많아질수록 update 메소드의 개수가 많아짐
//	public int update(int id, String title, String content) { // update된 레코드를 반환하는 것을 기본으로 해서 반환값 int로 하기
//
//		int result = 0;
//		
//		return result;
//	}
	
	// 범용으로 쓰는 update는 update하고자 하지 않는 나머지 컬럼의 데이터가 유지되지 않음
	// 전체에서 특정 부분만 바꾸더라도 전체(notice 객체)를 다 넘겨주기(나머지 컬럼이 null이 되는 것을 방지하기 위해)
	public int update(Notice notice) throws ClassNotFoundException, SQLException {
		int result = 0;
		
		// 바꿀 부분은 ?로 채워주기
		String sql = "UPDATE NOTICE SET TITLE=?, CONTENT=?, HIT=?, FILES=? WHERE ID=?";
		
		String url = "jdbc:oracle:thin:@hi.namoolab.com:1521/xepdb1";	
		Class.forName("oracle.jdbc.OracleDriver"); 
		Connection con = DriverManager.getConnection(url, "NEWLEC", "11111"); // 서블릿 프로세스가 끝나면 연결이 끊어짐

		// statement 기능을 모두 가지고 있으면서 prepare라는 기능도 확장되서 가지고 있는 PreparedStatement
		// 기존의 st는 sql을 가지고 있지 않음, 하지만 preparest는 태어날 때부터 sql을 갖게 만들어짐, 태어날 때부터 sql을 준비
		// 데이터를 꽂아줄 수 있는 기능이 포함되어있음, 데이터를 순서대로 꽂기
		// sql이 아직 완성되지 않은 상태이므로 실행할 때 꽂아주면 안됨
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, notice.getTitle());
		st.setString(2,  notice.getContent());
		st.setInt(3,  notice.getHit());
		st.setString(4,  notice.getFiles());
		st.setInt(5, notice.getId());
		
		// 실행할 때는 sql을 가지고 실행하지 않음
		// query를 하는 건 결과집합을 만들어낼 때만 query를 함(select의 경우)
		// st.executeQuery(); // select
		// 업데이트된 결과의 개수(result)를 알아오게 됨
		result = st.executeUpdate(); // update/delete/insert -> 결과집합이 없음
		
		st.close();
		con.close();
		
		return result;
	}
	
	public int insert(Notice notice) throws ClassNotFoundException, SQLException {
		int result = 0;
		
		// 바꿀 부분은 ?로 채워주기
		String sql = "INSERT INTO NOTICE(TITLE, WRITER_ID, CONTENT) VALUES(?, ?, ?)";
		
		String url = "jdbc:oracle:thin:@hi.namoolab.com:1521/xepdb1";	
		Class.forName("oracle.jdbc.OracleDriver"); 
		Connection con = DriverManager.getConnection(url, "NEWLEC", "11111"); // 서블릿 프로세스가 끝나면 연결이 끊어짐

		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, notice.getTitle());
		st.setString(2, notice.getWriterId());
		st.setString(3,  notice.getContent());
		
		result = st.executeUpdate(); // update/delete/insert -> 결과집합이 없음
		
		st.close();
		con.close();
		
		return result; // result에 1 이상의 숫자가 아닌 유효하지 않은 숫자가 나오면 오류 발생
	}
	
	// id는 유일한 식별자이므로 지워질 때 하나의 레코드만 지워질 것임
	public int delete(int id) throws ClassNotFoundException, SQLException {
		int result = 0;
		
		// 바꿀 부분은 ?로 채워주기
		String sql = "DELETE FROM NOTICE WHERE ID=?"; // id만 넘겨받으면 됨
		
		String url = "jdbc:oracle:thin:@hi.namoolab.com:1521/xepdb1";	
		Class.forName("oracle.jdbc.OracleDriver"); 
		Connection con = DriverManager.getConnection(url, "NEWLEC", "11111"); // 서블릿 프로세스가 끝나면 연결이 끊어짐

		PreparedStatement st = con.prepareStatement(sql);
		st.setInt(1, id);
		
		result = st.executeUpdate(); // update/delete/insert -> 결과집합이 없음
		
		st.close();
		con.close();
		
		return result;
	}
}
