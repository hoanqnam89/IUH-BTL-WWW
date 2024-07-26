<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
	integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL"
	crossorigin="anonymous"></script>
<title>Đăng Ký Tài Khoản</title>
<!-- Add necessary CSS and JavaScript references here -->
<script>
	document.addEventListener('DOMContentLoaded', function() {
		var password = document.getElementById("password");
		var confirmPassword = document.getElementById("confirmPassword");
		var form = document.querySelector("form");

		form.addEventListener('submit', function(event) {
			if (password.value !== confirmPassword.value) {
				alert("Mật khẩu và xác nhận mật khẩu không khớp nhau");
				event.preventDefault(); // Ngăn chặn gửi form nếu mật khẩu không khớp
			}
		});
	});
</script>
<style type="text/css">
.red {
	color: red
}
</style>
</head>
<body>
	<% if (session.getAttribute("registrationError") != null) { %>
    <div class="alert alert-danger">
        <%= session.getAttribute("registrationError") %>
    </div>
    <%-- Xóa thông báo lỗi sau khi đã hiển thị --%>
    <% session.removeAttribute("registrationError"); %>
<% } %>
	<%@include file="/WEB-INF/views/menu.jsp"%>
	<div class="container">
		<h1 class="mt-5">Đăng ký tài khoản</h1>
		<form:form modelAttribute="user" method="post"  action="saveUser">
			<div class="form-group">
				<form:input class="form-control" path="username"
					placeholder="Tên người dùng" />
					<form:errors class="red" path="username"
					 />
			</div>
			<br>
			<div class="form-group">
				<form:input class="form-control" path="hoTen"
					placeholder="Họ và tên" />
					<form:errors class="red" path="hoTen"
					 />
					
			</div>
			<br>
			<div class="form-group">
				<form:input class="form-control" path="sdt"
					placeholder="Số điện thoại" />
					<form:errors class="red" path="sdt"
					 />
			</div>
			<br>
			<div class="form-group">
				<form:input class="form-control" path="password" id="password"
					placeholder="Mật khẩu" type="password" />
					<form:errors class="red" path="password"
					 />
			</div>
			<br>
			<div class="form-group">
				<form:input class="form-control" path="" id="confirmPassword"
					placeholder="Xác nhận mật khẩu" type="password" />
					<form:errors class="" path="password"
					 />
			</div>
			<br>
			<button type="submit" class="btn btn-primary">Đăng ký</button>
		</form:form>


	</div>
</body>
</html>
