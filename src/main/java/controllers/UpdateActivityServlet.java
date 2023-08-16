package controllers;

import java.io.IOException;

import helpers.UpdateQuery;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.ExtremeActivity;


@WebServlet("/updateActivity")
public class UpdateActivityServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// Get activity from form
		Long id = Long.parseLong(request.getParameter("activityId"));
		String name = request.getParameter("name").trim();
		String description = request.getParameter("description").trim();
		String imageUrl = request.getParameter("imageUrl").trim();
		double price = parseDouble(request.getParameter("price"));
		boolean simulator = request.getParameter("simulator") != null;
		boolean accessible = request.getParameter("accessible") != null;
		
		// Set up activity
		ExtremeActivity activity = new ExtremeActivity();
		activity.setId(id);
		activity.setName(name);
		activity.setDescription(description);
		if(imageUrl != "")activity.setImageUrl(imageUrl);
		activity.setPrice(price);
		activity.setSimulator(simulator);
		activity.setDisabledAccessible(accessible); 
		
		// Query DB
		UpdateQuery uq = new UpdateQuery("soextreme-project","root","");
		uq.updateActivity(activity);
		
		// Redirect to ReadServlet
		RequestDispatcher dispatcher =  request.getRequestDispatcher("/read");
		dispatcher.forward(request, response);
		
	}
	
	private double parseDouble(String value) {
	    if (value == null || value.trim().isEmpty()) {
	        return 20.0; // return a default value
	    }
	    return Double.parseDouble(value);
	}

}
