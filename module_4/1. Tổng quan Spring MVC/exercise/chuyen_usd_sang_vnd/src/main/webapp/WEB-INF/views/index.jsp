<%--
  Created by IntelliJ IDEA.
  User: Asus
  Date: 11/03/2022
  Time: 8:20 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <form action="/changing" method="post">
    <label>USD: <input type="number" name="usd"></label><br>
    <input type="submit">
    <h3>VND: ${vnd}</h3>
  </form>
  </body>
</html>
