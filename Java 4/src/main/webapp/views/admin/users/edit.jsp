<%@ page language="java" contentType="text/html; charset=UTF-8"
	session="true"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %> 
    
    <c:if test="${ !empty sessionScope.message }">
			<div class="alert alert-success">
			${ sessionScope.message }
			<c:remove var="message" scope="session"></c:remove>
			
			</div>
	
	</c:if>
	
	<c:if test="${!empty sessionScope.error }">
		<div class="alert alert-danger">
			${sessionScope.error }
		</div>
		<c:remove var="error" scope="session"></c:remove>
	</c:if> 
	
	<form method="post" action="/Assignment_IT16305/users/update?id=${user.id }">
			<h3 class="text-center">Register</h3>
				<div class="row col-5">
					<div class="form-group mt-3">
						<label>Họ tên</label> <input class="form-control" type="text" name="hoTen" value="${user.hoTen }"/>
					</div>
					<div class="form-group mt-3">
						<label>Địa chỉ</label> <input class="form-control" type="text" name="diaChi" value="${user.diaChi }" />
					</div>
					<div class="form-group mt-3">
						<label>Email</label> <input class="form-control" type="email" name="email" value="${user.email }"/>
					</div>
					
					<div class="form-group mt-3">
						<label>Số điện thoại</label> <input class="form-control" type="text" name="sdt" value="${user.sdt }" />
					</div>
	
					<div class="mt-3">
						<button class="btn btn-success">Sửa</button>
						<button type="reset" class="btn btn-danger">Hủy</button>
					</div>
				</div>
		</form> 
		
		