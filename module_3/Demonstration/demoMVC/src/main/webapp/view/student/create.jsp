<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 2/11/2022
  Time: 4:21 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/student?action=add" method="post">
<%--    <input type="text" name="id" placeholder="nhâp id">--%>
    <input type="text" name="name" placeholder="nhâp tên"><br>
    <input type="radio" name="gender" value="true"> nam
    <input type="radio" name="gender" value="false">nữ<br>
    <input type="date" name="birthday"><br>
    <input type="text" name="point" placeholder="nhập điểm"><br>
<%--    <input type="text" name="account" placeholder="nhập account">--%>
    <input type="text" name="classId" placeholder="nhập class id"><br>
    <input type="text" name="email" placeholder="nhập email"><br>
    <button type="submit">Submit</button>
</form>
</body>
</html>
