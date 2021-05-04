package com.newlecture.web.api;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.newlecture.web.entity.Notice;
import com.newlecture.web.service.NoticeService;

@WebServlet("/api/notice/list")
public class NoticeList extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
	
		/*
		 * try { Thread.sleep(10000); // ���⼭ ���缭 10�ʵ��� ������� X } catch
		 * (InterruptedException e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); } // 10��
		 */		
//		out.write("sample data"); // 10�� �Ŀ� ��µ�
		
		try {
			
			String p = req.getParameter("p");
			int page = 1;
			
			if(p != null && !p.equals(""))
				page = Integer.parseInt(p);
			
			NoticeService noticeService = new NoticeService();
			List<Notice> list = noticeService.getList(page, "title", "");
			
			out.println(list); // println�� �˾Ƽ� toString()���� ��ȯ�ؼ� �������
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
}
