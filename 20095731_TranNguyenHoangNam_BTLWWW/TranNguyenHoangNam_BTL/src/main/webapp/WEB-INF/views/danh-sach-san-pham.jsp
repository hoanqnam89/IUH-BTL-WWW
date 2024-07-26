<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Danh Sách Sản Phẩm</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL"
	crossorigin="anonymous"></script>
<script>
	// Function to show the modal and pass product details
	function showQuantityModal(productId, productName) {
		// Set the product details in the modal
		document.getElementById('productModalTitle').innerHTML = productName;
		document.getElementById('productIdInput').value = productId;

		// Show the modal
		$('#quantityModal').modal('show');
	}
</script>
</head>

<body>
	<%@include file="/WEB-INF/views/menu.jsp"%>
	<div class="container">
		<h1>Danh sách ${title}</h1>
		<div class="row">
			<!-- Thêm các sản phẩm khác ở đây -->
			<c:forEach items="${listSP}" var="sp">
				<div class="col-md-4 mb-4">
					<div class="card">
						<img src="/TranNguyenHoangNam_BTL/assets/${sp.getListImage().get(0)}"
							class="card-img-top" alt="Sản phẩm 1">
						<div class="card-body">
							<h5 class="card-title">${sp.getNameProduct()}</h5>
							<p class="card-text">${sp.getMotasp()}</p>
							<a href="/TranNguyenHoangNam_BTL/product?id=${sp.getIdProduct()}"
								class="btn btn-primary">Xem chi tiết</a> 
								<c:if test="${sp.isInStock() == true}">
								<a href="#" data-bs-toggle="modal" data-bs-target="#quantityModal" onclick="showQuantityModal('${sp.getIdProduct()}', '${sp.getNameProduct()}')" class="btn btn-primary">Thêm Giỏ hàng</a>
								</c:if>
								<c:if test="${sp.isInStock() == false}">
								<a href="#"  class="btn">Tạm Hết Hàng</a>
								</c:if>
						</div>
					</div>
				</div>
			</c:forEach>
		</div>
	</div>
	<br>
	<br>
	<br>
	<!-- Pagination -->
	<nav aria-label="Page navigation ">
		<ul class="pagination justify-content-center">
			<li class="page-item"><a class="page-link"
				href="/TranNguyenHoangNam_BTL/danhsachsanphamPT?num=${numprd-1 < 0 ? 0 : numprd-1}&gt=${gtsp}"
				aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
			</a></li>
			<li class="page-item"><a class="page-link"
				href="/TranNguyenHoangNam_BTL/danhsachsanphamPT?num=${numprd+1}&gt=${gtsp}">${numprd+1}</a></li>
			<li class="page-item"><a class="page-link"
				href="/TranNguyenHoangNam_BTL/danhsachsanphamPT?num=${numprd+2}&gt=${gtsp}">${numprd+2}</a></li>
			<li class="page-item"><a class="page-link"
				href="/TranNguyenHoangNam_BTL/danhsachsanphamPT?num=${numprd+3}&gt=${gtsp}">${numprd+3}</a></li>
			<li class="page-item"><a class="page-link"
				href="/TranNguyenHoangNam_BTL/danhsachsanphamPT?num=${numprd+4}&gt=${gtsp}">${numprd+4}</a></li>
			<!-- Add more page items as needed -->
			<li class="page-item"><a class="page-link"
				href="/TranNguyenHoangNam_BTL/danhsachsanphamPT?num=${numprd+1}&gt=${gtsp}"
				aria-label="Next"> <span aria-hidden="true">&raquo;</span>
			</a></li>
		</ul>
	</nav>
		<%@include file="/WEB-INF/views/footer.jsp"%>
	<div class="modal fade" id="quantityModal" tabindex="-1" role="dialog"
		aria-labelledby="quantityModalLabel" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="quantityModalLabel">
						Nhập số lượng cho sản phẩm <span id="productModalTitle"></span>
					</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
					<!-- Add a form to enter quantity -->
					<form action="/TranNguyenHoangNam_BTL/addCart1" method="get">
						<input type="hidden" name="id" id="productIdInput" value="">
						<div class="form-group">
							<label for="quantityInput">Số lượng:</label> <input type="number"
								class="form-control" id="quantityInput" name="quantity" required>
						</div>
						<br> <br>
						<button type="submit" class="btn btn-primary mt-10">Thêm
							vào giỏ hàng</button>
					</form>
				</div>
			</div>
		</div>
		<!-- Content below pagination goes here -->
		
</body>
</html>