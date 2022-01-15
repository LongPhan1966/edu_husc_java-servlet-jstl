<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    
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
<form meathod ="post" action ="AdminThemLoaiController" style = "width: 50%; margin-left: auto; margin-right:auto ">
       
       <div class="row">
			<div class="col-6 row" >
                 <label class="col-sm-3" for="pwd" style="margin-top: 10px">Mã loại:</label>
                 <div class="col-sm-9" style="margin-top: 10px">
                    <input type="text" class="form-control" id="tpwd"
                       placeholder="Nhập mã loại" name="txtmaloai" required value = "">
                 </div>
              </div>
              <div class="col-6 row">
                 <label class="col-sm-3" for="pwd" style="margin-top: 10px">Tên loại:</label>
                 <div class="col-sm-9" style="margin-top: 10px">
                    <input type="text" class="form-control" id="pwd"
                       placeholder="Nhập tên loại" name="txttenloai" required value = "">
                 </div>
              </div>	
          </div>
          <div class="col-sm-offset-2 col-sm-10" style="margin-top: 10px">                
              <button type="submit" class="btn btn-danger"  name = "update" value = "update">Update</button>
			</div>
      </form>
</body>
</html>