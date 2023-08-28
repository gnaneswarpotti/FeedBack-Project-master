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
import com.ty.dto.Admin;

@WebServlet(value = "/viewAdmin")
public class AdminView extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		AdminService adminService = new AdminService();
		List<Admin> list = adminService.getAllAdmin();
		if(list.size()>0) {
			req.setAttribute("view", list);
			RequestDispatcher dispatcher = req.getRequestDispatcher("AdminView.jsp");
			dispatcher.forward(req, resp);
		}else {
			RequestDispatcher dispatcher = req.getRequestDispatcher("AdminView.jsp");
			dispatcher.include(req, resp);
		}
	}
}
