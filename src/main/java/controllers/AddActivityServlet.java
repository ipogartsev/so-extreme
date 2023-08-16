package controllers;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import helpers.AddQuery;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import model.ExtremeActivity;


@WebServlet( "/addActivity")
@MultipartConfig(
//	    
	    maxFileSize = 10485760L,    // 10 MB
	    maxRequestSize = 52428800L, // 50 MB
	    fileSizeThreshold = 1048576 // 1 MB
	)
public class AddActivityServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Get value from form
		String name = request.getParameter("name");
		String description = request.getParameter("description");
		double price = Double.parseDouble(request.getParameter("price"));
		boolean simulator = request.getParameter("simulator") != null;
		boolean accessible = request.getParameter("accessible") != null;
		
		Part filePart = request.getPart("imageFile");
	    String fileName = getFileName(filePart);
	    String imageUrl = fileName ;
	    
	    OutputStream out = null;
	    InputStream filecontent = null;
	    
	    try {
	    	String path = "C:\\Users\\pogar\\CODE PROJECTS\\JAVA projects";
	        out = new FileOutputStream(new File(path + File.separator
	                + fileName));
	        filecontent = filePart.getInputStream();

	        int read = 0;
	        final byte[] bytes = new byte[1024];

	        while ((read = filecontent.read(bytes)) != -1) {
	            out.write(bytes, 0, read);
	        }
	        
	    } catch (FileNotFoundException fne) {
	        
	    } finally {
	        if (out != null) {
	            out.close();
	        }
	        if (filecontent != null) {
	            filecontent.close();
	        }
	        
	    }
		
		
		// Set up activity
		ExtremeActivity activity = new ExtremeActivity();
				
		activity.setName(name);
		activity.setDescription(description);
		activity.setImageUrl(imageUrl);
		
		activity.setPrice(price);
		activity.setSimulator(simulator);
		activity.setDisabledAccessible(accessible); 
		
		// Query DB
		AddQuery aq = new AddQuery("soextreme-project","root","");
		aq.dbAdd(activity);
		
		// Redirect to ReadServlet
		RequestDispatcher dispatcher =  request.getRequestDispatcher("/read");
		dispatcher.forward(request, response);	
	}
	
	private String getFileName(Part part) {
        for (String content : part.getHeader("content-disposition").split(";")) {
            if (content.trim().startsWith("filename")) {
                String filenameWithQuotes = content.substring(content.indexOf('=') + 1).trim();
                return filenameWithQuotes.substring(filenameWithQuotes.lastIndexOf('\\') + 1).replace("\"", "");
            }
        }
        return null;
    }
}
