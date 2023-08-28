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

@WebServlet(value = "/createFaculties")
public class CreateFaculties extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		long phone = Long.parseLong(req.getParameter("phone"));
		String password = req.getParameter("password");
		double salary = Double.parseDouble(req.getParameter("salary"));
		String skills = req.getParameter("skills");
		
		Faculties faculties = new Faculties();
		faculties.setName(name);
		faculties.setEmail(email);
		faculties.setPhone(phone);
		faculties.setPassword(password);
		faculties.setSalary(salary);
		faculties.setSkills(skills);
		
		FacultiesService facultiesService = new FacultiesService();
		Faculties faculties1 = facultiesService.saveFaculties(faculties);
		if(faculties1 != null) {
			RequestDispatcher requestDispatcher = req.getRequestDispatcher("viewfaculties");
			requestDispatcher.forward(req, resp);
		}else {
			RequestDispatcher requestDispatcher = req.getRequestDispatcher("CreateFaculties.jsp");
			requestDispatcher.forward(req, resp);
		}
	}
}
