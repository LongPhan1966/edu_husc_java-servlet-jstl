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
	
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
</head>
<body>
<jsp:include page="MenuAd.jsp"></jsp:include>
<div class="container">
	<table class="table table-hover">
		<tr>
			<td valign="top" width="80%">
			  <table class="table table-hover">
			  <c:set var="i" value="0" scope="page" />
			  	<tr>
			  		<td> Mã HĐ</td>
       				<td> Mã KH</td>
       				<td> Họ tên KH</td>
       				<td> Thành tiền</td>
       				<td> Ngày mua </td>
       				<td> Tình trạng</td>
       				<td> Chức năng</td>
			  	</tr> 
			  <c:forEach items="${dsdh }" var="s">
			  <form action="AdminQLDHController?madh=${s.getMaHD() }" method="post" > 
			  	<tr> 
       				<td> ${s.getMaHD() }</td>
       				<td> ${s.getMaKH() } </td>
       				<td> ${s.getHoTen() }</td>
       				<td> ${s.getThanhTien() } </td>
       				<td> ${s.getNgayMua()}</td>
       				<c:if test="${s.getDamua()==true }">
       					<td><p class="badge badge-success">Đã xác nhận</p></td>
       				</c:if>
       				<c:if test="${s.getDamua()==false}">
       					<td><p class="badge badge-secondary">Chưa xác nhận</p></td>
       				</c:if>
					<td> 
						<button name="btnXacNhan" type="submit" class="btn btn-success" value="XacNhan">
							Xác nhận
						</button>
						<button name="btnChiTiet" type="submit" class="btn btn-info" value="ChiTiet">
							Xem chi tiết
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