package com.newlecture.web;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class Nana extends HttpServlet {
	public void service(HttpServletRequest request /*����ڰ� ������ �Է°��� ����� �� �ִ� ����*/, 
			HttpServletResponse response /*����ڿ��� ������ ������ ��Ƴ��� ����*/) 
			throws IOException, ServletException {
		
		int count = 10;
		
		// ����ڰ� �����ϴ� �� �̿��ϱ�
		String c = request.getParameter("c");
		
		
//		�ֿܼ� ������ �ʰ� �� ������ ����ڿ��� ������� �������
//		���ڿ� ��� - PrintWriter �̿�
		PrintWriter out = response.getWriter();
		out.println("[2,3,4,5]");
		
		
//		if(c != null)
//			count = Integer.parseInt(c);
//		
//		for(int i=0; i<count; i++)
//			out.println("Hello Servlet!");
			
		// ������ ��� -> Browser : ������ �鿣�忡�� ����
		// �����͸� ��� -> JavaScript : ������ ����Ʈ���忡�� ����
		// js�� ������ ��û -> ���� �����ִ� �������� ������ �ȾƳ���
		
		
	}

}