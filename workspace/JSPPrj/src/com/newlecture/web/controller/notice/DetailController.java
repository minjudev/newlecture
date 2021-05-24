package com.newlecture.web.controller.notice;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.newlecture.web.entity.Notice;
import com.newlecture.web.service.JdbcNoticeService;

@WebServlet("/notice/detail")
public class DetailController extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// HTML 코드와 분리해 자바 코드를 따로 만들어줬기 때문에 미리 컴파일 가능!
		// 이제 코드를 로드해서 실행만 하면 됨
		// 작업 코드가 따라 나와서 자바 개발자가 따로 작업 가능 -> 업무의 효율성이 높아짐
		// html, 자바 코드를 함께 썼을 때는 자바에서 변수가 필요했음(ex. notice)
		
		String id_ = request.getParameter("id"); // 사용자에게 아이디 받기
		int id = Integer.parseInt(id_); // 무조건 id 값이 오게 해서 id 값 념겨주기

		JdbcNoticeService noticeService = new JdbcNoticeService();
		Notice notice = null;
		
		try {
			notice = noticeService.get(id);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
				
	 	request.setAttribute("notice", notice); // notice 담아주기
	
	 	request.getRequestDispatcher("detail.jsp").forward(request, response);
	}
  
}
