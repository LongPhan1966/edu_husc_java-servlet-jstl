<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
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
   <div class="row  d-flex justify-content-between">
	   	<div class="col-mb-6">
	   		<form action="AdminThemXeController" method="post"> 
				<button name="btnThem" class="btn btn-success" style="margin-left: 10px"> Thêm xe</button>
			</form>
	   	</div>
		
		<div class="col-mb-6">
			<form class="d-flex justify-content-between" action="AdminTimKiemController" method="post"> 
				<input name="key" class="form-control mr-sm-2" type="text" placeholder="Tìm kiếm sản phẩm" aria-label="Search">
	            <button class="btn btn-primary" type="submit">Tìm kiếm</button>
			</form>
		</div>
   </div>
	<table style="margin-top: 20px" class="table">
		 <thead class="thead-dark">
		 <c:set var="i" value="0" scope="page" />
		   <tr>
		     <th scope="col">Ảnh</th>
		     <th scope="col">Tên Xe</th>
		     <th scope="col">Số Lượng</th>
		     <th scope="col">Giá</th>
		     <th scope="col">Loại</th>
		     <th scope="col">Ngày nhập</th>
		     <th scope="col">Hành động</th>
		   </tr>
		 </thead>
		 <tbody>
		 <c:forEach items="${dsxe }" var="s">
		  <form action="AdminQLXeController?mx=${s.getMaxe()}" method="post" >
		   <tr>
		     <td><img style="width: 150px" src='${s.getAnh()}'></td>
		     <td>${s.getTenxe() }</td>
		     <td>${s.getSoluong() }</td>
		     <td><fmt:formatNumber type="NUMBER" value="${s.getGia()}"/></td>
		     <td> ${s.getMaloai() } </td>
			 <td> ${s.getNgayNhap() } </td>
			 <td> 
				<button name="btnSua" type="submit" class="btn btn-warning" value="Sua">
					Sửa
				</button>
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