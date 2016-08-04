<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 19.07.2016
  Time: 14:35
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>LuckySales</title>
</head>
<body>



<h4>${requestScope.hello}${requestScope.sessionid}</h4>
<a href="main">Login</a>
<a href="registration">Registration</a>
<a href="products">Products</a>
<a href="home" name="logout" onclick="out">logOUT</a>
<table border="2px">
  <tr>
    <td>Id</td>
    <td>Name</td>
    <td>Price</td>
  </tr>
    <td></td>
    <td></td>
    <td></td>
</table>


</body>
</html>
