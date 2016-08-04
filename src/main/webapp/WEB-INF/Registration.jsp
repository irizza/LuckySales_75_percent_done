<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 19.07.2016
  Time: 13:22
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>LuckySales</title>
</head>
<body>
<form action="/main" method="post">
  <h3>${requestScope.invalidLorP}</h3>
  <h5>${requestScope.logEx}</h5>
  Name: <input type="text" name="firstName" required pattern="[A-Za-z]{3,}"><br>
  Age: <input type="text" name="age" required pattern="^[ 0-9]+$"><br>
  Login: <input type="text" name="login" required pattern="[A-Za-z]{6,}"><br>
  Password: <input type="text" name="password" required pattern="{6,}"><br>
  <input type="submit" value="ok">
</form>
</body>
</html>
