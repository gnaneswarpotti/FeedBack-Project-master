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

@WebServlet(value = "/updatecoordinate")
public class CoOrdinateUpdate extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		long phone = Long.parseLong(req.getParameter("phone"));
		
		CoOrdinate coOrdinate = new CoOrdinate();
		coOrdinate.setId(id);
		coOrdinate.setName(name);
		coOrdinate.setEmail(email);
		coOrdinate.setPassword(password);
		coOrdinate.setPhone(phone);
		
		CoOrdinateService coOrdinateService = new CoOrdinateService();
		CoOrdinate coOrdinate1 = coOrdinateService.updateCoOrdinate(coOrdinate);
		if(coOrdinate1 != null) {
			RequestDispatcher requestDispatcher = req.getRequestDispatcher("viewcoordinate");
			requestDispatcher.forward(req, resp);
		}else {
			RequestDispatcher requestDispatcher = req.getRequestDispatcher("viewcoordinate");
			requestDispatcher.include(req, resp);
		}
	}
}

