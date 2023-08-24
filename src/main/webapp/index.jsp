<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home Page</title>

<%@ include file="allComponents/allcss.jsp"%>

</head>
<body>
	<%@ include file="allComponents/navbar.jsp"%>

	<div class="container-fluid p-0 back-img">
		<img src="images/image1.jpg" alt="WelcomeImage">

		<div class="text-center home-content">
			<h1 class="text-white">
				<i class="fa fa-book" aria-hidden="true"></i> Welcome To E-Notes.
				Save Your Notes.
			</h1>
			<a href="login.jsp" class="btn btn-light"><i
				class="fa fa-user-circle-o" aria-hidden="true"></i> Login</a> <a
				href="register.jsp" class="btn btn-light"><i
				class="fa fa-user-plus" aria-hidden="true"></i> Register</a>
		</div>
	</div>

	<%@ include file="allComponents/footer.jsp"%>
</body>
</html>