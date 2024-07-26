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
<title>Đăng Nhập</title>
<!-- Add necessary CSS and JavaScript references here -->
<style>
.red{
color: red;
}
</style>

</head>
<body>
	
	<%@include file="/WEB-INF/views/menu.jsp"%>
	<%-- <div class="container">
		<h1 class="mt-5">Đăng nhập</h1>
		<form:form modelAttribute="user" method="post" action="/TranNguyenHoangNam_BTL/user/login">
			<div class="form-group">
				<form:input class="form-control" path="username"
					placeholder="Tên người dùng" />
			</div>
			<div class="form-group">
				<form:input class="form-control" path="password"
					placeholder="Mật khẩu" />
			</div>
			<button type="submit" class="btn btn-primary">Đăng nhập</button>
		</form:form>
	</div> --%>
	 <div class="container mt-5">
    <div class="row justify-content-center">
      <div class="col-md-6">
        <div class="card shadow-lg">
          <div class="card-header bg-primary text-white text-center">
            <h3 class="mb-0"><i class="fas fa-user"></i> SQA Xin Chào</h3>
          </div>
          <div class="card-body">
           <form:form modelAttribute="user" method="post" action="/TranNguyenHoangNam_BTL/user/login">
              <div class="form-group">
                <label for="username"><i class="fas fa-user"></i> Username:</label>
              	<form:input class="form-control" path="username"
					placeholder="Tên người dùng"/>
						<form:errors cssClass="red" path="username"/>
              </div>
              <div class="form-group">
                <label for="password"><i class="fas fa-lock"></i> Password:</label>
                <form:input class="form-control" path="password" placeholder="Mật khẩu" />
				<form:errors cssClass="red" path="password"/>
              </div>
              <button type="submit" class="btn btn-primary btn-block">Login</button>
            </form:form>
          </div>
          <div class="card-footer text-center">
            <small>Don't have an account? <a href="#">Sign up</a></small>
          </div>
        </div>
      </div>
    </div>
  </div>
		<%-- <%@include file="/WEB-INF/views/footer.jsp"%> --%>
</body>
</html>
