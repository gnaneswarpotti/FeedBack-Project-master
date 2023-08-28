package com.ty.Controller;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ty.Service.TrainningProgramsService;
import com.ty.dto.TrainningPrograms;

@WebServlet(value = "/updatetrinning")
public class TrainningProgramUpdate extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id=Integer.parseInt(req.getParameter("id"));
		String name=req.getParameter("name");
		LocalDate startingDate=LocalDate.parse(req.getParameter("startingDate"));
		LocalDate endingDate=LocalDate.parse(req.getParameter("endingDate"));
		String facultyName=req.getParameter("facultyName");
		
		TrainningPrograms trainingPrograms=new TrainningPrograms();
		trainingPrograms.setId(id);
		trainingPrograms.setName(name);
		trainingPrograms.setStartingDate(startingDate);
		trainingPrograms.setEndingDate(endingDate);;
		trainingPrograms.setFacultiesNames(facultyName);
		
		TrainningProgramsService trainingProgramService=new TrainningProgramsService();
		TrainningPrograms tPrograms=trainingProgramService.updateTrainningPrograms(trainingPrograms);
		if(tPrograms!= null) {
			RequestDispatcher requestDispatcher=req.getRequestDispatcher("viewTrainningProgram");
			requestDispatcher.forward(req, resp);
		}else {
			RequestDispatcher requestDispatcher=req.getRequestDispatcher("viewTrainningProgram");
			requestDispatcher.include(req, resp);
		}
	}
}
