<%@ page language="java" contentType="text/html; charset=UTF-8"
	session="true"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %> 
   
   <c:if test="${ !empty sessionScope.meesage }">
			<div class="alert alert-success">
			${ sessionScope.meesage }
			<c:remove var="meesage" scope="session"></c:remove>
			
			</div>
	
	</c:if>
	 <c:if test="${!empty sessionScope.error }">
		<div class="alert alert-danger">
			${sessionScope.error }
		</div>
		<c:remove var="error" scope="session"></c:remove>
	</c:if>
   
   
   <div class="mb-3">
		<a class="btn btn-success" href="/Assignment_IT16305/category/create">Thêm Mới</a>
	</div>
   <c:if test="${empty dsCate }">
   	<b class="alert alert-warning">No data available at the moment</b>
   </c:if>
   
   <c:if test="${!empty dsCate }">
   		<table class="table">
   			<thead class="table_light">
   				<th>ID</th>
   				<th>Tên Danh Mục</th>
   				<th>Người Tạo</th>
   				<th>ID Người Tạo</th>
   				<th colspan="2">Thao tác</th>
   			</thead>
   			<tbody>
   				<c:forEach var="cate" items="${dsCate}" >
   				<tr>
   					<td>${cate.id }</td>
   					<td>${cate.ten }</td>
   					<td>${cate.user.hoTen}</td>
   					<td>${cate.user.id}</td>
   					<td>
						<a class="btn btn-primary" href="/Assignment_IT16305/category/edit?id=${cate.id }">Cập Nhật</a>
					</td>
					<td>
						<button type="button" class="btn btn-danger"
							data-bs-toggle="modal" data-bs-target="#exampleModal${cate.id }">
							Xóa</button>
						<div class="modal fade" id="exampleModal${cate.id }"
							tabindex="-1" aria-labelledby="exampleModalLabel${cate.id }"
							aria-hidden="true">
							<div class="modal-dialog">
								<div class="modal-content">
									<div class="modal-header">
										<h5 class="modal-title" id="exampleModalLabel${cate.id }">Thông
											báo</h5>
										<button type="button" class="btn-close"
											data-bs-dismiss="modal" aria-label="Close"></button>
									</div>
									<div class="modal-body">Bạn có muốn xóa không?</div>
									<div class="modal-footer">
										<button type="button" class="btn btn-secondary"
											data-bs-dismiss="modal">Close</button>
										<a href="/Assignment_IT16305/category/delete?id=${cate.id }">
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
   