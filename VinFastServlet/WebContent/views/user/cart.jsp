<%@page import="bean.GioHangBean"%>
<%@page import="bo.GioHangBo"%>
<%@page import="bean.Loaibean"%>
<%@page import="bean.Xebean"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
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
    	ArrayList<Xebean> dsxe = (ArrayList<Xebean>)request.getAttribute("dsxe");
		ArrayList<Loaibean> dsloai = (ArrayList<Loaibean>)request.getAttribute("dsloai");
	%>
	<table style="margin-top: 130px " class="container table table-hover">
		<tr>
			<td valign="top" width="50%">
				<table class="table table-hover">
			 		<label> GIỎ HÀNG CỦA BẠN </label>  
			 		<%if (session.getAttribute("ThongBaoXacNhan")!=null)
							{
								out.print("<script>alert('"+session.getAttribute("ThongBaoXacNhan")+"');</script>" );
	       	   					session.removeAttribute("ThongBaoXacNhan");
							}%>
						 <%if(session.getAttribute("gh")!=null)
						{ 
							GioHangBo gh1=(GioHangBo)session.getAttribute("gh");
								for(GioHangBean g:gh1.ds){%>
									<form action="GioHangController?mxe=<%=g.getMaXe()%>&sl=<%=g.getSoLuong()%>" method="post" >
										<thead>
											<td>	Mã Xe  </td>
											<td>	Tên Xe </td>
											<td>	Số Lượng </td>
											<td>			 </td>
											<td>	Đơn giá </td>
											<td>	Thành tiền </td>
											<td>	Hành động </td>
										</thead>
										
										<tr>
											<td>	<%=g.getMaXe() %>  </td>
											<td>	<%=g.getTenXe() %> </td>
											<td>	<%=g.getSoLuong() %> </td>
											<td> 
												<input name="txtsl" type="number">
												<button name="btnSua" type="submit" class="btn-link btn btn-warning" value="Sua">
													Sửa
												</button>
											</td>
											<td>	<fmt:formatNumber type="NUMBER" value="<%=g.getGia() %>"/>     </td>
											<td>	<fmt:formatNumber type="NUMBER" value="<%=g.getThanhTien() %>"/> </td>
											<td> 
												<button name="btnXoa" type="submit" class="btn-link btn btn-danger" value="Xoa">
													Xóa
												</button>
											</td>
										</tr>
									</form>
							<%}%>
								</table>
							<label> Tổng Tiền: <fmt:formatNumber type="NUMBER" value="<%= gh1.TongTien() %>"/> VNĐ</label> <hr style="margin-top:-2px">
							<form action="GioHangController" style="margin-left: 650px;margin-top: -5px">
								<button name="btnTraAll" type="submit"  value="TraAll" style="margin-left: 10px;border: 3px solid #A5AAAD;border-radius: 5px" class="btn btn-secondary">Trả toàn bộ</button>
								<button name="btnMuaHang" type="submit"  value="MuaHang" style="margin-left: 10px;border: 3px solid #A5AAAD;border-radius: 5px" class="btn btn-primary">Tiếp tục mua hàng</button>
								<button name="btnThanhToan" type="submit"  value="Thanhtoan" style="margin-left: 10px;border: 3px solid #A5AAAD;border-radius: 5px" class="btn btn-success">Thanh toán</button>
							</form> 
						</td>
				</tr>
			</table>
							
				<%} else {%>
				<div>
					<img style="height: 300px; margin-left: 350px" src="img/emptyCart.jpg" /> <hr>
					<form action="GioHangController" style=" margin-left: 350px" method="post">
						<button name="btnMua" type="submit"  value="Mua" style="margin-left: 10px;border: 3px solid #A5AAAD;border-radius: 5px" class="btn btn-success">Chọn mua hàng</button>
					</form>
				</div>
				<%} %> 
			
 			
	
<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>