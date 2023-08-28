package com.ty.Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ty.Service.FeedBackService;
import com.ty.dto.FeedBack;

@WebServlet(value = "/viewfeedback")
public class FeedBackView extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		FeedBackService feedBackService = new FeedBackService();
		List<FeedBack> list = feedBackService.getAllFeedBack();
		if(list.size()>0) {
			req.setAttribute("view", list);
			RequestDispatcher dispatcher = req.getRequestDispatcher("FeedBackView.jsp");
			dispatcher.forward(req, resp);
		}else {
			RequestDispatcher dispatcher = req.getRequestDispatcher("FeedBackView.jsp");
			dispatcher.include(req, resp);
		}
	}
}
