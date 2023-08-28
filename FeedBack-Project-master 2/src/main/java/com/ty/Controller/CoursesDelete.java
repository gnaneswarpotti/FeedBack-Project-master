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

@WebServlet(value = "/deletecourses")
public class CoursesDelete extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		CoursesService coursesService = new CoursesService();
		Courses courses = coursesService.deleteCourses(Integer.parseInt(req.getParameter("id")));
		if (courses != null) {
			RequestDispatcher requestDispatcher = req.getRequestDispatcher("viewCourses");
			requestDispatcher.forward(req, resp);
		} else {
			RequestDispatcher requestDispatcher = req.getRequestDispatcher("viewCourses");
			requestDispatcher.include(req, resp);
		}
	}
}
