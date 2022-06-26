<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/SOF3021_Asm/css/bootstrap.min.css" />
<title>homeDetail</title>
</head>
<body>

	<div class="container">
		<header>

			<div id="carouselExampleControls" class="carousel slide"
				data-bs-ride="carousel">
				<div class="carousel-inner">
					<div class="carousel-item active">
						<img src="/SOF3021_Asm/images/5.jpg" class="img-fluid"
							style="width: 2000px" alt="">
					</div>
					<div class="carousel-item">
						<img src="/SOF3021_Asm/images/6.jpg" class="img-fluid"
							style="width: 2000px" alt="...">
					</div>
					<div class="carousel-item">
						<img src="/SOF3021_Asm/images/7.jpg" class="img-fluid"
							style="width: 2000px" alt="...">
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
								<li class="nav-item"><a class="nav-link active"
									aria-current="page" href="/SOF3021_Asm/admin/order/index">Orders</a></li>
								<li class="nav-item dropdown"><a
									class="nav-link dropdown-toggle" href="#"
									id="navbarDropdownMenuLink" role="button"
									data-bs-toggle="dropdown" aria-expanded="false"> Tài Khoản
								</a>
									<ul class="dropdown-menu"
										aria-labelledby="navbarDropdownMenuLink">
										<li><a class="dropdown-item"
											href="/SOF3021_Asm/admin/accounts/create">Đăng Ký</a></li>
										<li><a class="dropdown-item"
											href="/SOF3021_Asm/admin/accounts/index">Quản Lý Tài
												Khoản</a></li>
									</ul></li>
							</ul>
						</div>
					</div>
				</nav>

			</div>
		</div>

		<div class="container">
			<div class="row responsive">
						<div class=" col-8 mt-4">
							<div class="col-12 col-lg-12 row container  p-2">
								<c:forEach items="${ data.content }" var="pro">
									<div class="card col-md-3 p-3 mb-3 ms-3	text-center">

										<form:form
											action="/SOF3021_Asm/admin/orderDetail/store/${pro.id }"
											method="POST" modelAttribute="orderDetail">
											<div class="card-body">
												<img src="/SOF3021_Asm/images/clothes/${ pro.image }"
													class="img-fluid mt-4 rounded mx-auto"
													style="height: 200px" width="800px" alt="...">
											</div>
											<div class="card-footer">
												<h5 class="card-title">${pro.name }</h5>
												<p class="card-text">Giá bán: ${pro.price } VNĐ</p>
											</div>

											<form:input path="quantity" class="col-8 form-control" />
											<div class="row text-center">
												<button class="col-12 btn btn-primary mt-2">Thêm
													vào giỏ hàng</button>
											</div>
										</form:form>
									</div>
								</c:forEach>
							</div>
						</div>
						<div class="col-4 mt-3">
							<table class="table">
								<thead>
									<tr>
										<th>Tên sản phẩm</th>
										<th>Số lượng</th>
										<th>Giá</th>
										<th>Tổng tiền</th>
										<th>Action</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${ dataOrder }" var="cart">
										<form:form action="/SOF3021_Asm/admin/orderDetail/update/${cart.product.id }"
											method="POST" modelAttribute="orderDetail">
											<tr>
											<td>${ cart.product.name }</td>
											<td>
												<input name="quantity" value="${ cart.quantity }"
												onblur="this.form.submit()" style="width: 50px">
											</td>
											<td>${ cart.product.price }</td>
											<td>${ cart.price }</td>
											<td >
											<button type="button" class="btn btn-danger"
												data-bs-toggle="modal" data-bs-target="#exampleModal${ cart.id }">
												Xóa</button>
											<div class="modal fade" id="exampleModal${ cart.id }"
												tabindex="-1" aria-labelledby="exampleModalLabel${ cart.id }"
												aria-hidden="true">
												<div class="modal-dialog">
													<div class="modal-content">
														<div class="modal-header">
															<h5 class="modal-title" id="exampleModalLabel${ cart.id }">Thông
																báo</h5>
															<button type="button" class="btn-close"
																data-bs-dismiss="modal" aria-label="Close"></button>
														</div>
														<div class="modal-body">Bạn có muốn xóa không?</div>
														<div class="modal-footer">
															<button type="button" class="btn btn-secondary"
																data-bs-dismiss="modal">Close</button>
															<a href="/SOF3021_Asm/admin/orderDetail/delete/${ cart.id }">
																<button type="button" class="btn btn-danger">Xóa</button>
															</a>
														</div>
													</div>
												</div>
											</div>
										</td>
											
											
										</tr>
										</form:form>
									</c:forEach>
								</tbody>
							</table>
							
							
						<div class="row">
							<form:form action="/SOF3021_Asm/admin/orderDetail/add"
								method="POST" modelAttribute="oder">
							    	<h3 class="text-info text-center mt-1">Hóa Đơn</h3>
									   <div class="form-group mt-3">
										    <label>Thành tiền</label>
										    <input class="form-control" type="text" value="${thanhtien }">
									    </div>
									    
									    <div class="form-group mt-3">
										     <label>Tên khách hàng</label>
										    <input class="form-control" type="text" value="">
									    </div>
									    
									    <div>
										    <label>Ngày Mua</label>
										    <form:input class="form-control" path="createdDate" type="date"/>  
									    </div>
										
									    <div class="form-group mt-3">
										    <label>Địa chỉ</label>
										    <form:input class="form-control" path="address"/>  
									    </div>
									    <div>
									    	<button class="btn btn-primary mt-2">Thanh toán</button>
									    </div>
							</form:form>
						</div>
						</div>
					</div>
				</div>


			</div>

		<div class="row align-items-center">
			<div class="col-md-6 offset-6">
				<ul class="pagination">
					<c:forEach var="i" begin="0" end="${ data.totalPages -1 }">
						<li class="page-item"><a class="page-link"
							href="/SOF3021_Asm/admin/orderDetail/index?page=${ i }"> ${ i + 1 }
						</a></li>
					</c:forEach>
				</ul>
			</div>
		</div>

		<div class="col-4">
			<div class="row">

				<div class="col-7"></div>


			</div>
		</div>



	<script src="/SOF3021_Asm/js/jquery.min.js"></script>
	<script src="/SOF3021_Asm/js/popper.min.js"></script>
	<script src="/SOF3021_Asm/js/bootstrap.min.js"></script>

</body>
</html>