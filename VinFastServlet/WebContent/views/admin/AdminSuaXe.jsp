<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
        
<%@page import="bean.KhachHangBean"%>
<%@page import="bean.Xebean"%>
<%@page import="bo.Xebo"%>
<%@page import="bean.Loaibean"%>
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
<%-- <form method ="post" action ="AdminSuaXeController" style = "width: 50%; margin-left: auto; margin-right:auto " >
		
       
             			<div class="form-group" >
                              <label class="control-label col-sm-2" for="pwd" style="margin-top: 10px">Mã xe:</label>
                              <div class="col-sm-10" style="margin-top: 10px">
                                 <input type="text" class="form-control" id="tpwd"
                                    placeholder="Nhập mã xe" name="txtmaxe" readonly="readonly" value = "${xebean.getMaxe()}">
                              </div>
                           </div>
                           <div class="form-group">
                              <label class="control-label col-sm-2" for="pwd" style="margin-top: 10px">Tên sách:</label>
                              <div class="col-sm-10" style="margin-top: 10px">
                                 <input type="text" class="form-control" id="pwd"
                                    placeholder="Nhập tên xe" name="txttenxe" required value = "${xebean.getTenxe() }">
                              </div>
                           </div>
                           <div class="form-group" >
                              <label class="control-label col-sm-2" for="pwd" style="margin-top: 10px">Số lượng:</label>
                              <div class="col-sm-10" style="margin-top: 10px">
                                 <input type="number" class="form-control" id="pwd"
                                    placeholder="Nhập số lượng" name="txtsoluong" required value = "${xebean.getSoluong() }">
                              </div>
                           </div>
                           <div class="form-group" >
                              <label class="control-label col-sm-2" for="pwd" style="margin-top: 10px">Giá:</label>
                              <div class="col-sm-10" style="margin-top: 10px">
                                 <input type="number" class="form-control" id="pwd"
                                    placeholder="Nhập giá" name="txtgia" required value = "${xebean.getGia() }">
                              </div>
                           </div>
                           <div class="form-group" >
                              <label class="control-label col-sm-2" for="pwd" style="margin-top: 10px">Tên loại:</label>
                              <div class="col-sm-10" style="margin-top: 10px">
                                 <select  class="form-control" required name="maloai">
	                                 <c:forEach items="${dsloai }" var="s">
	                                 	<c:if test="${xebean.getMaloai() eq s.getMaloai() }">
	                                 		<option value="${xebean.getMaloai()}" selected="selected" >
	                                 			${s.getTenloai() }
	                                 		</option>
	                                 	</c:if>
	                                 </c:forEach>
	                                 	<c:forEach items="${dsloai }" var="s">
	                                 	<c:choose>
										    <c:when test="${xebean.getMaloai() eq s.getMaloai() }">
										       <option value="${xebean.getMaloai()}" hidden="">
	                                 			${s.getTenloai() }
	                                 			</option>
										    </c:when>
										    <c:otherwise>
										        <option value="${s.getMaloai() }">
	                                 				${s.getTenloai() }
	                                 			</option>
										    </c:otherwise>
										</c:choose>
	                                 </c:forEach>
                        		</select>
                       		</div>
                           </div>
                           
                           <div class="form-group" >
                              <label class="control-label col-sm-2" for="pwd" style="margin-top: 10px">Số tập:</label>
                              <div class="col-sm-10" style="margin-top: 10px">
                                 <input type="number" class="form-control" id="pwd"
                                    placeholder="Nhập số tập" name="txtsotap" required value = "${sachbean.getSoTap() }">
                              </div>
                           </div>
                           
                           <div class="form-group" >
                              <label class="control-label col-sm-2" for="pwd" style="margin-top: 10px">Ngày nhập:</label>
                              <div class="col-sm-10" style="margin-top: 10px">
                                 <input type="date" class="form-control" id="pwd"
                                    placeholder="Ngày nhập" name="txtngaynhap" required value = "${xebean.getNgayNhap() }">
                              </div>
                           </div>
                           
                           <div class="form-group" >
                              <label class="control-label col-sm-2" for="pwd" style="margin-top: 10px">Tác giả:</label>
                              <div class="col-sm-10" style="margin-top: 10px">
                                 <input type="text" class="form-control" id="pwd"
                                    placeholder="Nhập tác giả" name="txttacgia" required value = "${sachbean.getTacgia() }">
                              </div>
                           </div>
             				<div class="col-sm-offset-2 col-sm-10" style="margin-top: 10px">
                                
                                 <button type="submit" class="btn btn-danger"  name = "btnSuaXe" value = "update">Sửa thông tin xe</button>
                             </div>
      </form> --%>
      <c:if test="${not empty tb}">
        <script>
        let message = "${tb}";
        alert(message);
   		 </script>
    	</c:if>
      <form class="container"  method ="post" action ="AdminSuaXeController">
		<div class="row">
			<div class="col-6">
				<div class="form-group">
					<label for="exampleInputEmail1">Mã Xe</label>
					<input name="txtmaxe" type="text" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Mã xe" value = "${xebean.getMaxe()}">
				</div>
				
				<div class="form-group">
					<label for="exampleInputEmail1">Tên Xe</label>
					<input name="txttenxe" type="text" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Tên xe" value = "${xebean.getTenxe() }">
				</div>
				
				<div class="form-group">
					<label for="exampleInputEmail1">Số lượng</label>
					<input name="txtsoluong" type="text" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Nhập số lượng" value = "${xebean.getSoluong() }">
				</div>
				
				<div class="form-group">
					<label for="exampleInputEmail1">Giá</label>
					<input name="txtgia" type="text" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Nhập giá" value = "${xebean.getGia() }">
				</div>
			</div>
		
		<div class="col-6">
			<div class="form-group" >
				<label for="pwd">Thêm loại:</label>
				<div>
					<select  class="form-control" required name="maloai">
						<c:forEach items="${dsloai }" var="s">
							<c:if test="${xebean.getMaloai() eq s.getMaloai() }">
								<option value="${xebean.getMaloai()}" selected="selected" >
									${s.getTenloai() }
								</option>
							</c:if>
						</c:forEach>
						<c:forEach items="${dsloai }" var="s">
							<c:choose>
								<c:when test="${xebean.getMaloai() eq s.getMaloai() }">
									<option value="${xebean.getMaloai()}" hidden="">
										${s.getTenloai() }
									</option>
								</c:when>
								<c:otherwise>
									<option value="${s.getMaloai() }">
										${s.getTenloai() }
									</option>
								</c:otherwise>
							</c:choose>
						</c:forEach>
					</select>
				</div>
			</div>
			
			<div class="form-group">
				<label for="exampleInputEmail1">Ngày nhập</label>
				<input name="txtngaynhap" type="date" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Chọn ngày" value="${xebean.getNgayNhap()}">
			</div>
			
             <button type="submit" class="btn btn-primary" name ="btnSuaXe" value = "update">Sửa thông tin xe</button>
		</div>
		</div>
	</form>
</body>
</html>