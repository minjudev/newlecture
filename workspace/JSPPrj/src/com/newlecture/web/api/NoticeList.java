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

import com.google.gson.Gson;
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
			String f = req.getParameter("f");
			String q = req.getParameter("q");
			
			int page = 1;
			String field = "title";
			String query = "";
			
			if(p != null && !p.equals(""))
				page = Integer.parseInt(p);
			
			if(f != null && !f.equals(""))
				field = f;
			
			if(q != null && !q.equals(""))
				query = q;
				
			NoticeService noticeService = new NoticeService();
			List<Notice> list = noticeService.getList(page, field, query);
			
			Thread.sleep(3000);
			
//			out.println(list); // println이 알아서 toString()으로 변환해서 출력해줌
							   // 운이 좋게 out이 객체인 list를 , , , 이렇게 나눠서 출력해준 것
							   // 객체인 list를 문자열로 바꿔서 출력해야지 원래는 이렇게 바로 출력하면 안됨
			
			// list 객체를 문자열로 바꿔주는 라이브러리를 쓰자
			Gson gson = new Gson();
			
			String json = gson.toJson(list); // 어떤 객체, 어떤 배열이든 json 문자열로 반환해줌
			
			out.println(json);
		
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
