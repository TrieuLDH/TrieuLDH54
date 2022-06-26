<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/Assignment_IT16305/css/bootstrap.min.css" />
<title>Page</title>

</head>
<body>
	<div class="container">
		<header>

			<div id="carouselExampleControls" class="carousel slide"
				data-bs-ride="carousel">
				<div class="carousel-inner">
					<div class="carousel-item active">
						<img src="/Assignment_IT16305/images/banner-thoi-trang-nam.jpg" class="img-fluid" style="width: 2000px" alt="">
					</div>
					<div class="carousel-item">
						<img src=" /Assignment_IT16305/images/2.jpg" class="img-fluid" style="width: 2000px" alt="...">
					</div>
					<div class="carousel-item">
						<img src=" /Assignment_IT16305/images/3.jpg" class="img-fluid" style="width: 2000px" alt="...">
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
						<a class="navbar-brand" href="/Assignment_IT16305/users/index">Trang Chủ</a>
						<button class="navbar-toggler" type="button"
							data-bs-toggle="collapse" data-bs-target="#navbarNavDropdown"
							aria-controls="navbarNavDropdown" aria-expanded="false"
							aria-label="Toggle navigation">
							<span class="navbar-toggler-icon"></span>
						</button>
						<div class="collapse navbar-collapse" id="navbarNavDropdown">
							<ul class="navbar-nav">
								<li class="nav-item"><a class="nav-link active"
									aria-current="page" href="/Assignment_IT16305/product/index">Products</a></li>

								<li class="nav-item"><a class="nav-link active"
									aria-current="page" href="/Assignment_IT16305/category/index">Categories</a></li>
				
								<li class="nav-item"><a class="nav-link active"
									aria-current="page" href="/Assignment_IT16305/cart/index">Cart</a></li>
									
								<li class="nav-item dropdown"><a
									class="nav-link dropdown-toggle" href="#"
									id="navbarDropdownMenuLink" role="button"
									data-bs-toggle="dropdown" aria-expanded="false"> Tài Khoản
								</a>
									<ul class="dropdown-menu"
										aria-labelledby="navbarDropdownMenuLink">
										<li><a class="dropdown-item" href="/Assignment_IT16305/users/store">Đăng Ký</a></li>
										<li><a class="dropdown-item" href="/Assignment_IT16305/login">Đăng Nhập</a></li>
										<li><a class="dropdown-item" href="/Assignment_IT16305/users/show">Quản Lý Tài Khoản</a></li>
										<li><a class="dropdown-item" href="#">Đăng Xuất</a></li>
									</ul></li>
							</ul>
						</div>
					</div>
				</nav>

				<div class="row mt-4">
					<div class="col-12">
						<jsp:include page="${view }"></jsp:include>
					</div>
				</div>
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
			</footer>
		</div>
	</div>



	<script src="/Assignment_IT16305/js/jquery.min.js"></script>
	<script src="/Assignment_IT16305/js/popper.min.js"></script>
	<script src="/Assignment_IT16305/js/bootstrap.min.js"></script>
</body>
</html>