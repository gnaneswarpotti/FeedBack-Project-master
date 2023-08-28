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
import com.ty.Service.FacultiesService;
import com.ty.Service.FeedBackService;
import com.ty.dto.Courses;
import com.ty.dto.Faculties;
import com.ty.dto.FeedBack;

@WebServlet(value = "/createfeedback")
public class FeedBackCrerate extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String particepatename = req.getParameter("pname");
		String facultyname = req.getParameter("fname");
		String Coursesname = req.getParameter("cname");
		String ratting = req.getParameter("ratting");
		String description = req.getParameter("description");
		
		
		FeedBack  feedBack = new FeedBack();
		CoursesService coursesService = new CoursesService();
		List<Courses> courses = coursesService.getAllCourses();
		for (Courses courses2 : courses) {
			if (courses2.getCourseName().equalsIgnoreCase(feedBack.getCourseName())) {
				feedBack.setCourseName(courses2.getCourseName());
			} else {
				RequestDispatcher requestDispatcher = req.getRequestDispatcher("FeedBackCreate.jsp");
				requestDispatcher.forward(req, resp);
			}
		}
		FacultiesService facultiesService = new FacultiesService();
		List<Faculties> faculties = facultiesService.getAllFaculties();
		for (Faculties faculties2 : faculties) {
			if (faculties2.getName().equalsIgnoreCase(feedBack.getFacultyName())) {
				feedBack.setFacultyName(faculties2.getName());
			} else {
				RequestDispatcher requestDispatcher = req.getRequestDispatcher("FeedBackCreate.jsp");
				requestDispatcher.forward(req, resp);
			}
		}
		feedBack.setParticepateName(particepatename);
		feedBack.setRatings(ratting);
		feedBack.setDescription(description);
		
		FeedBackService feedBackService = new FeedBackService();
		FeedBack feedBack2 = feedBackService.createFeedBack(feedBack);
		if(feedBack2 != null) {
			RequestDispatcher requestDispatcher = req.getRequestDispatcher("viewfeedback");
			requestDispatcher.forward(req, resp);
		}else {
			RequestDispatcher requestDispatcher = req.getRequestDispatcher("FeedBackCreate.jsp");
			requestDispatcher.include(req, resp);
		}
	}
}
