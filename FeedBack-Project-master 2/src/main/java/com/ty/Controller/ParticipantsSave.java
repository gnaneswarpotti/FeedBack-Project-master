package com.ty.Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ty.Service.ParticipantsService;
import com.ty.dto.Participants;

@WebServlet(value = "/saveParticipants")
public class ParticipantsSave extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Participants participants = new Participants();
		participants.setName(req.getParameter("name"));
		participants.setEmail(req.getParameter("email"));
		participants.setPhone(Long.parseLong(req.getParameter("phone")));
		
		ParticipantsService participantsService = new ParticipantsService();
		Participants participants1 = participantsService.saveParticipants(participants);
		if(participants1 != null) {
			RequestDispatcher requestDispatcher = req.getRequestDispatcher("FeedBackCreate.jsp");
			requestDispatcher.forward(req, resp);
		}else {
			RequestDispatcher requestDispatcher = req.getRequestDispatcher("ParticipantsCreate.jsp");
			requestDispatcher.include(req, resp);
		}
	}
}
