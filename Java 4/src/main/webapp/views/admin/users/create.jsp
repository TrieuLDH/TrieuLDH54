<%@ page language="java" contentType="text/html; charset=UTF-8"
	session="true"
	pageEncoding="UTF-8"%>
	
	<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %> 
	 <c:if test="${!empty sessionScope.error }">
		<div class="alert alert-danger">
			${sessionScope.error }
		</div>
		<c:remove var="error" scope="session"></c:remove>
	</c:if>  
	<c:if test="${!empty sessionScope.meesage }">
		<div class="alert alert-success">
			${sessionScope.meesage }
		</div>
		<c:remove var="meesage" scope="session"></c:remove>
	</c:if>
<form method="post" action="/Assignment_IT16305/users/store">
			<h3 class="text-center">Register</h3>
				<div class="row col-5 offset-4">
					<div class="form-group mt-3">
						<label>Họ tên</label> <input class="form-control" type="text" name="hoTen" />
					</div>
					<div class="form-group mt-3">
						<label>Địa chỉ</label> <input class="form-control" type="text" name="diaChi" />
					</div>
					<div class="form-group mt-3">
						<label>Email</label> <input class="form-control" type="email" name="email" />
					</div>
					<div class="form-group mt-3">
						<label>Mật khẩu</label> <input class="form-control " type="password" name="password" />
					</div>
					<div class="form-group mt-3">
						<label>Số điện thoại</label> <input class="form-control" type="text" name="sdt" />
					</div>
	
					<div class="mt-3">
						<button class="btn btn-success">Thêm</button>
						<button type="reset" class="btn btn-danger">Hủy</button>
					</div>
				</div>
		</form>