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

@WebServlet("/notice/edit") 
public class EditController extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id")); // hidden으로 심은 name 값에서 가져온 id(post로 제출했으므로 url에는 나타나지 않음)
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		// title, content를 바꾸려 할 때는 바꾸고자 하는 특정 id가 필요
		NoticeService service = new NoticeService();
		
//		service.update(id, title, content);
		
		Notice notice;
		try {
			
			notice = service.get(id);
			notice.setTitle(title); // update할 내용만 set 메서드로 바꾸기
			notice.setContent(content);
			service.update(notice);
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		response.sendRedirect("detail.jsp?id="+id);
		
	}
}
