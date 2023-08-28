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

@WebServlet(value = "/saveTrainninPrograms")
public class TrainningProgramsSave extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name");
		String facultyname = req.getParameter("fname");
		LocalDate startingdate = LocalDate.parse(req.getParameter("sdate"));
		LocalDate edingdate = LocalDate.parse(req.getParameter("edate"));
		
		TrainningPrograms trainningPrograms = new TrainningPrograms();
		trainningPrograms.setName(name);
		trainningPrograms.setFacultiesNames(facultyname);
		trainningPrograms.setStartingDate(startingdate);
		trainningPrograms.setEndingDate(edingdate);
				
		TrainningProgramsService trainningProgramsService = new TrainningProgramsService();
		TrainningPrograms trainningPrograms1 = trainningProgramsService.createTrainningPrograms(trainningPrograms);
		if(trainningPrograms1 != null) {
			RequestDispatcher requestDispatcher = req.getRequestDispatcher("");
			requestDispatcher.forward(req, resp);
		}
	}
}
