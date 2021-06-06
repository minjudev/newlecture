package com.petharu.web.controller.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.petharu.web.entity.Member;
import com.petharu.web.service.JDBCMemberService;
import com.petharu.web.service.MemberService;

@WebServlet("/login")
public class LoginController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/login.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String userId = req.getParameter("uid");
		String passWord = req.getParameter("password");
		String returnUrl = req.getParameter("returnURL"); //get��û�ε� ����?? form���� hidden���� ${param.returnURL} �޾ƿ�.
		
		
		MemberService memberService = new JDBCMemberService();
		Member member = memberService.get(userId);
		if(member == null) {
			//ȸ���� ���� ���
			//���� �޽����� �����ְų� jsp���� �����ְ��Ѵ�.
			resp.sendRedirect("/login");
			return;
			
		}else if(!memberService.getPwd(userId).equals(passWord)) {
			resp.sendRedirect("/login");
			return;
		}else {
			
		
			//������ �����ϸ�
			//session�� ���������� ����Ѵ�.		
			HttpSession session = req.getSession();//�����̶�� ĳ��� ����
			session.setAttribute("uid", userId); //������ ����ھ��̵� ��������ҿ� ����(�˾Ƽ� ex)1004�� ĳ��� �־���)
			if(returnUrl != null && !returnUrl.equals("")) {
				resp.sendRedirect(returnUrl);
				return;
			}
		}
		resp.sendRedirect("/myhome/list.html");
	}
}
