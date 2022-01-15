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
<div class="container">
	<form action="AdminQLLoaiController" method="post"> 
		<button name="btnThemLoai" class="btn btn-success" style="margin-left: 10px"> Thêm loại</button>
	</form>
	<table class="table">
	<thead>
	  <tr>
	    <th scope="col">Mã Loại</th>
	    <th scope="col">Tên loại</th>
	    <th scope="col">Chức năng sửa</th>
	    <th scope="col">Chức năng xóa</th>
	  </tr>
	</thead>
	<tbody>
	<c:forEach items="${dsloai }" var="s">
	  <form action="AdminQLLoaiController?ml=${s.getMaloai() }" method="post" >
	  <tr>
	    <td> ${s.getMaloai() } </td>
		<td> ${s.getTenloai() } </td>
		<td> 
			<button name="btnSua" type="submit" class="btn btn-warning" value="Sua">
				Sửa
			</button>
		</td>
		<td> 
			<button name="btnXoa" type="submit" class="btn btn-danger" value="Xoa">
				Xóa
			</button>
		</td>
	  </tr>
	  </form>
	  </c:forEach>
	</tbody>
</table>
</div>
</body>
</html>