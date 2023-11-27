<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Đơn Hàng</title>
    <link rel="stylesheet" href="../style/main.css">
</head>
<body>
<jsp:include page="/admin/sidebar.jsp"/>
<div class="main-content">
    <header style="height: 70px">
        <div id="IconSidebar" onclick="expandSidebar()">&#9776;</div>
        <nav aria-label="breadcrumb">
            <ol class="breadcrumb">
                <li class="breadcrumb-item"><a href="admin">Trang Chủ</a></li>
                <li class="breadcrumb-item active" aria-current="page">/Order</li>
            </ol>
        </nav>
    </header>
    <div style="margin: 10px">
        <h1>Quản lý đơn hàng</h1>
        <table>
            <thead>
            <tr>
                <th>Tên khách hàng</th>
                <th>Số Điện Thoại</th>
                <th>Địa chỉ</th>
                <th>Ngày mua hàng</th>
                <th>Trạng thái</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="order" items="${orders}">
                <tr>
                    <td>${order.user.name}</td>
                    <td>${order.phone}</td>
                    <td>${order.address}</td>
                    <td>${order.timeOrder}</td>
                    <td>${order.status}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script src="../scripts/script.js"></script>
</body>
</html>
