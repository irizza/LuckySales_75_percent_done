<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 19.07.2016
  Time: 14:36
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 <%--%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"  %>


<html>
<head>
    <title>LuckySales</title>
</head>
<body>
<%--<table border="1px">
  <tr>
    <td>Id</td>
    <td>Name</td>
    <td>Description</td>
    <td>Price</td>
   <td>Count</td>
    <td>Status</td>
  </tr>
  <tr>
    <td>${requestScope.product.id}</td>
    <td>${requestScope.product.name}</td>
    <td></td>
    <td></td>
    <td></td>
    <td><form action="/home" method="get">
      <input type="button" value="ADD" name="addBtn">
    </form></td>
  </tr>
</table>--%>





<form action="/buy" method="post">

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
    <td><form action="/buy" method="post">
      <input type="button" value="ADD" name="add" onclick="add">
    </form></td>
  </tr>
</c:forEach>
</table>
  <input type="submit" value="Card">
</form>

<%--<c:set var="salary" scope="session" value="${2000*2}"/>
<c:if test="${salary > 2000}">
<p>My salary is: <c:out value="${salary}"/><p>
  </c:if>--%>
</body>
</html>
