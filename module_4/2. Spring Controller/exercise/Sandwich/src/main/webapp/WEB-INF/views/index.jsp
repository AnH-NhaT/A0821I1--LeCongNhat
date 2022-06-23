<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>${message}</h1>
<h1>Login</h1>
<form action="/save" method="post">
    Sandwich Condiments
    <br>
    <input type="checkbox" value="Lettuce" name="condiment"> Lettuce
    <input type="checkbox" value="Tomato" name="condiment"> Tomato
    <input type="checkbox" value="Mustard" name="condiment"> Mustard
    <input type="checkbox" value="Sprouts" name="condiment"> Sprouts
    <br>
    <button>save</button>
</form>
<h1>${condiment}</h1>
</body>
</html>
