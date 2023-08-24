package com.servlet;

import java.io.IOException;

import com.dao.NotesDao;
import com.database.DatabaseConnect;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/DeleteServlet")
public class DeleteServlet extends HttpServlet {
	
	//whenever we are fetching the data we must use doPost to secure it
	// but as it is a simple button I have used doGet
	protected void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		
		Integer noteId = Integer.parseInt(req.getParameter("note_id"));
		NotesDao nd = new NotesDao(DatabaseConnect.getCon());
		
		boolean dataDeleted = nd.DeleteNotes(noteId);
		HttpSession session = null;
		
		if(dataDeleted) {
			
			session = req.getSession();
			session.setAttribute("note-updated", "Notes deleted successfully...");
			res.sendRedirect("showNotes.jsp");
		}
		else {
			
			session = req.getSession();
			session.setAttribute("deletion-failed", "Failed to delete the notes...");
			res.sendRedirect("showNotes.jsp");
		}
		
	}

}
