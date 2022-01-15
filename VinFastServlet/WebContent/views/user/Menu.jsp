<%@page import="bean.KhachHangBean"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
	<!-- Navbar -->
  <nav class="navbar fixed-top navbar-expand-lg navbar-light white scrolling-navbar">
    <div class="container">

      <!-- Brand -->
      <a class="navbar-brand waves-effect" href="homeUsController" >
        <img alt="" src="img/logo-vinfast.png" style="width: 150px;" alt="logo">
      </a>

      <!-- Collapse -->
      <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent"
        aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>

      <!-- Links -->
      <div class="collapse navbar-collapse" id="navbarSupportedContent">

        <!-- Left -->
        <ul class="navbar-nav mr-auto">
          <li class="nav-item active">
            <a class="nav-link waves-effect" href="HomeController">Home
              <span class="sr-only">(current)</span>
            </a>
          </li>
          <li class="nav-item active">
            <a class="nav-link waves-effect" href="LichSuController?name=LichSu">Lịch sử mua
              <span class="sr-only">(current)</span>
            </a>
          </li>
        </ul>

        <!-- Right -->
        <ul class="navbar-nav nav-flex-icons">
          <li class="nav-item " style="margin-right: 15px;">
            <a href="GioHangController?name=GioHang" class="nav-link waves-effect">
              <span class="badge red z-depth-1 mr-1"> 1 </span>
              <i class="fas fa-shopping-cart"></i>
              <span class="clearfix d-none d-sm-inline-block"> Cart </span>
            </a>
          </li>
          
          <c:if test="${sessionScope.kh == null }">
	          <li class="nav-item" style="margin-right: 15px;">
	            <a href="HTDKController" class="btn btn-button btn-primary" target="">
	              Đăng ký
	            </a>
	            	<% if (session.getAttribute("ThongBaoThanhCong")!=null)
		       		{
	       	   			out.print("<script>alert('"+session.getAttribute("ThongBaoThanhCong")+"');</script>" );
	       	   			session.removeAttribute("ThongBaoThanhCong");
	       	   		}
	      	  		%>
		      	 <% if (session.getAttribute("ThongBaoThatBai")!=null)
			       		{
		       	   			out.print("<script>alert('"+session.getAttribute("ThongBaoThatBai")+"');</script>" );
		       	   			session.removeAttribute("ThongBaoThatBai");
		       	   		}
		      	  %>
	          </li>
			</c:if>
          
			<c:if test="${sessionScope.kh != null }">
				<li class="nav-item">
					<p style="margin: 7px 10px 0 0;" class="text-success">Xin chào: ${sessionScope.kh.hoTenKH }</p>
				</li>
				<li class="nav-item">
					<a href="DangXuatController" class="btn btn-button btn-danger">Đăng xuất</a>
				</li>
			</c:if>
			
			<c:if test="${sessionScope.kh == null }">
				<li class="nav-item">
					<a href="DangNhapController" class="btn btn-button btn-success">Đăng nhập</a>
				</li>
			</c:if>
	
          
        </ul>

      </div>

    </div>
  </nav>
  <!-- Navbar -->