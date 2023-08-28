package com.ty.Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ty.Service.AdminService;
import com.ty.Service.CoOrdinateService;
import com.ty.dto.Admin;
import com.ty.dto.CoOrdinate;

@WebServlet(value = "/validateCoOrdinate")
public class CoOrdinateValidate extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		CoOrdinateService coOrdinateService = new CoOrdinateService();
		List<CoOrdinate> list = coOrdinateService.validateCoOrdinate(req.getParameter("email"),req.getParameter("password"));
		if(list.size()>0) {
			System.out.println("hi");
			RequestDispatcher requestDispatcher = req.getRequestDispatcher("CoOrdinateWorksHome.jsp");
			requestDispatcher.forward(req, resp);
		}else {
			RequestDispatcher requestDispatcher = req.getRequestDispatcher("WelcomeToFeedBack.jsp");
			requestDispatcher.include(req, resp);
		}
	}
}
