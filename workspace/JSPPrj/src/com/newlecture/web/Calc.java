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

		resp.setCharacterEncoding("UTF-8"); /*UTF-8�� ���ڵ��ؼ� ������ ������ ��*/
		resp.setContentType("text/html;charset-UTF-8"); /*�������� �д� ���*/ /*���� ����� �� ������ UTF-8�̶�� ���� �˷��ִ� ��*/
		
		int x = 0;
		int y = 0;
		
		String str_x = req.getParameter("x"); /*str_x���� ["����"]�� �;���*/
		if(str_x != null && !str_x.equals("")) /*�⺻�� Ȱ���ϱ�*/ /*��ü�� �ƴ� ���� ���ϵ��� .equals() ���*/
			x = Integer.parseInt(str_x);
		
		String str_y = req.getParameter("y");
		if(str_y != null && !str_y.equals("")) 
			y = Integer.parseInt(str_y);
		
		int result = x + y;
		
		// 1. ����� ����� �� �ֵ��� ���� UI ����ϱ�
		// 2. �ѱ� ���� ���� �ذ��ϱ�
		// 3. ���⿡�� ����� ��� �� �ܿ� ����ߴ� ����ĵ� �Բ� �����ֱ�
		// 4. POST ��û�� �⺻ ��
		// 5. GET ��û�� POST ��û�� ���ؿ� �ڵ� �и��ϱ�
		
		// ������ �������� ����� �ڵ�
		// �� �ڵ�� ������� �����: ������ ����(���� ����)
		PrintWriter out = resp.getWriter();		
		
		// ����ڿ��� ������ �� �� �ִ� UI�� �ٽ� �����ֱ�
		out.write("<!DOCTYPE html>");
		out.write("<html>");
		out.write("<head>");
//		out.write("<meta charset=\"UTF-8\">"); /*���������� �� ������ UTF�� ��������ٰ� �˷��ִ� ��, �������� ������ ���� �� UTF-8�� ����*/
		out.write("<title>Insert title here</title>");
		out.write("</head>");
		out.write("<body>");
		out.write("	<section>");
		out.write("		<h1>����</h1>");
		
		if(str_x != null && str_y != null)
			out.write("		<div>"+x+"+"+y+"=</div>");
		
		out.write("		<div>");
		out.write("			<form action=\"/add\" method=\"post\">"); /*�� ���� ����� post�̹Ƿ� post �޼ҵ带 �������*/ /*get: �⺻ ��û*/
		out.write("				<input type=\"text\" name=\"x\">+<input type=\"text\" name=\"y\"><br>");
		out.write("				<input type=\"submit\" value=\"����\"><span>"+ result +"</span>");
		out.write("			</form>");
		out.write("		</div>");
		out.write("	</section>");
		out.write("</body>");
		out.write("</html>");
		
		// add -> �Է��� ��û(GET)
		// add & submit -> ���� ��û(POST)
		
	}
}