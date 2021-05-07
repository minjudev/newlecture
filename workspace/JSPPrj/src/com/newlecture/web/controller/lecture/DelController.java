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

@WebServlet("/notice/del") 
public class DelController extends HttpServlet {
	
	// GET 요청으로 보냄, (삭제할 때도 어떤 데이터를 보내면서 삭제한다면) POST도 가능하긴 함
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int id = Integer.parseInt(request.getParameter("id"));
		
		NoticeService service = new NoticeService();
		
//		service.update(id, title, content);
				
		try {			
			service.delete(id);
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		response.sendRedirect("list.jsp");
	}
}
