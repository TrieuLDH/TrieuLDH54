<%@ page language="java" contentType="text/html; charset=UTF-8"
	session="true" pageEncoding="UTF-8"%>

<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<c:if test="${ !empty sessionScope.errors }">
	<div class="alert alert-danger">${ sessionScope.errors }</div>
</c:if>
<c:if test="${ !empty sessionScope.message }">
	<div class="alert alert-danger">${ sessionScope.message }</div>
</c:if>
<meta charset="ISO-8859-1">
<title>login</title>
<link rel="stylesheet" href="/Assignment_IT16305/css/bootstrap.min.css" />
</head>
<body>
	
	<form method="post" action="/Assignment_IT16305/login">
		<div class="container">
			<div class="card mt-4">
				<div class="card-header text-center">
					<b class=" text-primary">LoginAccount</b>
				</div>
				<div class="card-body">
					<div class="row col-5 offset-4">
						<div class="form-group mt-3">
							<label class="col-2">Email:</label> <input type="email"
								name="email" />
						</div>
						<div class="form-group mt-3">
							<label class="col-2">Password:</label> <input type="password"
								name="password" />
						</div>
						<div class="mt-4 ms-4">
							<button class="btn btn-success">Login</button>
							<button class="btn btn-warning ms-3">Cancel</button>
						</div>
					</div>
				</div>
				<div class="card-footer text-muted text-center">
					TrieuLDHPH15903
				</div>
			</div>
		</div>
	</form>
	
	<script src="/Assignment_IT16305/js/jquery.min.js"></script>
	<script src="/Assignment_IT16305/js/popper.min.js"></script>
	<script src="/Assignment_IT16305/js/bootstrap.min.js"></script>
</body>
</html>