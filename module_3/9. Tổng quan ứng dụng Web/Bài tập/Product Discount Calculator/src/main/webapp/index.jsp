<%--
  Created by IntelliJ IDEA.
  User: Donal
  Date: 26/01/2022
  Time: 3:52 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/DiscountServlet" method="post">
    Product Description:
    <input type="text" name="Description"><br>
    List Price:
    <input type="text" name="Price"><br>
    Discount Percent:
    <input type="text" name="Percent"><br>
    <button type="submit">perform</button>
</form>
<h1>${Discount}</h1>
</body>
</html>
