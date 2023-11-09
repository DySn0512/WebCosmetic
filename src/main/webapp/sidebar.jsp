<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 11/7/2023
  Time: 12:15 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
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

    <div class="sidebar-link" onclick="loadContent('brand')">
        <img class="sidebar-icon" src="image/brand.png" alt="brand">
        <span class="link" style="color: rgb(18, 16, 18);">
             Thương hiệu
        </span>
    </div>

    <div class="sidebar-link" onclick="loadContent('order')">
        <img class="sidebar-icon" src="image/order.jpg" alt="order">
        <span class="link" style="color: rgb(18, 16, 18);">
             Order
        </span>
    </div>
</div>
</body>
</html>
