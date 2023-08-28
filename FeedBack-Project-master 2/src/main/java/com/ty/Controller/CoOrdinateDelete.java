package com.ty.Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ty.Service.CoOrdinateService;
import com.ty.dto.CoOrdinate;

@WebServlet(value = "/deletecoordinate")
public class CoOrdinateDelete extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		CoOrdinateService coOrdinateService = new CoOrdinateService();
		CoOrdinate coOrdinate = coOrdinateService.deleteCoOrdinate(Integer.parseInt(req.getParameter("id")));
		if(coOrdinate != null) {
			RequestDispatcher requestDispatcher = req.getRequestDispatcher("viewcoordinate");
			requestDispatcher.forward(req, resp);
		}else {
			RequestDispatcher requestDispatcher = req.getRequestDispatcher("viewcoordinate");
			requestDispatcher.include(req, resp);
		}
	}
}
