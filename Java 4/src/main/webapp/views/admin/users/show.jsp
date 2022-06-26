<%@ page language="java" contentType="text/html; charset=UTF-8"
	session="true" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>


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
<c:if test="${!empty sessionScope.meesage }">
	<div class="alert alert-success">${sessionScope.meesage }</div>
	<c:remove var="meesage" scope="session"></c:remove>
</c:if>

<div class="mb-3">
	<a class="btn btn-success" href="/Assignment_IT16305/users/create">Thêm
		Mới</a>
</div>


<c:if test="${empty ds }">
	<b class="alert alert-warning">No data available at the moment</b>
</c:if>

<c:if test="${!empty ds }">
	<table class="table">
		<thead class="table-primary">
			<th>Họ tên</th>
			<th>SĐT</th>
			<th>Email</th>
			<th>Địa chỉ</th>
			<th colspan="2">Thao tác</th>
		</thead>
		<tbody>
			<c:forEach items="${ds }" var="user">
				<tr>
					<td>${user.hoTen }</td>
					<td>${user.sdt }</td>
					<td>${user.email }</td>
					<td>${user.diaChi }</td>
					<td><a class="btn btn-primary"
						href="/Assignment_IT16305/users/edit?id=${user.id }">Cập Nhật</a>
					</td>
					<td>
						<button type="button" class="btn btn-danger"
							data-bs-toggle="modal" data-bs-target="#exampleModal${ user.id }">
							Xóa</button>
						<div class="modal fade" id="exampleModal${ user.id }"
							tabindex="-1" aria-labelledby="exampleModalLabel${ user.id }"
							aria-hidden="true">
							<div class="modal-dialog">
								<div class="modal-content">
									<div class="modal-header">
										<h5 class="modal-title" id="exampleModalLabel${ user.id }">Thông
											báo</h5>
										<button type="button" class="btn-close"
											data-bs-dismiss="modal" aria-label="Close"></button>
									</div>
									<div class="modal-body">Bạn có muốn xóa không?</div>
									<div class="modal-footer">
										<button type="button" class="btn btn-secondary"
											data-bs-dismiss="modal">Close</button>
										<a href="/Assignment_IT16305/users/delete?id=${ user.id }">
											<button type="button" class="btn btn-danger">Xóa</button>
										</a>
									</div>
								</div>
							</div>
						</div>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</c:if>



