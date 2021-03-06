package com.petharu.web.controller.myhome;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.petharu.web.entity.DiaryComment;
import com.petharu.web.service.DiaryCommentService;
import com.petharu.web.service.JDBCDiaryCommentService;

@WebServlet("/myhome/comment/delete")
public class DiaryCommentDeleteController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setCharacterEncoding("UTF-8");

		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=UTF-8");

		int id = Integer.parseInt(req.getParameter("comment-id"));
		
		DiaryCommentService diaryCommentService = new JDBCDiaryCommentService();
		
		try {
			diaryCommentService.delete(id);
		} catch(Exception e) {
			resp.sendRedirect("/myhome/exception.html");
		}
		
	}
	
}
