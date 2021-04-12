package com.newlecture.web;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class Nana extends HttpServlet {
	public void service(HttpServletRequest request /*사용자가 보내온 입력값을 사용할 수 있는 도구*/, 
			HttpServletResponse response /*사용자에게 응답할 내용을 담아놓는 도구*/) 
			throws IOException, ServletException {
		
		int count = 10;
		
		// 사용자가 전달하는 값 이용하기
		String c = request.getParameter("c");
		
		
//		콘솔에 찍히지 않고 웹 브라우저 사용자에게 결과물을 출력해줌
//		문자열 출력 - PrintWriter 이용
		PrintWriter out = response.getWriter();
		out.println("[2,3,4,5]");
		
		
//		if(c != null)
//			count = Integer.parseInt(c);
//		
//		for(int i=0; i<count; i++)
//			out.println("Hello Servlet!");
			
		// 문서를 출력 -> Browser : 문서를 백엔드에서 개발
		// 데이터를 출력 -> JavaScript : 문서를 프론트엔드에서 개발
		// js가 데이터 요청 -> 현재 열려있는 페이지에 데이터 꽂아놓음
		
		
	}

}