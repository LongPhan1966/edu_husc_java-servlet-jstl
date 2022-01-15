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
<%-- <form method="post" action ="AdminThemXeController" style = "width: 50%; margin-left: auto; margin-right:auto " enctype="multipart/form-data">
      <div class="row">
             				<div class="col-6">
             				<div class="form-group" >
                              <label class="control-label col-sm-3" for="pwd" style="margin-top: 10px">Mã Xe:</label>
                              <div class="col-sm-9" style="margin-top: 10px">
                                 <input type="text" class="form-control" id="tpwd"
                                    placeholder="Nhập mã xe" name="txtmaxe" required value = "">
                              </div>
                           </div>
                           <div class="form-group">
                              <label class="control-label col-sm-3" for="pwd" style="margin-top: 10px">Tên Xe:</label>
                              <div class="col-sm-9" style="margin-top: 10px">
                                 <input type="text" class="form-control" id="pwd"
                                    placeholder="Nhập tên xe" name="txttenxe" required value = "">
                              </div>
                           </div>
                           <div class="form-group" >
                              <label class="control-label col-sm-3" for="pwd" style="margin-top: 10px">Số lượng:</label>
                              <div class="col-sm-9" style="margin-top: 10px">
                                 <input type="number" class="form-control" id="pwd"
                                    placeholder="Nhập số lượng" name="txtsoluong" required value = "">
                              </div>
                           </div>
                           <div class="form-group" >
                              <label class="control-label col-sm-3" for="pwd" style="margin-top: 10px">Giá:</label>
                              <div class="col-sm-9" style="margin-top: 10px">
                                 <input type="number" class="form-control" id="pwd"
                                    placeholder="Nhập giá" name="txtgia" required value = "">
                              </div>
                           </div>
             				</div>
                           <div class="col-6">
                           	<div class="form-group" >
                              <label class="control-label col-sm-3" for="pwd" style="margin-top: 10px">Thêm loại:</label>
                              <div class="col-sm-9" style="margin-top: 10px">
                                 <select  class="form-control" required name="maloai">
                                 	<c:forEach items="${dsloai }" var="s">
                                 		<option value="${s.getMaloai() }">
                                 			${s.getTenloai() }
                                 		</option>
                                 	</c:forEach>
                        		</select>
                       			</div>
                           </div>
                           
                           <div class="form-group" >
                              <label class="control-label col-sm-3" for="pwd" style="margin-top: 10px">Ngày nhập:</label>
                              <div class="col-sm-9" style="margin-top: 10px">
                                 <input type="date" class="form-control" id="pwd"
                                    placeholder="Ngày nhập" name="txtngaynhap" required value = "">
                              </div>
                           </div>
                           
                           <div class="form-group">
                              <label class="control-label col-sm-3" for="pwd" style="margin-top: 10px">Ảnh:</label>
                              <div class="col-sm-9" style="margin-top: 10px">
                                 <input type="file" class="form-control" id="pwd"
                                    placeholder="Chọn ảnh" name="txtanh" accept="image/png, image/jpeg" required>
                              </div>
                           </div>
             				<div class="col-sm-offset-2 col-sm-3" style="margin-top: 10px">
                                 <button type="submit" class="btn btn-danger"  name ="btnThemXe" value = "btnThemXe">Thêm Xe</button>
                             </div>
                           </div>
          </div>
      </form> --%>
      
	<form class="container">
		<div class="row">
			<div class="col-6">
				<div class="form-group">
					<label for="exampleInputEmail1">Mã Xe</label>
					<input name="txtmaxe" type="text" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Mã xe">
				</div>
				
				<div class="form-group">
					<label for="exampleInputEmail1">Tên Xe</label>
					<input name="txttenxe" type="text" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Tên xe">
				</div>
				
				<div class="form-group">
					<label for="exampleInputEmail1">Số lượng</label>
					<input name="txtsoluong" type="text" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Nhập số lượng">
				</div>
				
				<div class="form-group">
					<label for="exampleInputEmail1">Giá</label>
					<input name="txtgia" type="text" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Nhập giá">
				</div>
			</div>
		
		<div class="col-6">
			<div class="form-group" >
				<label for="pwd">Thêm loại:</label>
				<div>
					<select  class="form-control" required name="maloai">
						<c:forEach items="${dsloai }" var="s">
							<option value="${s.getMaloai() }">
								${s.getTenloai() }
							</option>
						</c:forEach>
					</select>
				</div>
			</div>
			
			<div class="form-group">
				<label for="exampleInputEmail1">Giá</label>
				<input name="txtngaynhap" type="text" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Chọn ảnh">
			</div>
			
			<div class="form-group">
                <label for="pwd">Ảnh:</label>
                <div>
                   <input type="file" class="form-control" id="pwd"
                      placeholder="Chọn ảnh" name="txtanh" accept="image/png, image/jpeg" required>
                </div>
             </div>
             <button type="submit" class="btn btn-primary" name ="btnThemXe" value = "btnThemXe">Thêm xe</button>
		</div>
		</div>
	</form>
</body>
</html>