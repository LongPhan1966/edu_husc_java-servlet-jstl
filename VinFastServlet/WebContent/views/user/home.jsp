<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Home Users</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<link rel="stylesheet" type="text/css" href="css/main.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css" integrity="sha512-Fo3rlrZj/k7ujTnHg4CGR2D7kSs0v4LLanw2qksYuRlEzO+tcaEPQogQ0KaoGN26/zrn20ImR1DfuLWnOo7aBA==" crossorigin="anonymous" referrerpolicy="no-referrer" />
</head>
<body>
<jsp:include page="Menu.jsp"></jsp:include>
	<!--Carousel Wrapper-->
  <div id="carousel-example-1z" class="carousel-custom carousel slide carousel-fade pt-4" data-ride="carousel">

    <!--Indicators-->
    <ol class="carousel-indicators">
      <li data-target="#carousel-example-1z" data-slide-to="0" class="active"></li>
      <li data-target="#carousel-example-1z" data-slide-to="1"></li>
      <li data-target="#carousel-example-1z" data-slide-to="2"></li>
    </ol>
    <!--/.Indicators-->

    <!--Slides-->
    <div class="container carousel-inner" role="listbox">

      <!--First slide-->
      <div class="carousel-item active">
	    <img alt="" src="img/Slider-post1.jpg" class="img-banner">
        
      </div>
      <!--/First slide-->

      <!--Second slide-->
      <div class="carousel-item">
        <img alt="" src="img/slider-post4.jpg" class="img-banner">
      </div>
      <!--/Second slide-->

      <!--Third slide-->
      <div class="carousel-item">
       <img alt="" src="img/slider-post2.jpg" class="img-banner">
      </div>
      <!--/Third slide-->

    </div>
    <!--/.Slides-->

    <!--Controls-->
    <a class="carousel-control-prev" href="#carousel-example-1z" role="button" data-slide="prev">
      <span class="carousel-control-prev-icon" aria-hidden="true"></span>
      <span class="sr-only">Previous</span>
    </a>
    <a class="carousel-control-next" href="#carousel-example-1z" role="button" data-slide="next">
      <span class="carousel-control-next-icon" aria-hidden="true"></span>
      <span class="sr-only">Next</span>
    </a>
    <!--/.Controls-->

  </div>
  <!--/.Carousel Wrapper-->

  <!--Main layout-->
  <main>
    <div class="container">

      <!--Navbar-->
      <nav class="navbar navbar-expand-lg mt-3 mb-5">

        <!-- Navbar brand -->
        <span class="navbar-brand">Categories:</span>

        <!-- Collapse button -->
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#basicExampleNav" aria-controls="basicExampleNav"
          aria-expanded="false" aria-label="Toggle navigation">
          <span class="navbar-toggler-icon"></span>
        </button>

        <!-- Collapsible content -->
        <div class="nav-category collapse navbar-collapse" id="basicExampleNav">

          <!-- Links -->
          <ul class="navbar-nav mr-auto">
            <li class="nav-item active">
              <a class="nav-link" href="HomeController">All
                <span class="sr-only">(current)</span>
              </a>
            </li>
            <c:forEach items = "${ListLoai}" var= "o">
				<li class="nav-item">
				  <a class="nav-link" href="LoaiHangController?maloai=${o.maloai }">
				  	${o.tenloai}
				   </a>
				</li>
            </c:forEach>
	           
            

          </ul>
          <!-- Links -->
          <form action="TimKiemController" class="form-inline">
            <div class="md-form my-0">
              <input name="key" class="form-control mr-sm-2" type="text" placeholder="Tìm kiếm sản phẩm" aria-label="Search">
              <button class="btn btn-primary" type="submit">Tìm kiếm</button>
            </div>
          </form>
        </div>
        <!-- Collapsible content -->

      </nav>
      <!--/.Navbar-->

      <!--Section: Products v.3-->
      <section class="text-center mb-4">
	
		
		<!--Grid row-->
		<div class="row wow fadeIn">
		<c:forEach items="${ListXe}" var="i">
		  <!--Grid column-->
		  <div class="col-lg-4 col-md-6 mb-3">
			
		    <!--Card-->
		    <div class="card">
		
		      <!--Card image-->
		      <div class="view overlay">
		      <img src="${i.anh}" class="card-img-top" alt="">
		        
		        <a>
		          <div class="mask rgba-white-slight"></div>
		        </a>
		      </div>
		      <!--Card image-->
		
		      <!--Card content-->
		      <div class="card-body text-center">
		        <!--Category & Title-->
		        <h5><strong><a href="" class="dark-grey-text">${i.tenxe }</a></strong></h5>
		
		        <h6 class="blue-text"><fmt:formatNumber type="NUMBER" value="${i.gia}"/>vnđ</h6>
		      </div>
		    </div>
		    <!--Action-->
			<ul style="margin-left: 70px" class="d-flex justify-content-between ">
				<!-- <li class="nav-item mgr-15 mgt-15px">
		            <a href="" class="btn btn-info" target="_blank">Xem Nhanh</a>
	           	</li> -->
	          	<li class="nav-item mgt-15px">
		            <a href="GioHangController?maxe=${i.getMaxe()}&tenxe=${i.getTenxe()}&maloai=${i.getMaloai()}&anh=${i.getAnh()}&gia=${i.getGia()}&soluong=${i.getSoluong()}" class="btn btn-primary">Thêm Vào Giỏ</a>
	          	</li>
			</ul>
		   
		    
		  </div>
		   </c:forEach>
		  <!--Grid column-->
		
		</div>
		<!--Grid row-->
		
		
        

      </section>
      <!--Section: Products v.3-->

      <!--Pagination-->
      <nav class="d-flex justify-content-center wow fadeIn">
        <ul class="pagination pg-blue">

          <!--Arrow left-->
          <li class="page-item disabled">
            <a class="page-link" href="#" aria-label="Previous">
              <span aria-hidden="true">&laquo;</span>
              <span class="sr-only">Previous</span>
            </a>
          </li>

          <li class="page-item active">
            <a class="page-link" href="#">1
              <span class="sr-only">(current)</span>
            </a>
          </li>
          <li class="page-item">
            <a class="page-link" href="#">2</a>
          </li>
          <li class="page-item">
            <a class="page-link" href="#">3</a>
          </li>
          <li class="page-item">
            <a class="page-link" href="#">4</a>
          </li>
          <li class="page-item">
            <a class="page-link" href="#">5</a>
          </li>

          <li class="page-item">
            <a class="page-link" href="#" aria-label="Next">
              <span aria-hidden="true">&raquo;</span>
              <span class="sr-only">Next</span>
            </a>
          </li>
        </ul>
      </nav>
      <!--Pagination-->

    </div>
  </main>
  <!--Main layout-->
<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>