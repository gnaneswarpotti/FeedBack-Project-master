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

@WebServlet(value = "/updatecourse")
public class CoursesUpadte extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = (Integer.parseInt(req.getParameter("id")));
		String name = req.getParameter("name");
		double fees = Double.parseDouble(req.getParameter("fees"));
		String duration = req.getParameter("duration");
		
		Courses courses = new Courses();
		courses.setId(id);
		courses.setCourseName(name);
		courses.setFees(fees);
		courses.setDuration(duration);
		
		CoursesService coursesService = new CoursesService();
		Courses courses1 = coursesService.updateCourses(courses);
		if(courses1 != null) {
			RequestDispatcher dispatcher = req.getRequestDispatcher("viewCourses");
			dispatcher.forward(req, resp);
		}else {
			RequestDispatcher dispatcher = req.getRequestDispatcher("viewCourses");
			dispatcher.include(req, resp);
		}
		
	}
}
