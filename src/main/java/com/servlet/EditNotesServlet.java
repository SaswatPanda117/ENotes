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

@WebServlet("/EditNotesServlet")
public class EditNotesServlet extends HttpServlet {
	protected void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		
		try {
			
			Integer noteId = Integer.parseInt(req.getParameter("noteId"));
			String Title = req.getParameter("usTitle");
			String Content = req.getParameter("usContent");
			
			NotesDao nd = new NotesDao(DatabaseConnect.getCon());
			boolean dataUpdated = nd.NotesUpdate(noteId, Title, Content);
			
			if(dataUpdated) {
				System.out.println("Data updated successfully");
				
				HttpSession session = req.getSession();
				session.setAttribute("note-updated", "Notes updated successfully...");
				res.sendRedirect("showNotes.jsp");
			}
			else {
				System.out.println("Failed to update the notes...");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
