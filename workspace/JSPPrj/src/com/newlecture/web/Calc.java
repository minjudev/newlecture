package com.newlecture.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/add")
public class Calc extends HttpServlet {	
	
	// service�� main �Լ��� �����
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		int x = Integer.parseInt(req.getParameter("x"));
//		int y = Integer.parseInt(req.getParameter("y"));

		int x = 0;
		int y = 0;
		
		String str_x = req.getParameter("x");
		x = Integer.parseInt(str_x);
		String str_y = req.getParameter("y");
		y = Integer.parseInt(str_y);
		
		// binary �ڵ� ���
        // resp.getOutputStream();
		
		// ���ڿ� ���
		PrintWriter out = resp.getWriter();
		out.println(x + y);
		
		System.out.println("calc");
	}
}
