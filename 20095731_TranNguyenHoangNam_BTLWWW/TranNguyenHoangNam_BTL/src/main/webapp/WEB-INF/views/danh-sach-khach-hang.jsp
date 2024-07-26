<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Danh Sách Khách Hàng</title>
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
		<h1 class="mt-5">Danh Sách Khách Hàng</h1>
		<table class="table table-striped mt-4">
			<thead>
				<tr>
					<th scope="col">Họ tên</th>
					<th scope="col">Số điện thoại</th>
					<th scope="col">tài Khoản</th>
					<th scope="col">Mật Khẩu</th>
					<th scope="col">Vai trò</th>
					<th scope="col">Xóa</th>
					<th scope="col">Sửa</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="tempUser" items="${users}">
					<c:url var="deleteLink" value="/admin/delete">
						<c:param name="id" value="${tempUser.id}" />
					</c:url>
						<c:url var="updateLink" value="/admin/showFormForUpdate">
						<c:param name="id" value="${tempUser.id}" />
					</c:url>
					<tr> 
						<td>${tempUser.hoTen}</td>
						<td>${tempUser.sdt}</td>
						<td>${tempUser.username}</td>
						<td>${tempUser.password}</td>
						<td>${tempUser.role}</td>
						<td><a href="${deleteLink}"
							onclick="if (!(confirm('Are you sure you want to delete this customer?'))) return false">Xóa</a>
						</td>
						<td><a href="${updateLink}">Sửa</a>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<%@include file="/WEB-INF/views/footer.jsp"%>
</body>
</html>