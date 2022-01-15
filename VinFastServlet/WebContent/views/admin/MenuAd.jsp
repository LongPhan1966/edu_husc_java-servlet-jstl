<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
<meta charset="utf-8">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<style type="text/css">
	a{
		  text-decoration: none;
		  color: black;
	}
	a:hover {
			text-decoration: none;
		  color: black;
	}
	.nav-item{
		margin: 0 5px 0px 5px;
	}
	*{
		font-size: 15px;
		list-style: none;
	}
</style>
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
	  <div div class="collapse navbar-collapse" id="navbarSupportedContent">
	    <ul class="navbar-nav mr-auto">
    	<li class="nav-item font-weight-bold"><a href="AdminMenuController">Trang chủ</a></li>
	      <li class="nav-item " ><a href="AdminQLXeController">Quản lý xe</a></li>
	      <li class="nav-item "><a href="AdminQLLoaiController">Quản lý loại</a></li>
	      <li class="nav-item "><a href="AdminQLKHController">Quản lý khách hàng</a></li>
	      <li class="nav-item "><a href="AdminQLDHController">Quản lý đơn hàng</a></li>
	    </ul>
	    <ul class="form-inline my-2 my-lg-0">
         	<c:if test="${sessionScope.ad!=null }">
     			<li class="nav-item"> <a href="#">Xin chào:${sessionScope.ad.getTendn() }  </a> </li>
     			<li class="nav-item"><a href="AdminLogoutController" ><span class="glyphicon glyphicon-log-out"></span> Đăng xuất</a></li>
        	</c:if>
	    </ul>
	</nav>
	
	<script type="text/javascript">
		$(document).ready(function(){
	        $('li').click(function() {
	        $("li.active").removeClass("active");
	        $(this).addClass('active');
		});
	</script>
</body>
</html>