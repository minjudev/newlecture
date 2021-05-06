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
		int id = Integer.parseInt(request.getParameter("id")); // hidden���� ���� name ������ ������ id(post�� ���������Ƿ� url���� ��Ÿ���� ����)
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		// title, content�� �ٲٷ� �� ���� �ٲٰ��� �ϴ� Ư�� id�� �ʿ�
		NoticeService service = new NoticeService();
		
//		service.update(id, title, content);
		
		Notice notice;
		try {
			
			notice = service.get(id);
			notice.setTitle(title); // update�� ���븸 set �޼���� �ٲٱ�
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
