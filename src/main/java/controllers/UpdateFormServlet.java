package controllers;

import java.io.IOException;

import helpers.ReadRecord;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.ExtremeActivity;


@WebServlet("/update")
public class UpdateFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Get id from request
		Long activityId = Long.parseLong(request.getParameter("activityId"));
		
		// Query DB
		ReadRecord readRecord = new ReadRecord("soextreme-project", "root", "", activityId);
		readRecord.dbRead();
		
		// Set activity
		ExtremeActivity activity = readRecord.getActivity();
		System.out.println(activity);
		
		// Sent activity to page
		request.setAttribute("activity", activity);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/updateForm.jsp");
		dispatcher.forward(request, response);
			
	}

}
