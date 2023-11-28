<%--
  Created by IntelliJ IDEA.
  User: huynhthihuyentrang
  Date: 20/11/2023
  Time: 14:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="https://fonts.googleapis.com/css2?family=Inconsolata&display=swap" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="style/home.css">
    <title></title>
</head>
<script src="./scripts/login.js"></script>
<body>
<div id="sale">
    <a href="">Sale tháng 11 lên đến 30%</a>
</div>
<div class="header">
    <div class="logo">
        <img src="image/logo.png" alt="Logo"/>
    </div>

    <div class="search-bar">
        <input type="text" placeholder="Tìm kiếm..."/>
        <button id="search_button"><img src="image/search-icon 2.png" alt="" width="35px"
                                        height="35px">
        </button>
    </div>
    <div class="icons">
        <div class="cart-icon">
            <div class="cart-number">${cart.Count()}</div>
            <button onclick="isLogin('${customer.name}','cart.jsp')">
                <img src="image/cart1.jpeg" alt="Giỏ hàng"/>
            </button>
        </div>
        <div id="account-icon">
            <button onclick="isLogin('${customer.name}','customer.jsp')" id="login-button">
                <img src="image/account.png" alt="Tài khoản cá nhân"/>
            </button>
        </div>
      </div>
    </div>
</div>
<nav>
    <a href="home">Home</a>
    <c:forEach items="${productCategories}" var="category">
        <div class="dropdown">
            <a href="home?category=${category.name}&page=1">${category.name}</a>
            <div class="dropdown-content">
                <c:forEach items="${category.subCategories}" var="subCategory">
                    <a href="home?subcategory=${subCategory.name}&page=1">${subCategory.name}</a>
                </c:forEach>
            </div>
        </div>
    </c:forEach>
</nav>
</body>
</html>
