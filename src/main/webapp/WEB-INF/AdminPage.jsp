<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 19.07.2016
  Time: 14:37
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>LuckySales</title>
</head>
<body>
<h4>Admin, ${requestScope.user.name}</h4>


<table border="2px">
  <tr>
    <td>Id</td>
    <td>Name</td>
    <td>Price</td>
    <td>Count</td>
    <td>Status</td>
  </tr>
  <c:forEach items="${requestScope.products}" var="product">
    <tr>
      <td>${product.id}</td>
      <td>${product.name}</td>
      <td>${product.price}</td>
      <td>${product.count}</td>
      <td><form action="/home" method="post">
        <input type="button" value="Delete" name="addBtn" onclick="">
      </form></td>
    </tr>
  </c:forEach>
</table>
</form>


<form action="/admin" method="post">
  Name: <input type="text" name="name" required ><br>
  Price: <input type="text" name="price" required ><br>
  Count: <input type="text" name="count" required ><br>
  Description: <input type="text" name="description" ><br>
  <input type="submit" value="ADD">
</form>


ProductsList
add/del
save btn
</body>
</html>
