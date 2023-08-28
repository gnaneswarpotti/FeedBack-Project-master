package com.ty.Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ty.Service.CoursesService;
import com.ty.dto.Courses;

@WebServlet(value = "/editcourses")
public class CoursesEdit extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		CoursesService coursesService = new CoursesService();
		Courses courses = coursesService.getCourseById(Integer.parseInt(req.getParameter("id")));
		if(courses != null) {
			req.setAttribute("editvalue", courses);
			RequestDispatcher requestDispatcher = req.getRequestDispatcher("CoursesUpdate.jsp");
			requestDispatcher.forward(req, resp);
		}
	}
}
