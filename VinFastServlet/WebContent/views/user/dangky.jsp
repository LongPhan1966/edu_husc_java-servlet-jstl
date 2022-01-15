<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Đăng ký</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<link rel="stylesheet" type="text/css" href="css/main.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css" integrity="sha512-Fo3rlrZj/k7ujTnHg4CGR2D7kSs0v4LLanw2qksYuRlEzO+tcaEPQogQ0KaoGN26/zrn20ImR1DfuLWnOo7aBA==" crossorigin="anonymous" referrerpolicy="no-referrer" />

</head>
<body>
<h2>Đăng ký thành viên</h2>
<form class="container " action="DangKyController" method="post">
<div class="row">
	<div class="col-6">
		<div class="form-group">
			<label for="exampleInputEmail1">Username</label>
			<input name="user" type="text" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" >
		</div>
		
		<div class="form-group">
			<label for="exampleInputEmail1">Họ tên</label>
			<input name="fullname" type="text" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp">
		</div>
		
		<div class="form-group">
			<label for="exampleInputEmail1">Mật Khẩu</label>
			<input name="pass" type="password" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp">
		</div>
		
		<div class="form-group">
			<label for="exampleInputEmail1">Địa chỉ</label>
			<input name="diachi" type="text" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp">
		</div>
		
		<div class="form-group">
			<label for="exampleInputEmail1">email</label>
			<input name="email" type="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp">
		</div>
		
		<div class="form-group">
			<label for="exampleInputEmail1">Số điện thoại</label>
			<input name="sodt" type="text" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp">
		</div>
		<div class="form-group">
		<button type="submit" class="btn btn-success">Đăng ký thành viên</button>		
		</div>
	</div>
	
</div>
</form>
</body>
</html>