<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Đăng nhập Admin</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<link rel="stylesheet" href="css/style.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

<style type="text/css">	
.content{
	height: 898px;
    color: #fff;
    padding-top: 100px;
    padding-bottom: 50px;
    background-image: url("img/bg-contact.png");
    width: 100%;
    background-position: center;
    background-repeat: no-repeat;
    background-size: cover;
	}
</style>

</head>
<body>
	<c:if test="${not empty tb}">
        <script>
	        let message = "${tb}";
	        alert(message);
   		 </script>
    </c:if>
    <div class="content">
    <div class="col-md-4 container">
       <div class="mt-50">
           <div class="col-lg-11">
               <div class="text-center">
                    <img src="img/logo-vinfast.png" style="width: 185px;" alt="logo">
               </div>

               <form style="margin-top: 50px;" method="post" action="AdminLoginController" class="mt-50">
            		<label>Admin Login</label>
               
                   <div class="form-outline mb-4">
                       <input name="txtun" type="text" id="form2Example11" class="form-control" placeholder="user name"/>
                   </div>
   
                   <div class="form-outline mb-4">
                       <input name="txtpass" type="password" id="form2Example22" class="form-control" placeholder="password"/>
                   
                   </div>
   
                   <div class="text-center pt-1 mb-5 pb-1">
                       <button class="btn btn-primary btn-block fa-lg gradient-custom-2 mb-3" type='submit'>Log in</button>
                       <a class="text-muted" href="#!">Forgot password?</a>
                   </div>                
               </form>
           </div>  
       </div>
    </div>
    </div>
</body>
</html>