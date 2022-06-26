<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib uri="http://www.springframework.org/tags/form"
	prefix="form" %>
	<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<c:if test="${ !empty sessionScope.errors }">
	<div class="alert alert-danger">${ sessionScope.errors }</div>
	<c:remove var="error" scope="session"></c:remove>
</c:if>
<meta charset="UTF-8">
<link rel="stylesheet" href="/SOF3021_Asm/css/bootstrap.min.css" />
<title>Login</title>

</head>
<body>
	<div class="container">
		<header>

			<div id="carouselExampleControls" class="carousel slide"
				data-bs-ride="carousel">
				<div class="carousel-inner">
					<div class="carousel-item active">
						<img src="/SOF3021_Asm/images/5.jpg" class="img-fluid" style="width: 2000px" alt="">
					</div>
					<div class="carousel-item">
						<img src="/SOF3021_Asm/images/6.jpg" class="img-fluid" style="width: 2000px" alt="...">
					</div>
					<div class="carousel-item">
						<img src="/SOF3021_Asm/images/7.jpg" class="img-fluid" style="width: 2000px" alt="...">
					</div>
				</div>
				<button class="carousel-control-prev" type="button"
					data-bs-target="#carouselExampleControls" data-bs-slide="prev">
					<span class="carousel-control-prev-icon" aria-hidden="true"></span>
					<span class="visually-hidden">Previous</span>
				</button>
				<button class="carousel-control-next" type="button"
					data-bs-target="#carouselExampleControls" data-bs-slide="next">
					<span class="carousel-control-next-icon" aria-hidden="true"></span>
					<span class="visually-hidden">Next</span>
				</button>
			</div>

		</header>
		

		<div class="container">
			<div class="row">
				<nav class="navbar navbar-expand-lg navbar-light bg-light">
					<div class="container-fluid">
						<a class="navbar-brand" href="/SOF3021_Asm/layout">Trang Chủ</a>
						<button class="navbar-toggler" type="button"
							data-bs-toggle="collapse" data-bs-target="#navbarNavDropdown"
							aria-controls="navbarNavDropdown" aria-expanded="false"
							aria-label="Toggle navigation">
							<span class="navbar-toggler-icon"></span>
						</button>
						<div class="collapse navbar-collapse" id="navbarNavDropdown">
							<ul class="navbar-nav">
								<li class="nav-item"><a class="nav-link active"
									aria-current="page" href="/SOF3021_Asm/admin/products/index">Products</a></li>

								<li class="nav-item"><a class="nav-link active"
									aria-current="page" href="/SOF3021_Asm/admin/categories/index">Categories</a></li>
								<li class="nav-item"><a class="nav-link active"
									aria-current="page" href="/SOF3021_Asm/admin/order/index">Orders</a></li>	
								<li class="nav-item"><a class="nav-link active"
									aria-current="page" href="/SOF3021_Asm/admin/orderDetail/index">OrdersDetail</a></li>
								<li class="nav-item dropdown"><a
									class="nav-link dropdown-toggle" href="#"
									id="navbarDropdownMenuLink" role="button"
									data-bs-toggle="dropdown" aria-expanded="false"> Tài Khoản
								</a>
									<ul class="dropdown-menu"
										aria-labelledby="navbarDropdownMenuLink">
										<li><a class="dropdown-item" href="/SOF3021_Asm/admin/accounts/create">Đăng Ký</a></li>
										<li><a class="dropdown-item" href="/SOF3021_Asm/admin/accounts/index">Quản Lý Tài Khoản</a></li>
									</ul></li>
							</ul>
						</div>
					</div>
				</nav>

			</div>
			<div>
				<div class="col-10 offset-1 mt-5">
					<c:if test="${ not empty sessionScope.error }">
						<div class="alert alert-danger">${ sessionScope.error }</div>
						<c:remove var="error" scope="session"/>
					</c:if>
					
					<div class="col-10 offset-1 mt-5">
						<form method="POST" action="${ pageContext.request.contextPath }/login" >
						<div class="card mt-4">
							<div class="card-header text-center">
								<b class=" text-primary">Đăng Nhập</b>
							</div>
							<div class="card-body">
							
								<div class="form-group mt-3">
									<label for="email">Email</label>
									<input type="email" name="email" id="email" class="form-control" />
								</div>
								<div class="form-group mt-3">
									<label for="password">Password</label>
									<input type="password" name="password" id="password" class="form-control" />
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
						</form>
				</div>
			</div>
			</div>
		</div>

		
	</div>



	<script src="/SOF3021_Asm/js/jquery.min.js"></script>
	<script src="/SOF3021_Asm/js/popper.min.js"></script>
	<script src="/SOF3021_Asm/js/bootstrap.min.js"></script>
</body>
</html>