<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
footer {
    background-color: #f8f8f8;
    padding: 20px;
    text-align: center;
}

/* Contact Info Styles */
.contact-info, .contact-info2 {
    display: inline-block;
    margin: 0 20px;
    text-align: left;
}

h3 {
    color: #333;
    margin-bottom: 10px;
}

p {
    margin: 5px 0;
}

.contact-info p {
    display: inline-block;
}

.contact-info2 p {
    margin: 0;
}

.contact-info p, .contact-info2 p {
    color: #555;
}

.contact-info p i, .contact-info2 p i {
    color: #3498db;
    font-weight: bold;
}

/* Team Members Styles */
.contact-info2 p {
    margin: 10px 0;
}

.contact-info2 .contact-info {
    display: inline-block;
    margin: 0 10px;
}

.contact-info2 p b, .contact-info p b {
    color: #333;
    font-weight: bold;
}

.contact-info2 p i, .contact-info p i {
    color: #555;
}
</style>
</head>
<body>

</body>
<!-- footer.jsp -->

<footer>
    <div class="contact-info">
        <h3>Liên hệ hỗ trợ</h3>
        <p>Số điện thoại:</p> <p style="color: blue; font-weight: bold;"><i>0123456789	.</i> </p>
        <p>Email:</p> <p style="color: blue; font-weight: bold;"><i>example@email.com		.</i></p>
        <p>Địa chỉ:</p> <p style="color: blue; font-weight: bold;"><i>123 Đường ABC, Thành phố XYZ	.</i> </p>
    </div>
</footer>

</html>