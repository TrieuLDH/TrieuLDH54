
<%@ page language="java" contentType="text/html; charset=UTF-8"
	session="true" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>

<div class="mb-3">
	<a class="btn btn-success" href="/Assignment_IT16305/product/create">Thêm
		Sản Phẩm</a>
</div>
<c:if test="${empty dsproduct }">
	<b class="alert alert-warning">No data available at the moment</b>
</c:if>

<c:if test="${ !empty sessionScope.message }">
	<div class="alert alert-success">
		${ sessionScope.message }
		<c:remove var="message" scope="session"></c:remove>

	</div>

</c:if>

<c:if test="${!empty sessionScope.error }">
	<div class="alert alert-danger">${sessionScope.error }</div>
	<c:remove var="error" scope="session"></c:remove>
</c:if>

<div class="container ">
	<div class="row">
		<div class=" row col-9 pt-4">
		<c:forEach items="${ dsproduct }" var="pro">
			<div class="card m-3" style="width: 16rem">
				<img src="/Assignment_IT16305/images/clothes/${ pro.img }">
				<div class="card-body">
					<h5 class="card-title">${ pro.ten }</h5>
				</div>
				<ul class="list-group list-group-flush">
					<li class="list-group-item">Màu Sắc: ${ pro.mauSac }</li>
					<li class="list-group-item">Đơn Giá: ${ pro.donGia }</li>
					<li class="list-group-item">Số Lượng: ${ pro.soLuong }</li>
				</ul>
				<div class="card-body">
					<td><a class="btn btn-primary"
						href="/Assignment_IT16305/product/edit?id=${ pro.id }">Cập
							nhật</a> <a class="btn btn-danger"
						href="/Assignment_IT16305/product/delete?id=${ pro.id }">Xóa</a>
						<a class="btn btn-success mt-1"
						href="/Assignment_IT16305/cart/index?id=${pro.id }">Giỏ hàng</a>
						</td>
				</div>
			</div>
		</c:forEach>
	</div>

	<div class=" col-3 pt-3">
		<c:if test="${empty dsCate }">
			<p>Null</p>
		</c:if>
		<c:if test="${!empty dsCate }">

			<div>
				<ul class="list-group mt-4 rounded">
					<li class="list-group-item list-group-item-dark fw-bold"
						data-bs-toggle="collapse" data-bs-target="#collapseExample"><i
						class="bi bi-bar-chart-steps"></i> Danh Mục</li>
				</ul>

				<div class="collapse" id="collapseExample">
					<c:forEach items="${ dsCate }" var="cate">
						<li class="list-group-item "><a
							href="/Assignment_IT16305/product/byID?id=${ cate.id }"
							value="${ cate.id }">${ cate.ten }</a></li>
					</c:forEach>
				</div>
			</div>
		</c:if>
	</div>
	</div>
</div>



