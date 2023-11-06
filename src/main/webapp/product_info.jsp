<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 11/7/2023
  Time: 12:43 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="style/main.css">
</head>
<body>
<jsp:include page="sidebar.jsp"/>
<div class="main-content">
    <header>
        <div id="IconSidebar" onclick="expandSidebar()">&#9776;</div>
        <nav aria-label="breadcrumb">
            <ol class="breadcrumb">
                <li class="breadcrumb-item"><a href="admin.jsp">Trang Chủ</a></li>
                <li class="breadcrumb-item"><a href="product.jsp">/Sản Phẩm</a></li>
                <li class="breadcrumb-item active" aria-current="page">/Sản Phẩm</li>
            </ol>
        </nav>
    </header>
    <div style="margin: 10px" >

    </div>
</div>
</body>
</html>
