<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<%-- <c:if test="${ !empty sessionScope.errors }">
	<div class="alert alert-danger">${ sessionScope.errors }</div>
</c:if> --%>
<c:if test="${ !empty sessionScope.message }">
	<div class="alert alert-success">${ sessionScope.message }</div>
</c:if>
<body>
	<div class="text-center mt-3">
	
			<div class="text-center">
				<h2>Hàng Khuyến Mãi</h2>
			</div>
				<div class="card-group">
                    <div class="card text-success">
                        <div class="card-body">
                            <img alt="" src="/Assignment_IT16305/images/banner1.jpg" style="width: 800px" class="img-fluid">
                        </div>
                    </div>

                    <div class="card text-info">
                        <div class="card-body">
                            <img alt="" src="/Assignment_IT16305/images/banner2.jpg" style="width: 800px" class="img-fluid">
                        </div>
                    </div>
			</div>
			
			<div class="card-group mt-2">
                    <div class="card text-success">
                        <div class="card-body">
                            <img alt="" src="/Assignment_IT16305/images/banner4.jpg" style="width: 800px" class="img-fluid">
                        </div>
                    </div>

                    <div class="card text-info">
                        <div class="card-body">
                            <img alt="" src="/Assignment_IT16305/images/banner4.jpg" style="width: 800px" class="img-fluid">
                        </div>
                    </div>
			</div>
			
			<div class="text-center mt-4">
				<h2>Tin Tức</h2>
			</div>
			<div class="card-group mt-2">
                    <div class="card text-success">
                        <div class="card-body">
                            <img alt="" src="/Assignment_IT16305/images/anhnui1.jpg" style="height: 200px" class="img-fluid">
                            <b class="text-dark">Cảm nhận:  Vẽ đẹp của thiên nhiên Việt Nam</b>
                        </div>
                    </div>

                    <div class="card text-info">
                        <div class="card-body">
                            <img alt="" src="/Assignment_IT16305/images/anhnui2.jpg" style="height: 200px" class="img-fluid">
                            <b class="text-dark">Cảm nhận:  Vẽ đẹp của thiên nhiên Việt Nam</b>
                        </div>
                    </div>
                    <div class="card text-info">
                        <div class="card-body">
                            <img alt="" src="/Assignment_IT16305/images/anhnui3.jpg" style="height: 200px" class="img-fluid">
                            <b class="text-dark">Cảm nhận: Vẽ đẹp của thiên nhiên Việt Nam</b>
                        </div>
                    </div>
                    <div class="card text-info">
                        <div class="card-body">
                            <img alt="" src="/Assignment_IT16305/images/anhnui4.webp" style="height: 200px" class="img-fluid">
                            <b class="text-dark">Cảm nhận: Vẽ đẹp của thiên nhiên Việt Nam</b>
                        </div>
                    </div>
			</div>
			</div>
</body>
</html>