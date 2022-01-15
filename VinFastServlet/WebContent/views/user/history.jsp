<%@page import="bean.Loaibean"%>
<%@page import="bean.Xebean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="bean.KhachHangBean"%>
<%@page import="bean.LichSuMuaHangBean"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="css/main.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</head>
<body>
<jsp:include page="Menu.jsp"></jsp:include>

	<%
	  	request.setCharacterEncoding("utf-8");
    	response.setCharacterEncoding("utf-8");
    	KhachHangBean kh= (KhachHangBean)session.getAttribute("kh");
    	ArrayList<Xebean> dssach = (ArrayList<Xebean>)request.getAttribute("dsxe");
		ArrayList<Loaibean> dsloai = (ArrayList<Loaibean>)request.getAttribute("dsloai");
		ArrayList<LichSuMuaHangBean> dslichsu=(ArrayList<LichSuMuaHangBean>)request.getAttribute("lsmh");
	%>

	<table style="margin-top: 100px " class="table table-hover">
		<tr>
			<td valign="top" width="50%">
				<table class="table table-hover">
				<% if (kh!=null) { %>
			 		<label> LỊCH SỬ MUA HÀNG CỦA BẠN </label>  
								<tr>
											<td><label>Mã hóa đơn</label> </td>
											<td><label>Tên Sách</label> </td>
											<td><label> Giá</label>     </td>
											<td><label> Số lượng</label> </td>
											<td><label>	Ngày mua</label> </td>
											<td><label>	Trạng thái</label> </td>
								</tr>
						<%
								for(LichSuMuaHangBean ls:dslichsu){%>
										<tr>
											<td>	<%=ls.getMaHD() %>  </td>
											<td>	<%=ls.getTenxe() %> </td>
											<td>	<%=ls.getGiaxe() %>     </td>
											<td>	<%=ls.getSoluongmua() %></td>
											<td>	<%=ls.getNgaymua() %> </td>
											<% if(ls.getDamua()==true) {%>
											<td><p class="badge badge-success">Đã thanh toán</p></td>
											<%}else{ %>
											<td> <p class="badge badge-warning">Đang thanh toán</p></td>
											<%} %>
										</tr>
							<%}%> 
						</td> 
					</tr>
				</table>
				</td> 
			</tr>
		</table>
				<%} else {%>
					<div style="margin-left: 450px" class="container">
						<img src="img/login.jpg" /><br>
						<label class="badge badge-pill badge-warning" style="margin: 20px 0 20px 0"> BẠN CẦN ĐĂNG NHẬP ĐỂ XEM LỊCH SỬ MUA HÀNG</label>  
					</div>
				<%} %> 
 			
<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>