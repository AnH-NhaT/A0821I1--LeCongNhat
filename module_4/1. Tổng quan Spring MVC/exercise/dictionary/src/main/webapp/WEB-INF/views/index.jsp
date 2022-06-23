<%--
  Created by IntelliJ IDEA.
  User: Asus
  Date: 11/03/2022
  Time: 8:53 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <form action="/finding" method="post">
    <h2>Dictionary</h2>
    <input name="findword" type="text">
    <input type="submit" value="Find">
    <h2>Nghĩa là: ${result}</h2>

  </form>
  </body>
</html>
