package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import com.dao.UserDao;
import com.database.DatabaseConnect;
import com.user.UserDetails;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		//get the values from the register.jsp
		String name = req.getParameter("userName");
		String email = req.getParameter("userEmail");
		String password = req.getParameter("userPassword");
		
		//pass to the UserDetails.java class
		UserDetails us = new UserDetails();
		us.setName(name);
		us.setEmail(email);
		us.setPassword(password);
		
		//an UserDao object is created by passing a connection
		UserDao ud = new UserDao(DatabaseConnect.getCon());
		
		//us object is passed which contains name, email & password
		boolean dataStore = ud.addUser(us);
		PrintWriter pw = res.getWriter();
		HttpSession session;
		
		if(dataStore) {
			session = req.getSession();
			session.setAttribute("reg-success","Successfully registered... ");
			res.sendRedirect("register.jsp");
		}
		else {
			session = req.getSession();
			session.setAttribute("reg-failed", "Failed to register. Something went wrong on server!");
			res.sendRedirect("register.jsp");
		}
	}
}
