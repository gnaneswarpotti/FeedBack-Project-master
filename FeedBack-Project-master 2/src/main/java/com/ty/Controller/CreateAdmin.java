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

@WebServlet(value = "/RegisterAdmin")
public class CreateAdmin extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 String name = req.getParameter("name");
		 String email = req.getParameter("email"); 
		 String password = req.getParameter("password");
		 long phone = Long.parseLong(req.getParameter("phone"));
		 
		 Admin admin = new Admin();
		 admin.setName(name);
		 admin.setEmail(email);
		 admin.setPassword(password);
		 admin.setPhone(phone);
		 
		 AdminService adminService = new AdminService();
		 Admin admin2 = adminService.saveAdmin(admin);
		 if(admin2 != null) {
			 RequestDispatcher requestDispatcher = req.getRequestDispatcher("Home.jsp");
			 requestDispatcher.forward(req, resp);
		 }else {
			 RequestDispatcher requestDispatcher = req.getRequestDispatcher("WelcomeToFeedBack.jsp");
			 requestDispatcher.include(req, resp);
		 }
	}
}
