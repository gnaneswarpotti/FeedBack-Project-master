package com.ty.Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ty.Service.TrainningProgramsService;
import com.ty.dto.TrainningPrograms;

@WebServlet(value = "/viewTrainningProgram")
public class TrainningProgramView extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		TrainningProgramsService trainningProgramsService = new TrainningProgramsService();
		List<TrainningPrograms> list = trainningProgramsService.getAllTrainningPrograms();
		if(list.size()>0) {
			req.setAttribute("view", list);
			RequestDispatcher requestDispatcher = req.getRequestDispatcher("TrinningProgramView.jsp");
			requestDispatcher.forward(req, resp);
		}else {
			RequestDispatcher requestDispatcher = req.getRequestDispatcher("TrainnigProgramView.jsp");
			requestDispatcher.include(req, resp);
		}
	}
}
