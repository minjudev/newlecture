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
		 * try { Thread.sleep(10000); // 여기서 멈춰서 10초동안 진행되지 X } catch
		 * (InterruptedException e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); } // 10초
		 */		
//		out.write("sample data"); // 10초 후에 출력됨
		
		try {
			
			String p = req.getParameter("p");
			int page = 1;
			
			if(p != null && !p.equals(""))
				page = Integer.parseInt(p);
			
			NoticeService noticeService = new NoticeService();
			List<Notice> list = noticeService.getList(page, "title", "");
			
			out.println(list); // println이 알아서 toString()으로 변환해서 출력해줌
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
}
