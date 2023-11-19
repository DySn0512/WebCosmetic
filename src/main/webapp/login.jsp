<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 11/19/2023
  Time: 5:54 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Trang Đăng Nhập </title>
</head>
<body>
<div class="container" id="container">
    <form action="login" method="post">
        <input type="hidden" name="action" value="admin">
        <h1>Đăng nhập </h1>
        <p>${message}</p>
        <input type="text" placeholder="UserName" name="userName" required>
        <input type="text" placeholder="Password" name="password" required>
        <button type="submit">Đăng nhập</button>
    </form>
</div>
</body>
</html>
