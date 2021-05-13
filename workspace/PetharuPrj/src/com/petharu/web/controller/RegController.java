package com.petharu.web.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.petharu.web.entity.Knowhow;
import com.petharu.web.service.KnowhowService;

@WebServlet("/knowhow/reg")
public class RegController extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String pet = req.getParameter("pet");
		String title = req.getParameter("title");
		String content = req.getParameter("content");

		KnowhowService knowhowService = new KnowhowService();
		
		try {
			
			Knowhow knowhow = new Knowhow();
			knowhow.setUserId("minju");
			knowhow.setPet(pet);
			knowhow.setTitle(title);
			knowhow.setContent(content);
			knowhow.setHit(26);
			knowhow.setLike(7);
			knowhowService.insert(knowhow);
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		resp.sendRedirect("list.jsp");
	};
	
}
