<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
</head>
<body>
<h1>Calculator</h1>
<form action="/done" method="post">
    <input name="a" required>
    <input name="b" required><br>
    <button name="operation" type="submit" value="+">Add</button>
    <button name="operation" type="submit" value="-">Subtract</button>
    <button name="operation" type="submit" value="*">Multiply</button>
    <button name="operation" type="submit" value="/">Divide</button>
</form>
<h1>RESULT = ${res}</h1>
</body>
</html>
