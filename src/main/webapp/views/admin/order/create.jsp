<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form"
	prefix="form" %>
	<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/SOF3021_Asm/css/bootstrap.min.css" />
<title> Create Order</title>
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
									aria-current="page" href="#">Products</a></li>

								<li class="nav-item"><a class="nav-link active"
									aria-current="page" href="#">Categories</a></li>
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
		</div>
		
		<div class="container">
			<div class="row">
				<form:form
					method="POST"
					action="/SOF3021_Asm/admin/order/store"
					modelAttribute="order">
					<div class="row col-5 offset-4">
						<div class="form-group mt-3">
							<label class="form-label ">User_ID</label> 
							<form:select
								name="account"  path="account">
								<c:forEach items="${ dsAcc }" var="acc">
									<option value="${ acc.id }">${ acc.username }</option>
								</c:forEach>
							</form:select>
						</div>
						<div class="form-group mt-3">
							<label>Created_Date</label>
							<form:input path="createdDate" class="form-control" type="date"/>
						</div>
						<div class="form-group mt-3">
							<label>Address</label>
							<form:input path="address" class="form-control" />
						</div>
									
						<div class="mt-3">
							<button class="btn btn-success">Thêm</button>
							<a class="btn btn-danger">Hủy</a>
						</div>
					</div>
				</form:form>
			</div>
		</div>

		<div class="text-center">
			<footer class="text-center mt-3">
				<div class="card-group">
                    <div class="card text-success">
                        <div class="card-body">
                            <h5 class="card-title fw-bold">HÀ NỘI</h5>
                            <p class="card-text">
                                ĐC: 125 Phố Phùng Hưng, Hà Đông, Hà Nội
                            </p>
                            <p class="card-text">
                                Điện thoại: 08.8911.9999
                            </p>
                            <p class="card-text">
                                Email: shopclothesmen@gmail.com
                            </p>
                        </div>
                    </div>

                    <div class="card text-info">
                        <div class="card-body">
                            <h5 class="card-title fw-bold">TP. HỒ CHÍ MINH</h5>
                            <p class="card-text">
                            
                            	ĐC: 124 Trần Quang Diệu, TP.HCM
                            </p>
                            <p class="card-text">
                                Điện thoại: 08.1111.9999
                            </p>
                            <p class="card-text">
                                Email: shopclothesmen@gmail.com
                            </p>
                        </div>
                    </div>

                    <div class="card text-warning">
                        <div class="card-body">
                            <h5 class="card-title fw-bold ">ĐÀ NẴNG</h5>
                            <p class="card-text">
                            	ĐC: 48 Đ.Chi Lăng, TP. Đà Nẵng
                            </p>
                            <p class="card-text">
                                Điện thoại: 08.1111.9999
                            </p>
                            <p class="card-text">
                                Email: shopclothesmen@gmail.com
                            </p>
                        </div>
                    </div>
                    </div>
			</footer>
		</div>
	</div>



	<script src="/SOF3021_Asm/js/jquery.min.js"></script>
	<script src="/SOF3021_Asm/js/popper.min.js"></script>
	<script src="/SOF3021_Asm/js/bootstrap.min.js"></script>
</body>
</html>