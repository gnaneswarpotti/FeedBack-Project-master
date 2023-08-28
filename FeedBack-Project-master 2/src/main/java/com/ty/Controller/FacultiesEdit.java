package com.ty.Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ty.Service.FacultiesService;
import com.ty.dto.Faculties;

@WebServlet(value = "/editfacultie")
public class FacultiesEdit extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		FacultiesService facultiesService = new FacultiesService();
		Faculties faculties = facultiesService.getFacultiesById(Integer.parseInt(req.getParameter("id")));
		if(faculties != null) {
			req.setAttribute("editvalue", faculties);
			RequestDispatcher requestDispatcher = req.getRequestDispatcher("FacultiesUpdate.jsp");
			requestDispatcher.forward(req, resp);
		}
	}
}
