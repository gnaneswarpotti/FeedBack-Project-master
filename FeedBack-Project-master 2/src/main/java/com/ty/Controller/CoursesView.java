package com.ty.Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ty.Service.CoursesService;
import com.ty.dto.Courses;

@WebServlet(value = "/viewCourses")
public class CoursesView extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		CoursesService coursesService = new CoursesService();
		List<Courses> list = coursesService.getAllCourses();
		if(list.size()>0) {
			req.setAttribute("view", list);
			RequestDispatcher requestDispatcher = req.getRequestDispatcher("CoursesView.jsp");
			requestDispatcher.forward(req, resp);
		}else {
			RequestDispatcher requestDispatcher = req.getRequestDispatcher("CoursesView.jsp");
			requestDispatcher.include(req, resp);
		}
	}
}
