<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>


<%
UserDetails user3 = (UserDetails) session.getAttribute("userData");

if (user3 == null) {
	response.sendRedirect("login.jsp");
	session.setAttribute("login-error","Please login first...");
}
%>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Notes</title>

<%@ include file="allComponents/allcss.jsp"%>
</head>
<body>
	<div class="container-fluid p-0">
		<%@ include file="allComponents/navbar.jsp"%>
		<h1 class="text-center pt-3 pb-3">Add your Notes</h1>

		<div class="container">
			<div class="row">
				<div class="col-md-12">

					<form action="AddNotesServlet" method="post">
						<div class="form-group">

							<%
							UserDetails us = (UserDetails) session.getAttribute("userData");

							if (us != null) {
							%>
							<input type="hidden" value="<%=us.getId()%>" name="usId">
							<%
							}
							%>

							<label for="InputTitle">Enter the title</label> <input
								type="text" class="form-control" id="InputTitle"
								aria-describedby="titleHelp" placeholder="Heading"
								name="usTitle" required>
						</div>
						<div class="form-group">
							<label for="InputDescription">Enter the content</label>
							<textarea class="form-control" id="InputDescription" rows="9"
								placeholder="Description" name="usContent" required></textarea>
						</div>
						<div class="text-center pt-2">
							<button type="submit" class="btn btn-outline-primary">Add
								Notes</button>
						</div>
					</form>

				</div>
			</div>
		</div>
	</div>
	<%@ include file="allComponents/footer.jsp"%>
</body>
</html>