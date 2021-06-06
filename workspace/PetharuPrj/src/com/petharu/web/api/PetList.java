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
import com.petharu.web.entity.Pet;
import com.petharu.web.service.JdbcPetService;
import com.petharu.web.service.PetService;

//@WebServlet("/api/pet-management/mypet/list")
public class PetList extends HttpServlet {
	// ���
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		request.setCharacterEncoding("UTF-8");

		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");

		int id_ = 1;
		if (request.getParameter("id") != null) {
			id_ = Integer.parseInt(request.getParameter("id"));
		}
//			String name = req.getParameter("name");
//			System.out.println(name);
//			String breed = req.getParameter("breed");			
		System.out.println(id_);

		JdbcPetService petService = new JdbcPetService();
		List<Pet> list = petService.getPetList(id_);

		Gson gson = new Gson();
		String json = gson.toJson(list);
		System.out.println(json.toString());

		out.println(json);

		System.out.println(list);
		request.setAttribute("list", list);

		request.getRequestDispatcher("list.jsp").forward(request, response);

	}

}
