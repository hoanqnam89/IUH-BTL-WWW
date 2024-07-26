<%@page import="java.util.List"%>
<%@page import="trannguyenhoangnam.btl.Entity.GioHang"%>
<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
	integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8sh+WyWtg+yeN1giE5ITeRjI6U5qyJdj4R3hK"
	crossorigin="anonymous">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>

</head>
<body>
		<%@include file="/WEB-INF/views/menu.jsp"%>
	<div class="container">
		<h1>Giỏ hàng</h1>
		<table class="table">
			<thead>
				<tr>
					<th scope="col">Sản phẩm</th>
					<th scope="col">Giá</th>
					<th scope="col">Số lượng</th>
					<th scope="col">Tổng cộng</th>
					<th scope="col"></th>
				</tr>
			</thead>
			
			<tbody>

				<c:forEach items="${cart}" var="item" varStatus="loopStatus">
					<tr>
						<th scope="row">${item.getProduct().getNameProduct()}</th>
						<td>${item.getProduct().getPrice()}</td>
						<td><input type="number" value="${item.getSoluong()}" min="1"></td>
						<td>${item.getProduct().getPrice() * item.getSoluong()}</td>
						<td><a class="btn btn-danger"
							href="/TranNguyenHoangNam_BTL/cart/remove?id=${item.getProduct().getIdProduct()}">Xóa</a></td>
					</tr>
				</c:forEach>



				<!-- Thêm các sản phẩm khác ở đây -->
			</tbody>
		</table>
		
<h6 style="color: red;font-weight: bold;">${errquantity}</h6>
		<%
		double total = 0;
		List<GioHang> ls = (List<GioHang>) session.getAttribute("cart");
		if(ls==null){
			out.println("0");
		}
		else{	
		for(GioHang g : ls){
				total += g.getProduct().getPrice() * g.getSoluong();
			}
		}  
		out.println("<h4>Tổng Số Tiền Là: "+total+"</h4>");
		%>
		<c:if test="${loginFailed == false}">
			<h6 style="color: red;font-weight: bold;">Bạn phải đăng Nhập Trước Khi Thanh Toán</h6>
		</c:if>
	
			
	
		<div class="text-right">
			<h4>${total}</h4>
			<a class="btn btn-primary"  href="/TranNguyenHoangNam_BTL/thanhtoan">Thanh toán</a>
		</div>
	</div>
	
</body>
</html>
