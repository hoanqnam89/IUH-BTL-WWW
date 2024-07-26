<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta charset="UTF-8">
<title>Thêm Sản Phẩm</title>
<!-- Bootstrap CSS -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL"
	crossorigin="anonymous"></script>

<style>
body {
	background-color: #f8f9fa;
}

.container {
	background-color: #ffffff;
	border-radius: 8px;
	box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
	padding: 30px;
	margin-top: 50px;
}

h2 {
	text-align: center;
	margin-bottom: 30px;
	color: #007bff;
}

label {
	font-weight: bold;
	color: #555;
}

input[type="text"], input[type="number"], select, textarea {
	width: 100%;
	padding: 10px;
	margin-bottom: 20px;
	border: 1px solid #ced4da;
	border-radius: 4px;
	box-sizing: border-box;
}

input[type="checkbox"] {
	margin-top: 8px;
}

button {
	width: 100%;
	padding: 12px;
	background-color: #007bff;
	border: 1px solid #007bff;
	border-radius: 4px;
	color: #fff;
	cursor: pointer;
}

button:hover {
	background-color: #0056b3;
	border-color: #0056b3;
}

.red {
	color: red
}
</style>
</head>

<body>
	<%@include file="/WEB-INF/views/menu.jsp"%>
	<div class="container mt-4">
		<h2>Thêm Sản Phẩm</h2>
		<form:form action="/TranNguyenHoangNam_BTL/addForm/add" modelAttribute="product"
			enctype="multipart/form-data">
			<!-- ID sẽ được tạo tự động, không cần nhập -->
			<div class="form-group">
				<label for="nameProduct">Tên Sản Phẩm:</label>
				<form:input path="nameProduct" cssClass="form-control " />
					<form:errors path="nameProduct" cssClass="red"/>
			</div>
		

			<div class="form-group">
				<label for="categoryId">Danh Mục:</label> <select name="cateid">
					<c:forEach items="${cate}" var="item">
						<option value="${item.getIdCate()}"
							label="${item.getNamecategories()}">
					</c:forEach>
				</select>
			</div>



			<div class="form-group">
				<label for="motasp">Mô Tả:</label>
				<form:textarea cssClass="form-control" path="motasp" />
				<form:errors path="motasp" cssClass="red"/>
			</div>

			<div class="form-group">
				<label for="price">Giá:</label>
				<form:input path="price" cssClass="form-control" />
				<form:errors path="price" cssClass="form-control" />
			</div>
			<div class="form-group">
				<label for="size">Kích Thước:</label> 
	<!-- 			<input type="text"class="form-control" id="size" name="size"> -->
				<form:input path="size" cssClass="form-control " />
				<form:errors path="size" cssClass="red " />
				
			</div>

			<div class="form-group">
				<label for="soluong">Số Lượng:</label> 
				<input type="number" class="form-control" id="soluong" name="soluong"  inputmode="numeric" pattern="^[1-9]*">
			</div>
			<div class="form-group">
				<label for="soluong">ảnh sản phẩm:</label> <input type="file"
					class="form-control" id="anhsp" name="anhsp" multiple="multiple"
					required="required" accept="image/png, image/jpeg, image/jpgg">
			</div>

			<button type="submit" class="btn btn-primary mt-5">Thêm Sản
				Phẩm</button>
		</form:form>
	</div>
	<%@include file="/WEB-INF/views/footer.jsp"%>
	<!-- Bootstrap JS and dependencies -->
	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
		integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"
		integrity="sha384-ZsTI1nBdHxN7JY6j4U4PMi50rLJo+lYuaOLXij5qE2tK/KbFYY8dHEBfuTGf9cJo"
		crossorigin="anonymous"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"
		integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8sh+WyWtg+yeN1giE5ITeRjI6U5qyJdj4R3hK"
		crossorigin="anonymous"></script>
</body>
</html>
