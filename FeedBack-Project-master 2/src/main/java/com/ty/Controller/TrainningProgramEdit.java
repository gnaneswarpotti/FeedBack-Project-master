package com.ty.Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ty.Service.TrainningProgramsService;
import com.ty.dto.TrainningPrograms;

@WebServlet(value = "/edittrinning")
public class TrainningProgramEdit extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		TrainningProgramsService trainningProgramsService = new TrainningProgramsService();
		TrainningPrograms trainningPrograms = trainningProgramsService.getTrainningProgramsById(Integer.parseInt(req.getParameter("id")));
		if(trainningPrograms!= null) {
			req.setAttribute("editvalue", trainningPrograms);
			RequestDispatcher requestDispatcher = req.getRequestDispatcher("TrainningProgramUpdate.jsp");
			requestDispatcher.forward(req, resp);
		}
	}
}
