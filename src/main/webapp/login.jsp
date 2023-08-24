<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>

<head>
<meta charset="ISO-8859-1">
<title>Login Page</title>

<%@ include file = "allComponents/allcss.jsp" %>
</head>

<body>

	<div class="main-login">

		<%@ include file="allComponents/navbar.jsp"%>
r
		<div class="container-fluid register-div">
			<div class="row">

				<div class="col-md-4 offset-md-4">
					<div class="card mt-5">

						<div class="card-header text-center text-white bg-custom">
							<i class="fa fa-user-plus fa-3x" aria-hidden="true"></i>
							<h4>Login here</h4>
						</div>
						
						
						<%
						String loginFailedMsg = (String) session.getAttribute("login-failed");
						if (loginFailedMsg != null) {
							%>
							<div class="alert alert-danger" role="alert">
								<%= loginFailedMsg %>
							</div>
							<%
							session.removeAttribute("login-failed");
						}
						%>
						
						<%
						String withoutLogin = (String) session.getAttribute("login-error");
						if (withoutLogin != null) {
							%>
							<div class="alert alert-danger" role="alert">
								<%= withoutLogin %>
							</div>
							<%
							session.removeAttribute("login-error");
						}
						%>
						
						<%
						String logoutMessage = (String) session.getAttribute("logout-message");
						if (logoutMessage != null) {
							%>
							<div class="alert alert-success" role="alert">
								<%= logoutMessage %>
							</div>
							<%
							session.removeAttribute("logout-message");
						}
						%>
						

						<div class="card-body">
							<form action="LoginServlet" method="post">
								<div class="form-group">
									<label for="InputEmail">Enter your email</label> <input
										type="email" class="form-control" id="InputEmail"
										aria-describedby="emailHelp" name="userEmail" required>
								</div>

								<div class="form-group">
									<label for="InputPassword">Password</label> <input
										type="password" class="form-control" id="InputPassword"
										name="userPassword" required>
								</div>

								<button type="submit"
									class="btn btn-primary badge-pill btn-block">Login</button>
							</form>
						</div>

					</div>
				</div>

			</div>
		</div>

		<%@ include file="allComponents/footer.jsp"%>

	</div>
</body>
</html>