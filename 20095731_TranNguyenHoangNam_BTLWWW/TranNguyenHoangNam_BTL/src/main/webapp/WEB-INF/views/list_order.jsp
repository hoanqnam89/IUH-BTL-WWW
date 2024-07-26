<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>List Orders</title>
    <style>
        table {
            border-collapse: collapse;
            width: 100%;
        }

        th, td {
            border: 1px solid #dddddd;
            text-align: left;
            padding: 8px;
        }

        th {
            background-color: #f2f2f2;
        }
    </style>
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
    <h2>List of Orders</h2>

    <table>
        <thead>
            <tr>
                <th>Order ID</th>
                <th>Order Date</th>
                <th>Chức năng</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="order" items="${orders}">
                <tr>
                    <td>${order.id}</td>
                    <td>${order.orderDate}</td>
                    <td>
                    	<a href="/TranNguyenHoangNam_BTL/order/getByOrderID?id=${order.id}">xem chi tiết hóa đơn</a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    	<%-- <%@include file="/WEB-INF/views/footer.jsp"%> --%>
<!--     <a href="/WWW_BTL/order/getByUserID" class="btn btn-primary">Xem Order của user 1</a>
    <a href="/WWW_BTL/order/getByID" class="btn btn-primary">Xem Order có id = 1</a> -->
</body>
</html>
