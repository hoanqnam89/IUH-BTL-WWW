<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
	integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL"
	crossorigin="anonymous"></script>
</head>
<body>
<%@include file="/WEB-INF/views/menu.jsp"%>
	<div class="card mb-3">
		<c:forEach 	items="${order}" var="item">
			<div class="card-body">
				<h5 class="card-title">Chi Tiết Hóa Đơn</h5>
				<p class="card-text">Số lượng: ${item.quantity}</p>
				<p class="card-text">Giá: ${item.price}</p>
			
				<h6>Chi tiết sản phẩm:</h6>
				<p>Sản Phẩm: ${item.getProducId().nameProduct}</p>
				<p>Mô tả:  ${item.getProducId().motasp}</p>
				<!-- Thêm chi tiết sản phẩm khác nếu cần -->

				<!-- Bạn cũng có thể hiển thị hình ảnh sản phẩm ở đây sử dụng một vòng lặp -->
				<c:forEach items=" ${item.getProducId().listImage.get(0)}" var="pathImg">
					<img src="/TranNguyenHoangNam_BTL/assets/${pathImg}" alt="Hình ảnh sản phẩm" class="img-thumbnail">
				</c:forEach> 
				
				<hr>
			</div>
	</div>
	</c:forEach>
		<%@include file="/WEB-INF/views/footer.jsp"%>
</body>
</html>