<%@page import="com.user.Notes"%>
<%@page import="java.util.List"%>
<%@page import="com.database.DatabaseConnect"%>
<%@page import="com.dao.NotesDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>


<%
UserDetails user4 = (UserDetails) session.getAttribute("userData");

if (user4 == null) {
	response.sendRedirect("login.jsp");
	session.setAttribute("login-error", "Please login first...");
}
%>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Show Notes</title>

<%@ include file="allComponents/allcss.jsp"%>

</head>
<body>
	<%@ include file="allComponents/navbar.jsp"%>


	<%
	String noteUpdateMsg = (String) session.getAttribute("note-updated");

	if (noteUpdateMsg != null) {
	%>
	<div class="alert alert-success" role="alert"><%= noteUpdateMsg %></div>
	<%
	session.removeAttribute("note-updated");
	}
	%>
	
	
	<%
	String noteDeletionFailedMsg = (String) session.getAttribute("deletion-failed");

	if (noteDeletionFailedMsg != null) {
	%>
	<div class="alert alert-danger" role="alert"><%= noteDeletionFailedMsg %></div>
	<%
	session.removeAttribute("deletion-failed");
	}
	%>


	<div class="container">
		<h2 class="text-center mt-1">All Notes</h2>
		<div class="row">
			<div class="col-md-12">

				<%
				if (user4 != null) {
					NotesDao nd = new NotesDao(DatabaseConnect.getCon());
					List<Notes> list_notes = nd.getData(user4.getId());

					for (Notes nt : list_notes) {
				%>

				<div class="card mt-3">

					<img src="images/image3.png"
						class="card-img-top-mt-2 mx-auto showNote-image">

					<div class="card-body p-4">
						<h5 class="card-title"><%=nt.getTitle()%></h5>
						<p><%=nt.getContent()%></p>

						<p>
							<b class="text-warning">Published by: </b> <b class="text-info"><%=user4.getName()%></b>
						</p>

						<p>
							<b class="text-warning">Published date: </b> <b class="text-info"><%=nt.getPostDate()%></b>
						</p>

						<div class="container text-center mt-2">
							<a href="DeleteServlet?note_id=<%= nt.getId() %>" class="btn btn-outline-danger">Delete</a>
							<a href="edit.jsp?note_id=<%=nt.getId()%>"
								class="btn btn-outline-primary">Edit</a>
						</div>

					</div>
				</div>
				<%
				}
				}
				%>


			</div>
		</div>
	</div>

</body>
</html>