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

@WebServlet(value = "/validateAdmin")
public class AdminValidate extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		AdminService adminService = new AdminService();
		List<Admin> admin = adminService.validateAdmin(req.getParameter("email"),req.getParameter("password"));
		if(admin.size()>0) {
			RequestDispatcher requestDispatcher = req.getRequestDispatcher("Home.jsp");
			requestDispatcher.forward(req, resp);
		}else {
			RequestDispatcher requestDispatcher = req.getRequestDispatcher("AdminLogin.jsp");
			requestDispatcher.include(req, resp);
		}
	}
}
