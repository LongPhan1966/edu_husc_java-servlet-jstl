<%@page import="bean.KhachHangBean"%>
<%@page import="bean.GioHangBean"%>
<%@page import="bo.GioHangBo"%>
<%@page import="bean.Loaibean"%>
<%@page import="bean.Xebean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="bo.Xebo"%>
<%@page import="bo.Loaibo"%>
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
		Loaibo loai = new Loaibo();
		Xebo xe = new Xebo();
		ArrayList<Xebean> dsxe = xe.getXe();
		ArrayList<Loaibean> dsloai = loai.getloai();
		String ml=request.getParameter("ml");
		String key=request.getParameter("key");
		if (ml!=null)
			dsxe=xe.TimMaLoai(ml);
		else
			if (key != null)
				dsxe=xe.Tim(key);
	%>
	<table style="margin-top: 150px" class="table table-hover">
			<td valign="top" width="50%">
				<table class="table table-hover">
						<% if (kh!=null) { %>
							<label> GIỎ HÀNG CỦA BẠN </label>  
							<% if(session.getAttribute("gh")!=null) {%>
			 				<tr>
											<td><label> Mã Sách</label> </td>
											<td>	<label> Tên Sách</label> </td>
											<td>	<label> Số lượng</label> </td>
											<td>	<label> Giá</label>     </td>
											<td>	<label> Thành Tiền</label> </td>
										</tr>
						<%
							GioHangBo gh1=(GioHangBo)session.getAttribute("gh");
								for(GioHangBean g:gh1.ds){%>
										<tr>
											<td>	<%=g.getMaXe() %>  </td>
											<td>	<%=g.getTenXe() %> </td>
											<td>	<%=g.getSoLuong() %> </td>
											<td>	<%=g.getGia() %>     </td>
											<td>	<%=g.getThanhTien() %></td>
										</tr>
							<%}%>
								</table>
							<label> Tổng Tiền: <%= gh1.TongTien() %> VNĐ</label> <hr style="margin-top:-2px">
							<form action="ThanhToanController" style="margin-left: 250px;margin-top: -5px">
								<button name="btnXacNhan" type="submit"  value="XacNhan" style="margin-left: 10px;border: 3px solid #A5AAAD;border-radius: 5px">Xác nhận thanh toán</button>
							</form> 
							<%}else{ %>
								<table class="table table-hover">
								<label>Giỏ hàng đang trống</label> <hr>
									<form action="GioHangController" style="margin-left: 250px" method="post">
										<button name="btnMua" type="submit"  value="Mua" style="margin-left: 10px;border: 3px solid #A5AAAD;border-radius: 5px">Chọn mua hàng</button>
								</form>
								</table> 
							<%} %>
				<%} else {%>
				<div style="margin-left: 450px" class="">
						<img src="img/login.jpg" /><br>
						<label class="badge badge-pill badge-warning" style="margin: 20px 0 20px 0"> BẠN CẦN ĐĂNG NHẬP ĐỂ THANH TOÁN</label>  
				</div>
				<%} %> 
 			</td>
		</tr>
	</table>
<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>