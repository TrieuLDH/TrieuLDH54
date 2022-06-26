
<%@ page language="java" contentType="text/html; charset=UTF-8"
	session="true"
	pageEncoding="UTF-8"%>
	
	<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %> 
	<c:if test="${empty dsproduct }">
   	<b class="alert alert-warning">No data available at the moment</b>
   </c:if>
   
	<c:if test="${!empty dsproduct }">
   		<table class="table">
   			<thead class="table_light">
   				<th>Tên Sản Phẩm</th>
   				<th>Danh Mục</th>
   				<th>Giá</th>
   				<th>Số Lượng</th>
   				<th>Màu Sắc</th>
   				<th>Kích Thước</th>
   				<th colspan="2">Thao tác</th>
   			</thead>
   			<tbody>
   				<c:forEach var="pro" items="${dsproduct}" >
   				<tr>
   					<td>${pro.ten }</td>
   					<td>${pro.cate.ten }</td>
   					<td>${pro.soLuong}</td>
   					<td>${pro.donGia}</td>
   					<td>${pro.mauSac}</td>
   					<td>${pro.kichThuoc}</td>
   					<td>
						<a>Xóa</a>
					</td>
				</tr>
   				</c:forEach>
   			</tbody>
   		</table>
   </c:if>