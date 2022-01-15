<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>	
<!DOCTYPE html>
<html>
<head>
<title>Admin Menu</title>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>

<jsp:include page="MenuAd.jsp"></jsp:include>
<c:if test="${not empty tb}">
        <script>
        let message = "${tb}";
        alert(message);
   		 </script>
    </c:if>
	
	<div class="container">
		<table class="table table-hover">
		<tr>
			<td valign="top" width="80%">
			  <table class="table table-hover">
			  <c:set var="i" value="0" scope="page" />
			  	<tr>
			  		<td> Mã KH</td>
       				<td> Tên KH</td>
       				<td> Địa chỉ </td>
       				<td> Số ĐT</td>
       				<td> Email</td>
       				<td> Tên ĐN </td>
       				<td> Mật khẩu </td>
       				<td> Chức năng</td>
			  	</tr> 
			  <c:forEach items="${dskh }" var="s">
			  <form action="AdminQLKHController?makh=${s.getMaKH() }" method="post" > 
			  	<tr> 
       				<td> ${s.getMaKH() }</td>
       				<td> ${s.getHoTenKH() } </td>
       				<td> ${s.getDiaChi() } </td>
       				<td> ${s.getSDT() } </td>
       				<td> ${s.getEmail() } </td>
       				<td> ${s.getTenDN() } </td>
       				<td> ${s.getMatKhau() } </td>
					<td> 
						<button name="btnXoa" type="submit" class="btn btn-danger" value="Xoa">
							Xóa
						</button>
					</td>
       			</tr>
       		  </form>
   			  </c:forEach>
			</table>
 			</td>
		</tr>
	</table>
	</div>
</body>
</html>