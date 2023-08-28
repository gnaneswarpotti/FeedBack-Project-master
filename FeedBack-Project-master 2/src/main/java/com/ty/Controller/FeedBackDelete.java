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

@WebServlet(value="/deletefeedback")
public class FeedBackDelete extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		FeedBackService feedBackService=new FeedBackService();
		int id=Integer.valueOf((String)req.getParameter("id"));
		FeedBack feedBack=feedBackService.deleteCoursesById(id);
		if(feedBack != null) {
			RequestDispatcher requestDispatcher=req.getRequestDispatcher("viewfeedback");
			requestDispatcher.forward(req, resp);
		}else {
			RequestDispatcher requestDispatcher=req.getRequestDispatcher("viewfeedback");
			requestDispatcher.include(req, resp);
		}
	}
}
