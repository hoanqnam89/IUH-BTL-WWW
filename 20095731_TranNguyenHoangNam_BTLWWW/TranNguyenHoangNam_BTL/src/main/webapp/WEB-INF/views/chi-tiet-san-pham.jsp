<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${product.nameProduct}</title>
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
		<h1>Chi tiết sản phẩm</h1>
		<div class="row">
			<div class="col-md-6">
				<img style="width: 100%"
					src="/TranNguyenHoangNam_BTL/assets/${product.getListImage().get(0)}"
					alt="Sản phẩm 1">
				<div>
					<div class="row">
						<c:forEach items="${product.getListImage()}" var="item">
							<div class="col-md-2">
								<img style="width: 100%" src="/TranNguyenHoangNam_BTL/assets/${item}"
									alt="Sản phẩm 1">
							</div>
						</c:forEach>
					</div>
				</div>
			</div>
			<div class="col-md-6">
				<h2>${product.nameProduct}</h2>
				<p>${product.motasp}</p>
				<p>Giá Tiền: ${product.price}</p>
				<p>Size: ${product.size}</p>
				<p>Tin Về Sản Phẩm: ${product.motasp}</p>
				<c:if test="${product.inStock == true}">
					<p style="color:green">Còn hàng</p>
				</c:if>
				<c:if test="${product.inStock == false}">
					<p style="color:red">Hết hàng</p>
				</c:if>
				<a href="#" data-bs-toggle="modal" data-bs-target="#quantityModal" onclick="showQuantityModal('${product.getIdProduct()}', '${product.getNameProduct()}')" class="btn btn-primary">Mua Ngay</a>
			</div>
		</div>
	</div>
<div class="modal fade" id="quantityModal" tabindex="-1" role="dialog" aria-labelledby="quantityModalLabel" aria-hidden="true">
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
						<form action="/TranNguyenHoangNam_BTL/addCart" method="get">
							<input type="hidden" name="id" id="productIdInput" value="">
							<div class="form-group">
								<label for="quantityInput">Số lượng:</label> <input
									type="number" class="form-control" id="quantityInput"
									name="quantity" required>
							</div>
							<br> <br>
							<button type="submit" class="btn btn-primary mt-10">Thêm
								vào giỏ hàng</button>
						</form>
					</div>
				</div>
			</div>
</div>
	<br>
	<br>
		 <%@include file="/WEB-INF/views/footer.jsp"%> 
</body>
</html>