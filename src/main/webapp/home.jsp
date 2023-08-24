<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	
	
<%
UserDetails user2 = (UserDetails) session.getAttribute("userData");

if (user2 == null) {
	response.sendRedirect("login.jsp");
	session.setAttribute("login-error","Please login first...");
}
%>
	
	
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Take Notes</title>

<%@ include file="allComponents/allcss.jsp"%>
</head>
<body>
	<div class="container-fluid p-0">
		<%@ include file="allComponents/navbar.jsp"%>

		<div class="card py-5">
			<div class="card-body text-center">
				<img class="img-fluid mx-auto home-image" src="images/image2.png"
					alt="HomePageImage">
				<h1 class="text-info">START TAKING YOUR NOTES</h1>
				<a href="addNotes.jsp" class="btn btn-outline-primary">Let's Start</a>
			</div>
		</div>
	</div>
	<%@ include file="allComponents/footer.jsp"%>
</body>
</html>