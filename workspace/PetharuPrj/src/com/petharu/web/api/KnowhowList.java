package com.petharu.web.api;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.petharu.web.entity.Knowhow;
import com.petharu.web.service.KnowhowService;

@WebServlet("/api/knowhow/list")
public class KnowhowList extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		
		
		try {
			
			KnowhowService knowhowService = new KnowhowService();
			List<Knowhow> list = knowhowService.getList();
			
			Gson gson = new Gson();
			
			String json = gson.toJson(list);
			
			out.println(json);
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}
}
