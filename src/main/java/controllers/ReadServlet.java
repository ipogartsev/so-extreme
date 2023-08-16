package controllers;

import java.io.IOException;

import helpers.ReadQuery;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/read")
public class ReadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ReadServlet() {
    
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ReadQuery rq = new ReadQuery("soextreme-project","root","");
		
		rq.dbRead();
		String table = rq.getHTMLTable();
		
		request.setAttribute("table", table);
		String url = "/read.jsp";
		
		RequestDispatcher dispatcher =  request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

}
