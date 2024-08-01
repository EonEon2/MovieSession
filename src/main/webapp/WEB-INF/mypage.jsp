<%--
  Created by IntelliJ IDEA.
  User: USER
  Date: 2024-08-01
  Time: 오후 8:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<style>
    .pic{
        width: 12rem;
        margin : 2rem;
    }
</style>
<h1>My Page</h1>
<h2>내가 구매한 목록</h2>
<ul>
    <c:forEach items="${cart}" var="item">
        <li>
            <img class="pic" src="/img/${item}">
            ${item}
        </li>
    </c:forEach>
</ul>

</body>
</html>
