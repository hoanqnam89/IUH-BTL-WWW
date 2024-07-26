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
</head>
<body>
	<%@include file="/WEB-INF/views/menu.jsp"%>
	<div class="container">
		<h1 class="mt-5">Danh Sách sản Phẩm</h1>
		<table class="table  mt-4">
			<thead>
				<tr>
					<th scope="col">ID</th>
					<th scope="col">Tên Sản Phẩm</th>
					<th scope="col">Size</th>
					<th scope="col">Số Lượng</th>
					<th scope="col">Tình trạng</th>
					<th scope="col" colspan="2">Thao Tác</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${allsp}" var="sp">
					<tr>
						<th scope="col">${sp.idProduct}</th>
						<th scope="col">${sp.nameProduct}</th>
						<th scope="col">${sp.size}</th>
						<th scope="col">${sp.soluong}</th>
						<c:if test="${sp.inStock == true}">
							<th scope="col">Còn Mở bán</th>
						</c:if>
						<c:if test="${sp.inStock == false}">
							<th scope="col">Không Được Mở Bán Nữa</th>
						</c:if>
						<th scope="col"><a class="btn btn-primary" href="/TranNguyenHoangNam_BTL/updateform?id=${sp.idProduct}" >Cập Nhập</a></th>
					</tr>
				</c:forEach>

			</tbody>
		</table>
		<a class="btn btn-primary" href="/TranNguyenHoangNam_BTL/addForm">Thêm Sản Phẩm</a>
		<nav aria-label="Page navigation">
			<ul class="pagination justify-content-center">
				<li class="page-item"><a class="page-link"
					href="/TranNguyenHoangNam_BTL/productController?num=${numprd-1 < 0 ? 0 : numprd-1}"
					aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
				</a></li>
				<li class="page-item"><a class="page-link"
					href="/TranNguyenHoangNam_BTL/productController?num=${numprd+1}">${numprd+1}</a></li>
				<li class="page-item"><a class="page-link"
					href="/TranNguyenHoangNam_BTL/productController?num=${numprd+2}">${numprd+2}</a></li>
				<li class="page-item"><a class="page-link"
					href="/TranNguyenHoangNam_BTL/productController?num=${numprd+3}">${numprd+3}</a></li>
				<li class="page-item"><a class="page-link"
					href="/TranNguyenHoangNam_BTL/productController?num=${numprd+4}">${numprd+4}</a></li>
				<!-- Add more page items as needed -->
				<li class="page-item"><a class="page-link"
					href="/TranNguyenHoangNam_BTL/productController?num=${numprd=numprd+1}" aria-label="Next">
						<span aria-hidden="true">&raquo;</span>
				</a></li>
			</ul>
		</nav>
	</div>
		<%@include file="/WEB-INF/views/footer.jsp"%>
</body>
</html>