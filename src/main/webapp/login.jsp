<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 11/19/2023
  Time: 5:54 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" type="text/css" href="./style/login_admin.css">
<html>
<head>
    <title>Trang Đăng Nhập </title>
</head>
<body>
<%--<div class="container" id="container">--%>
<%--    <form action="login" method="post">--%>
<%--        <input type="hidden" name="action" value="admin">--%>
<%--        <h1>Đăng nhập </h1>--%>
<%--        <p>${message}</p>--%>
<%--        <input type="text" placeholder="UserName" name="userName" required>--%>
<%--        <input type="text" placeholder="Password" name="password" required>--%>
<%--        <button type="submit">Đăng nhập</button>--%>
<%--    </form>--%>
<%--</div>--%>
<div class="container">
    <div class="card">
        <form action="login" method="post">
            <input type="hidden" name="action" value="admin">
            <a class="login">Đăng nhập</a>
            <p>${message}</p>
            <div class="inputBox">
                <input type="text"  name="userName" required>
                <span class="user">Username</span>
            </div>

            <div class="inputBox">
                <input type="text"  name="password" required>
                <span>Password</span>
            </div>
            <button class="enter">Đăng nhập</button>
    </div>
</div>
</body>
</html>
