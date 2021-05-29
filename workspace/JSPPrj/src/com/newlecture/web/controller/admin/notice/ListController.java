package com.newlecture.web.controller.admin.notice;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.newlecture.web.entity.Notice;
import com.newlecture.web.service.JdbcNoticeService;

@WebServlet("/admin/notice/list")
public class ListController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		response.setContentType("application/x-json; charset=UTF-8");
		
		String p = request.getParameter("p");
		String f = request.getParameter("f");
		String q = request.getParameter("q");
		
		System.out.println(p);
		System.out.println(f);
		System.out.println(q);
		
		// 변수 초기화: 기본 값을 설정하는 것
		int page_ = 1; // jsp가 가지고 있는 내장 변수가 페이지라는 이름을 사용하고 있어서 오류 발생
		String field = "title";
		String query = "";
		
		// 사용자가 입력한 값으로 대치
		if(p != null && !p.equals(""))
			page_ = Integer.parseInt(p);
		
		if(f != null && !f.equals(""))
			field = f;
		
		if(q != null && !q.equals(""))
			query = q;
		
		JdbcNoticeService noticeService = new JdbcNoticeService();
		List<Notice> list = null;
		int count = 0;
		
    	try {
			count = noticeService.getCount(field, query);
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try {
			list = noticeService.getList(page_, field, query);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		// 1. 데이터 심기
		request.setAttribute("list", list);
		request.setAttribute("count", count);
		System.out.println(list);
		
		// 2. 포워딩하기
		request.getRequestDispatcher("/WEB-INF/view/admin/notice/list.jsp").forward(request, response);
	}
	
}
