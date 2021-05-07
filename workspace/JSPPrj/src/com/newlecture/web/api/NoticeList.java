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
		 * try { Thread.sleep(10000); // ���⼭ ���缭 10�ʵ��� ������� X } catch
		 * (InterruptedException e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); } // 10��
		 */		
//		out.write("sample data"); // 10�� �Ŀ� ��µ�
		
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
			
//			out.println(list); // println�� �˾Ƽ� toString()���� ��ȯ�ؼ� �������
							   // ���� ���� out�� ��ü�� list�� , , , �̷��� ������ ������� ��
							   // ��ü�� list�� ���ڿ��� �ٲ㼭 ����ؾ��� ������ �̷��� �ٷ� ����ϸ� �ȵ�
			
			// list ��ü�� ���ڿ��� �ٲ��ִ� ���̺귯���� ����
			Gson gson = new Gson();
			
			String json = gson.toJson(list); // � ��ü, � �迭�̵� json ���ڿ��� ��ȯ����
			
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
