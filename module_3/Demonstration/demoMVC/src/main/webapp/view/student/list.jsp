<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 1/26/2022
  Time: 8:06 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="bootstrap4.6.0/css/bootstrap.css">
</head>
<body>
<h1>Student List</h1>

<a href="/student?action=add">Add</a>
<c:if test="${mess!=null}">
    <p>${mess}</p>
</c:if>
<div class="container">
<table class="table table-striped">
    <tr class="bg-dark text-white">
        <th>STT</th>
        <th>ID</th>
        <th>Name</th>
        <th>Gender</th>
        <th>Birthday</th>
        <th>Point</th>
        <th>Xếp loại</th>
        <th>Account</th>
        <th>ClassID</th>
        <th>Email</th>
        <th>Action</th>
    </tr>
    <c:forEach items="${studentList}" var="student" varStatus="status">
        <tr>
            <td>${status.count}</td>
            <td> ${student.id}</td>
            <td> ${student.name}</td>
            <c:if test="${student.gender}">
                <td>Nam</td>
            </c:if>
            <c:if test="${!student.gender}">
                <td>Nữ</td>
            </c:if>
            <td> ${student.birthday}</td>
            <td> ${student.point}</td>

            <c:choose>
                <c:when test="${student.point>=8}">
                    <td>Gỏi</td>
                </c:when>
                <c:when test="${student.point>=7}">
                    <td>Khá</td>
                </c:when>
                <c:when test="${student.point>=5}">
                    <td>Trung bình</td>
                </c:when>
                <c:otherwise>
                    <td>Yếu</td>
                </c:otherwise>
            </c:choose>

            <td> ${student.account}</td>
            <td> ${student.classId}</td>
<%--            <c:forEach items="${classList}" var="studentClass">--%>
<%--                <c:if test="${studentClass.id==student.classId}">--%>
<%--                    <td> ${studentClass.className}</td>--%>
<%--                </c:if>--%>
<%--            </c:forEach>--%>

            <td> <c:out value="${student.email}"></c:out></td>
            <td> <button class="btn btn-outline-danger">Xóa</button></td>
        </tr>
    </c:forEach>
</div>
</table>
</body>
</html>
