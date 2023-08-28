package com.ty.Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ty.Service.CoOrdinateService;
import com.ty.dto.CoOrdinate;

@WebServlet(value = "/viewcoordinate")
public class CoOrdinateView extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		CoOrdinateService coOrdinateService = new CoOrdinateService();
		List<CoOrdinate> list = coOrdinateService.getAllCoOrdinate();
		if(list != null) {
			req.setAttribute("view", list);
			RequestDispatcher requestDispatcher = req.getRequestDispatcher("CoOrdinateView.jsp");
			requestDispatcher.forward(req, resp);
		}else {
			RequestDispatcher requestDispatcher = req.getRequestDispatcher("CoOrdinateView.jsp");
			requestDispatcher.include(req, resp);
		}
	}
}
