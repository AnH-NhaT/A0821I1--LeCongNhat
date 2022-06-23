<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Danh sách khách hàng</title>
    <link rel="stylesheet" href="bootstrap4.6.0/css/bootstrap.css">
    <style>
        #title {
            text-align: center;
        }
        img{
            width: 50px;
            height: 50px;
        }
    </style>
</head>
<body>
<div class="container">
    <h1 id="title">Danh sách khách hàng</h1>
    <table class="table table-hover">
        <tr>
            <th>Tên</th>
            <th>Ngày sinh</th>
            <th>Địa chỉ</th>
            <th>Ảnh</th>
        </tr>
        <c:forEach items="${list}" var="list">
            <tr>
                <td>${list.name}</td>
                <td>${list.dateOfBirth}</td>
                <td>${list.address}</td>
                <td><img src="${list.image}"></td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>