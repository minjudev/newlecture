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
	
	// service가 main 함수를 대신함
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
		
		// binary 코드 출력
        // resp.getOutputStream();
		
		// 문자열 출력
		PrintWriter out = resp.getWriter();
		out.println(x + y);
		
		System.out.println("calc");
	}
}
