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
    <link rel="stylesheet" type="text/css" href="style/login_admin.css">
</head>
<body>
<div class="container">
    <div class="card">
        <form action="login" method="post">
            <input type="hidden" name="action" value="admin">
            <a class="login">Đăng nhập</a>
            <p>${message}</p>
            <div class="inputBox">
                <input type="email" name="email" value="${email}" required>
                <span class="user">Email</span>
            </div>
            <div class="inputBox">
                <input type="password" name="password" value="${password}" required>
                <span>Password</span>
            </div>
            <button class="enter">Đăng nhập</button>
        </form>
    </div>
</div>
</body>
</html>
