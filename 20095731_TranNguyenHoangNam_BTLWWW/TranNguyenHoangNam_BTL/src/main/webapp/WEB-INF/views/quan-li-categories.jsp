<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>Danh Sách Categories</title>
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
		<div id="content">
			<h1 class="mt-5">Danh Sách Categories</h1>
			<table class="table  mt-4">
				<thead>
					<tr>
						<th>NameCategories</th>
						<th>Action</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="tempCategories" items="${categories}">
						<!-- construct an "update" link with categories id -->
						<c:url var="updateLink" value="/categories/showFormForUpdate">
							<c:param name="categoriesId" value="${tempCategories.idCate}" />
						</c:url>
						<tr>
							<td>${tempCategories.namecategories}</td>
							<th scope="col">
								<a class="btn btn-primary" href="${updateLink}">Cập nhật</a>
							</th>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<input type="button" value="Thêm Categories"
				onclick="window.location.href='showFormForAdd'; return false;"
				class="btn btn-primary" />
		</div>

	</div>

	<%@include file="/WEB-INF/views/footer.jsp"%>
</body>

</html>









