<%@ page language="java" contentType="text/html; charset=UTF-8"
	session="true"
	pageEncoding="UTF-8"%>
	
	<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %> 
	
	<form method="POST"  action="/Assignment_IT16305/category/store">
		<div class="card-header text-center">
					<b class=" text-primary">Tạo Danh Mục</b>
		</div>
		<div class="card-body">
		
			<div>
				<label>Tên danh mục</label>
				<input class="form-control" type="text" id="ten" name="ten" />
			</div>
			<div class="form-group mt-3">
				<label>Người tạo</label>
				<select name="user_id" id="user_id">
					<c:forEach items="${ dsUser }" var="user">
					<option value="${ user.id }">
						${ user.hoTen }
					</option>
					</c:forEach>
				</select>
			</div>
		</div>
		<div class="card-footer">
			<div class="mt-3">
				<button class="btn btn-success">Thêm</button>
				<button type="reset" class="btn btn-danger">Hủy</button>
			</div>
		</div>
		
	</form>
		