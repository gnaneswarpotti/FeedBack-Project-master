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

@WebServlet(value = "/deletetrainning")
public class TrainingProgramDelete extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		TrainningProgramsService trainingProgramService=new TrainningProgramsService();
		int id=Integer.valueOf((String)req.getParameter("id"));
		TrainningPrograms trainingPrograms=trainingProgramService.deleteTrainningPrograms(id);
		if(trainingPrograms!= null) {
			RequestDispatcher requestDispatcher=req.getRequestDispatcher("viewTrainningProgram");
			requestDispatcher.forward(req, resp);
		}else {
			RequestDispatcher requestDispatcher=req.getRequestDispatcher("viewTrainningProgram");
			requestDispatcher.include(req, resp);
		}
	}
}
