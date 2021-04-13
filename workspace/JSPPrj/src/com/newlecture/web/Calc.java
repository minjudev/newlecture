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

		resp.setCharacterEncoding("UTF-8"); /*UTF-8로 인코딩해서 응답을 보내는 것*/
		resp.setContentType("text/html;charset-UTF-8"); /*브라우저가 읽는 방식*/ /*응답 헤더로 이 문서가 UTF-8이라는 것을 알려주는 것*/
		
		int x = 0;
		int y = 0;
		
		String str_x = req.getParameter("x"); /*str_x에는 ["숫자"]만 와야함*/
		if(str_x != null && !str_x.equals("")) /*기본값 활용하기*/ /*객체가 아닌 값을 비교하도록 .equals() 사용*/
			x = Integer.parseInt(str_x);
		
		String str_y = req.getParameter("y");
		if(str_y != null && !str_y.equals("")) 
			y = Integer.parseInt(str_y);
		
		int result = x + y;
		
		// 1. 계산을 계속할 수 있도록 계산기 UI 출력하기
		// 2. 한글 깨짐 문제 해결하기
		// 3. 계산기에서 계산한 결과 값 외에 계산했던 연산식도 함께 보여주기
		// 4. POST 요청의 기본 값
		// 5. GET 요청과 POST 요청의 이해와 코드 분리하기
		
		// 문서를 동적으로 만드는 코드
		// 이 코드로 만들어진 결과물: 동적인 문서(서버 문서)
		PrintWriter out = resp.getWriter();		
		
		// 사용자에게 덧셈을 할 수 있는 UI를 다시 돌려주기
		out.write("<!DOCTYPE html>");
		out.write("<html>");
		out.write("<head>");
//		out.write("<meta charset=\"UTF-8\">"); /*브라우저에게 내 문서는 UTF로 만들어졌다고 알려주는 것, 브라우저가 문서를 읽을 때 UTF-8로 읽음*/
		out.write("<title>Insert title here</title>");
		out.write("</head>");
		out.write("<body>");
		out.write("	<section>");
		out.write("		<h1>계산기</h1>");
		
		if(str_x != null && str_y != null)
			out.write("		<div>"+x+"+"+y+"=</div>");
		
		out.write("		<div>");
		out.write("			<form action=\"/add\" method=\"post\">"); /*폼 전달 방식이 post이므로 post 메소드를 사용하자*/ /*get: 기본 요청*/
		out.write("				<input type=\"text\" name=\"x\">+<input type=\"text\" name=\"y\"><br>");
		out.write("				<input type=\"submit\" value=\"덧셈\"><span>"+ result +"</span>");
		out.write("			</form>");
		out.write("		</div>");
		out.write("	</section>");
		out.write("</body>");
		out.write("</html>");
		
		// add -> 입력폼 요청(GET)
		// add & submit -> 제출 요청(POST)
		
	}
}