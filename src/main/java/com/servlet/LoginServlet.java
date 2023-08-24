package com.servlet;

import java.io.IOException;

import com.dao.UserDao;
import com.database.DatabaseConnect;
import com.user.UserDetails;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		String email = req.getParameter("userEmail");
		String password = req.getParameter("userPassword");

		UserDetails us = new UserDetails();
		us.setEmail(email);
		us.setPassword(password);

		UserDao ud = new UserDao(DatabaseConnect.getCon());
		UserDetails user = ud.loginUser(us);
		
		if(user != null) {
			
			//retrieve the full user data and store it in the session
			HttpSession session = req.getSession();
			session.setAttribute("userData", user);
			
			session.setAttribute("id", user.getId());
			res.sendRedirect("home.jsp");
		}
		
		// if there is no user i.e. user data
		else {
			HttpSession session = req.getSession();
			session.setAttribute("login-failed", "Invalid input. Please try again.");
			res.sendRedirect("login.jsp");
		}
	}

}
