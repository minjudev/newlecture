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
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setCharacterEncoding("UTF-8"); /*UTF-8�� ���ڵ��ؼ� ������ ������ ��*/
		resp.setContentType("text/html;charset-UTF-8"); /*�������� �д� ���*/ /*���� ����� �� ������ UTF-8�̶�� ���� �˷��ִ� ��*/
		
		int x = 0;
		int y = 0;
		int result = 0;
		String str_x = null;
		String str_y = null;
		String str_r = req.getParameter("r");
		
		if(str_r != null)
			result = Integer.parseInt(str_r); 
		
		// ������ �������� ����� �ڵ�
		// �� �ڵ�� ������� �����: ������ ����(���� ����)
		PrintWriter out = resp.getWriter();		
		
		// ����ڿ��� ������ �� �� �ִ� UI�� �ٽ� �����ֱ�
		// Jasper: JSP�� �������� ��ȯ����
		// JSP�� ����� �Ʒ� ������ �ܼ��ϰ� �� �� ����
		out.write("<!DOCTYPE html>");
		out.write("<html>");
		out.write("<head>");
		out.write("<meta charset=\"UTF-8\">"); /*���������� �� ������ UTF�� ��������ٰ� �˷��ִ� ��, �������� ������ ���� �� UTF-8�� ����*/
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
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
				
		int x = 0;
		int y = 0;
		int result = 0;
		String str_x = null;
		String str_y = null;
		
//		if(req.getMethod().equals("POST")) {
		System.out.println("calc");
		
		str_x = req.getParameter("x"); /*str_x���� ["����"]�� �;���*/
		if(str_x != null && !str_x.equals("")) /*�⺻�� Ȱ���ϱ�*/ /*��ü�� �ƴ� ���� ���ϵ��� .equals() ���*/
			x = Integer.parseInt(str_x);
		
		str_y = req.getParameter("y");
		if(str_y != null && !str_y.equals("")) 
			y = Integer.parseInt(str_y);
		
		result = x + y;
		
		// get ��û�� �ϸ鼭 get�� ó���ϴ� �������� ���� ���� �� �Ǵ� ���¸� ������ �� �ִ� ��� �ʿ�
		// 1. ������ �̿�
		// 2. ������ �����(Application/Session/Request/Cookie/...)�� �̿�
		// 3. QueryString�� �̿�
		
		// ���¸� ������ ä �����͸� ������ ����� �ʿ�
		// POST�� ����� ������ GET ��û�ϱ� -> ���� �帧�� ���� ����
		// POST ��û���� ������ ���Ӱ� GET ��û�� �ϰ� ���� �� ���
		// 3���� �̿��ؼ� url�� ���� �� �����Ͱ��� �Բ� ������.
		resp.sendRedirect("/add?r="+result);
		
//		}	
	}
	
	// service�� main �Լ��� �����
//	@Override
//	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		
//		resp.setCharacterEncoding("UTF-8"); /*UTF-8�� ���ڵ��ؼ� ������ ������ ��*/
//		resp.setContentType("text/html;charset-UTF-8"); /*�������� �д� ���*/ /*���� ����� �� ������ UTF-8�̶�� ���� �˷��ִ� ��*/
//		
//		int x = 0;
//		int y = 0;
//		int result = 0;
//		String str_x = null;
//		String str_y = null;
//		
//		// ����ڰ� ������ ���� ������ �۾��� ��ȯ�ϴ� �۾��� post ��û�� ���� ���� ����ǰ� �ϱ�
//		if(req.getMethod().equals("POST")) {
//			System.out.println("calc");
//			
//			str_x = req.getParameter("x"); /*str_x���� ["����"]�� �;���*/
//			if(str_x != null && !str_x.equals("")) /*�⺻�� Ȱ���ϱ�*/ /*��ü�� �ƴ� ���� ���ϵ��� .equals() ���*/
//				x = Integer.parseInt(str_x);
//			
//			str_y = req.getParameter("y");
//			if(str_y != null && !str_y.equals("")) 
//				y = Integer.parseInt(str_y);
//			
//			result = x + y;
//		}
//		
//		// 1. ����� ����� �� �ֵ��� ���� UI ����ϱ�
//		// 2. �ѱ� ���� ���� �ذ��ϱ�
//		// 3. ���⿡�� ����� ��� �� �ܿ� ����ߴ� ����ĵ� �Բ� �����ֱ�
//		// 4. POST ��û�� �⺻ ��
//		// 5. GET ��û�� POST ��û�� ���ؿ� �ڵ� �и��ϱ�
//		
//		// ������ �������� ����� �ڵ�
//		// �� �ڵ�� ������� �����: ������ ����(���� ����)
//		PrintWriter out = resp.getWriter();		
//		
//		// ����ڿ��� ������ �� �� �ִ� UI�� �ٽ� �����ֱ�
//		out.write("<!DOCTYPE html>");
//		out.write("<html>");
//		out.write("<head>");
////		out.write("<meta charset=\"UTF-8\">"); /*���������� �� ������ UTF�� ��������ٰ� �˷��ִ� ��, �������� ������ ���� �� UTF-8�� ����*/
//		out.write("<title>Insert title here</title>");
//		out.write("</head>");
//		out.write("<body>");
//		out.write("	<section>");
//		out.write("		<h1>����</h1>");
//		
//		if(str_x != null && str_y != null)
//			out.write("		<div>"+x+"+"+y+"=</div>");
//		
//		out.write("		<div>");
//		out.write("			<form action=\"/add\" method=\"post\">"); /*�� ���� ����� post�̹Ƿ� post �޼ҵ带 �������*/ /*get: �⺻ ��û*/
//		out.write("				<input type=\"text\" name=\"x\">+<input type=\"text\" name=\"y\"><br>");
//		out.write("				<input type=\"submit\" value=\"����\"><span>"+ result +"</span>");
//		out.write("			</form>");
//		out.write("		</div>");
//		out.write("	</section>");
//		out.write("</body>");
//		out.write("</html>");
//		
//		// add -> �Է��� ��û(GET)
//		// add & submit -> ���� ��û(POST)
//		
//		super.service(req, resp);
//		
//	}
}