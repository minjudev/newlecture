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
		
		// HTML �ڵ�� �и��� �ڹ� �ڵ带 ���� �������� ������ �̸� ������ ����!
		// ���� �ڵ带 �ε��ؼ� ���ุ �ϸ� ��
		// �۾� �ڵ尡 ���� ���ͼ� �ڹ� �����ڰ� ���� �۾� ���� -> ������ ȿ������ ������
		// html, �ڹ� �ڵ带 �Բ� ���� ���� �ڹٿ��� ������ �ʿ�����(ex. notice)
		
		String id_ = request.getParameter("id"); // ����ڿ��� ���̵� �ޱ�
		int id = Integer.parseInt(id_); // ������ id ���� ���� �ؼ� id �� ����ֱ�

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
				
	 	request.setAttribute("notice", notice); // notice ����ֱ�
	
	 	request.getRequestDispatcher("detail.jsp").forward(request, response);
	}
  
}
