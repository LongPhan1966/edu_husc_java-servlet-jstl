<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
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
        let message = "${XacNhanThanhCong}";
        alert(message);
   		 </script>
    </c:if>
<table class="table table-hover">
		<tr>
			<td valign="top" width="80%">
			  <table class="table table-hover">
			  <c:set var="i" value="0" scope="page" />
			  <tr>
			  	<td> <h1> Chi tiết đơn hàng</h1> </td>
			  </tr>
			  	<tr>
			  		<td> Mã CTHĐ</td>
       				<td> Mã hóa đơn</td>
       				<td> Mã Sách</td>
       				<td> Tên sách</td>
       				<td> Số lượng mua</td>
       				<td> Tên loại</td>
       				<td> Họ tên KH</td>
       				<td> SDT Khách hàng</td>
			  	</tr> 
			  <c:forEach items="${dsctdh }" var="s">
			  	<tr> 
       				<td> ${s.getMaChiTietHD() }</td>
       				<td> ${s.getMaHoaDon() } </td>
       				<td> ${s.getMaSach() } </td>
       				<td> ${s.getTensach() } </td>
       				<td> ${s.getSoluongMua() } </td>
       				<td> ${s.getTenloai() } </td>
       				<td> ${s.getHoTenKH() } </td>
       				<td> ${s.getSDT() } </td>
       			</tr>
   			  </c:forEach>
			</table>
 			</td>
			<td valign="top" width="35%">
				<form action="AdminQLDHController" method="post">
					<button type="submit" name="btnQuayLai">Quay lại</button>
				</form>
			</td>
		</tr>
	</table>
</body>
</html>