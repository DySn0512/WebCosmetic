<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 10/29/2023
  Time: 4:31 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>ADMIN</title>
    <meta charset="utf-8">
    <link rel="stylesheet" type="text/css" href="style/main.css">
</head>
<body>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script src="scripts/script.js"></script>
<div class="sidebar">
    <header class="sidebar-link" style="margin-bottom: 25px; border:none">
        <img src="image/admin.png" alt="admin" style=" width:50px; height:50px;margin: 10px;">
        <span style="font-size: 30px; margin-top: 20px;color: rgb(0, 229, 229)">
           Admin
        </span>
    </header>
    <div class="sidebar-link" onclick="loadContent('product')">
        <img class="sidebar-icon" src="image/product.png" alt="product">
        <span class="link" style="color: rgb(245, 21, 93);">
             Sản Phẩm
        </span>
    </div>
    <div class="sidebar-link" onclick="loadContent('category')">
        <img class="sidebar-icon" src="image/category.png" alt="category">
        <span class="link" style="color: rgb(18, 16, 18);">
             Danh Mục
        </span>
    </div>
    <div class="sidebar-link" onclick="loadContent('keyword')">
        <img class="sidebar-icon" src="image/keyword.png" alt="keyword">
        <span class="link" style="color: rgb(254, 203, 0);">
             Keyword
        </span>
    </div>
</div>
<div class="main-content">
    <header>
        <div id="IconSidebar" onclick="expandSidebar()">&#9776;</div>
        <div id="name-content">
            ${namecontent}
        </div>
    </header>
    <div id="content">
        <jsp:include page="${page}"/>
    </div>
</div>
</body>
</html>
