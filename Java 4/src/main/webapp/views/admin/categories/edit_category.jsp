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

	<form method="POST"  action="/Assignment_IT16305/category/update?id=${cate.id }">
		<div class="card-header text-center">
					<b class=" text-primary">Sửa Danh Mục</b>
		</div>
		<div class="card-body">
			<div>
				<label>ID</label>
				<input class="form-control" type="text" id="id" name="id" value="${cate.id }" readonly/>
			</div>
			<div>
				<label>Tên danh mục</label>
				<input class="form-control" type="text" id="ten" name="ten" value="${cate.ten }"/>
			</div>
			<div>
				<label>ID Người tạo</label>
				<input class="form-control" type="text" id="user.id" name="hoTen" value="${cate.user.id }" readonly/>
			</div>
		</div>
		<div class="card-footer">
			<div class="mt-3">
				<button class="btn btn-success">Sửa</button>
				<button type="reset" class="btn btn-danger">Hủy</button>
			</div>
		</div>
		
	</form>