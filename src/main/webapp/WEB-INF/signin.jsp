<%--
  Created by IntelliJ IDEA.
  User: USER
  Date: 2024-08-01
  Time: 오후 7:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Signin Page</h1>

<form action ="/signin" method="post">
    <div>
        <label>ID</label>
        <input type="text" name="uid">
    </div>

    <div>
        <label>PW</label>
        <input type="password" name="upw">
    </div>

    <button>Signin</button>
</form>
</body>
</html>
