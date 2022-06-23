<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 1/24/2022
  Time: 8:04 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Hello web</title>
  </head>
  <body>
  <h1>Hello Web</h1>
<%--  <form action="/xin-chao" method="post">--%>
<%--    Name : <input name="ten">--%>
<%--           <button type="submit"> Gửi</button>--%>
<%--  </form>--%>
  <form action="/sum1" method="post">
    First Number :
    <input type="text" name="first">
    Second Number
    <input type="text" name="second">
    <button type="submit">Tính tổng</button>
  </form>
<%--  Chuyển tới trang jsp để tính toán và hiện thị --%>
  <form action="/Sum2.jsp">
    First Number :
    <input type="text" name="first">
    Second Number
    <input type="text" name="second">
    <button type="submit">Tính tổng</button>
  </form>
  </body>
</html>
