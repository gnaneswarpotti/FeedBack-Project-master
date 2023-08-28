package com.ty.Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ty.Service.FeedBackService;
import com.ty.dto.FeedBack;



@WebServlet(value="/updatefeedback")
public class FeedBackUpdate extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id=Integer.parseInt(req.getParameter("id"));
		String pname = req.getParameter("pname");
		String facultyname = req.getParameter("fname");
		String Coursesname = req.getParameter("cname");
		String description=req.getParameter("description");
		String ratings=req.getParameter("ratting");
		
		FeedBack feedBack= new FeedBack();
		feedBack.setId(id);
		feedBack.setParticepateName(pname);
		feedBack.setDescription(description);
		feedBack.setRatings(ratings);
		
		FeedBackService feedBackService=new FeedBackService();
		FeedBack feedBack1=feedBackService.updateCourses(feedBack);
		
		if(feedBack1 != null) {
			RequestDispatcher requestDispatcher=req.getRequestDispatcher("viewfeedback");
			requestDispatcher.forward(req, resp);
		}else {
			RequestDispatcher requestDispatcher=req.getRequestDispatcher("viewfeedback");
			requestDispatcher.include(req, resp);
		}
	}
}
