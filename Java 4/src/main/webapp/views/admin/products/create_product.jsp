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
<form method="post" action="/Assignment_IT16305/product/store">
			<h3 class="text-center">Thêm Sản Phẩm</h3>
				<div class="row col-5 offset-4">
					<div class="form-group mt-3">
						<label>Tên Sản Phẩm</label> <input class="form-control" type="text" name="ten" />
					</div>
					
					<div class="form-group mt-3">
						<label>Số Lượng</label> <input class="form-control" type="text" name="soLuong" />
					</div>
					<div class="form-group mt-3">
						<label>Đơn Giá</label> <input class="form-control " type="text" name="donGia" />
					</div>
					<div class="form-group mt-3">
						<label>Màu Sắc</label> <input class="form-control " type="text" name="mauSac" />
					</div>
					 <div class="form-group mt-3">
						<label>ID_Danh Mục</label>
						<select name="category_id" id="category_id">
							<c:forEach items="${ dsCate }" var="cate">
							<option value="${ cate.id }">
								${ cate.ten }
							</option>
							</c:forEach>
						</select>
					</div> 
					<div class="form-group mt-3">
						<label>Kích Thước</label> <input class="form-control" type="text" name="kichThuoc" />
					</div>
					
					<div class="form-group mt-3">
						<label>Hình Ảnh</label>
						 <input class="form-control" type="file" name="img" />
					</div>
					
					<div class="mt-3">
						<button class="btn btn-success">Thêm</button>
						<button type="reset" class="btn btn-danger">Hủy</button>
					</div>
				</div>
		</form>