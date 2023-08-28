package com.ty.Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ty.Service.AdminService;
import com.ty.dto.Admin;

@WebServlet(value = "/editadmin")
public class AdminEdit extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		AdminService adminService = new AdminService();
		 Admin admin = adminService.getAdminById(Integer.parseInt(req.getParameter("id")));
		 if(admin != null) {
			 req.setAttribute("editValue", admin);
			 RequestDispatcher requestDispatcher = req.getRequestDispatcher("AdminUpdate.jsp");
			 requestDispatcher.forward(req, resp);
		 }else {
			 RequestDispatcher requestDispatcher = req.getRequestDispatcher("AdminUpdate.jsp");
			 requestDispatcher.include(req, resp);
		 }
	}
}
