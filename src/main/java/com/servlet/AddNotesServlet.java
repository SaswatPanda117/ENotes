package com.servlet;

import java.io.IOException;

import com.dao.NotesDao;
import com.database.DatabaseConnect;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/AddNotesServlet")
public class AddNotesServlet extends HttpServlet {

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		
		int usId = Integer.parseInt(req.getParameter("usId"));
		String title = req.getParameter("usTitle");
		String content = req.getParameter("usContent");
		
		NotesDao nd = new NotesDao(DatabaseConnect.getCon());
		boolean addNotes = nd.AddNotes(title, content, usId);
		
		if(addNotes) {
			System.out.println("Notes inserted successfully.");
			res.sendRedirect("showNotes.jsp");
		}
		else {
			System.out.println("Failed to insert the notes.");
		}
		
	}

}
