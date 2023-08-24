<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration Page</title>

<%@ include file="allComponents/allcss.jsp"%>
</head>
<body>

	<div class="main-register">

		<%@ include file="allComponents/navbar.jsp"%>

		<div class="container-fluid register-div">
			<div class="row">

				<div class="col-md-4 offset-md-4">
					<div class="card mt-5">

						<div class="card-header text-center text-white bg-custom">
							<i class="fa fa-user-plus fa-3x" aria-hidden="true"></i>
							<h4>Register Here</h4>
						</div>

						
						<!-- ALERT MESSAGE -->
						<%
						String regSuccessMsg = (String) session.getAttribute("reg-success");
						if (regSuccessMsg != null) {
							%>
							<div class="alert alert-success" role="alert">
								<%= regSuccessMsg %> To go to login page <a href="login.jsp">Click here</a>
							</div>
							<%
							session.removeAttribute("reg-success");
						}
						%>
						
						<%
						String regFailedMsg = (String) session.getAttribute("reg-failed");
						if (regFailedMsg != null) {
							%>
							<div class="alert alert-danger" role="alert">
								<%= regFailedMsg %>
							</div>
							<%
							session.removeAttribute("reg-failed");
						}
						%>


						<div class="card-body">
							<form action="UserServlet" method="post">

								<div class="form-group">
									<label for="InputName">Enter your name</label> <input
										type="text" class="form-control" id="InputName"
										aria-describedby="nameHelp" name="userName" required>
								</div>

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
									class="btn btn-primary badge-pill btn-block">Register</button>

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