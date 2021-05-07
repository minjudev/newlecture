package com.newlecture.web.controller.lecture;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.newlecture.web.entity.Notice;
import com.newlecture.web.service.NoticeService;

@WebServlet("/notice/reg") 
public class RegController extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		NoticeService service = new NoticeService();
		
//		service.update(id, title, content);
				
		try {
			
			Notice notice = new Notice();
			notice.setTitle(title); // update할 내용만 set 메서드로 바꾸기
			notice.setWriterId("minju");
			notice.setContent(content);
			service.insert(notice);
			// service.insert(title, content);
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		response.sendRedirect("list.jsp");
	}
}
