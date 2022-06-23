<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 1/24/2022
  Time: 9:01 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1> Đây là trang jsp</h1>
 <%
     // code java có thể viết được trong trang jsp
     int first = Integer.parseInt(request.getParameter("first"));
     int second = Integer.parseInt(request.getParameter("second"));
     int sum = first+second;
 %>
<h1> Kết quả là : <%=sum%></h1>
</body>
</html>
