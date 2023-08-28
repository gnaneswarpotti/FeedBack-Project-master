package com.ty.Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ty.Service.FacultiesService;
import com.ty.dto.Faculties;

@WebServlet(value = "/viewfaculties")
public class ViewFaculties extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		FacultiesService facultiesService = new FacultiesService();
		List<Faculties> list = facultiesService.getAllFaculties();
		if(list != null) {
			req.setAttribute("viewFaculties", list);
			RequestDispatcher requestDispatcher = req.getRequestDispatcher("Faculties.jsp");
			requestDispatcher.forward(req, resp);
		}else {
			RequestDispatcher requestDispatcher = req.getRequestDispatcher("Home.java");
			requestDispatcher.include(req, resp);
		}
	}
}
