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


@WebServlet(value = "/edit")
public class FeedBackEdit extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		FeedBackService feedBackService=new FeedBackService();
		FeedBack feedBack=feedBackService.getFeedBackById(Integer.parseInt(req.getParameter("id")));
		if(feedBack!= null) {
			req.setAttribute("editsValue", feedBack);
			RequestDispatcher requestDispatcher = req.getRequestDispatcher("FeedBackUpdate.jsp");
			requestDispatcher.forward(req, resp);
		}
	}
}
