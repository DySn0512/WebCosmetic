<%--
  Created by IntelliJ IDEA.
  User: huynhthihuyentrang
  Date: 29/11/2023
  Time: 14:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<link href="https://fonts.googleapis.com/css2?family=Inconsolata&display=swap" rel="stylesheet">
<html>
<style>
    body{
        font-family: 'Inconsolata', monospace;
        background-color: rgb(248, 232, 238);
    }
    table {
        width: 95%; /* Chiều rộng bảng */
        margin-left: auto; /* Canh lề trái tự động */
        margin-right: auto; /* Canh lề phải tự động */
        border-collapse: separate;
    }

    th, td {
        border: none; /* Đường viền của ô */
        padding: 8px; /* Khoảng cách giữa nội dung và đường viền */
        text-align: left; /* Căn lề văn bản */
    }
    .button-row {
        display: flex;
        justify-content: space-around;
        align-items: center;
        background-color: rgb(253, 206, 223); /* Màu nền của thanh ngang */
        padding: 10px 0; /* Khoảng cách đệm */
    }

    .button {
        margin: 0 60px; /* Khoảng cách ở mỗi bên của nút */
        position: relative;
        color: #000; /* Màu chữ mặc định */
        cursor: pointer;
        transition: color 0.3s; /* Hiệu ứng chuyển màu chữ */
    }

    .button:hover {
        color: red; /* Màu chữ khi di chuột vào */
    }

    .button::after {
        content: "";
        position: absolute;
        left: 0;
        bottom: -5px; /* Độ cao của đường gạch chân */
        width: 100%;
        height: 2px; /* Chiều dài của đường gạch chân */
        background-color: red; /* Màu của đường gạch chân */
        visibility: hidden; /* Ẩn đường gạch chân ban đầu */
        transition: all 0.3s ease; /* Hiệu ứng xuất hiện đường gạch chân */
    }

    .button:hover::after {
        visibility: visible; /* Hiển thị đường gạch chân khi di chuột vào */
    }


</style>
<head>
    <title>Your Order History </title>


</head>
<body>
<div class ="button-row" id ="button_click">
<div class="button-row">
    <div class="button" onclick="searchUserOrder('Chờ xác nhận')">Chờ xác nhận </div>
    <div class="button" onclick="searchUserOrder('Đang giao')">Đang giao</div>
    <div class="button" onclick="searchUserOrder('Đã giao')">Đã giao</div>
</div>
</div>
<div id = "order_history">
    <table border="1">
        <thead>
        <tr>
            <th>Tên sản phẩm</th>
            <th>Phân loại</th>
            <th>Số lượng</th>
            <th>Giá</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${userOrders}" var="order">

                <c:forEach items="${order.details}" var="detail">
                        <tr>
                            <td onclick="showproduct('detail?name=${detail.nameProduct}')">${detail.nameProduct}</td>
                            <td>${detail.unit}</td>
                            <td>x${detail.quantity}</td>
                            <td>${detail.price}</td>
                        </tr>
                </c:forEach>
                <tr>
                    <td colspan="3">Tổng tiền:</td>
                    <td>${order.getTotal()}</td>
                </tr>
            <tr style="background-color: rgb(249, 245, 246);">
                <td colspan="4">&nbsp;</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script src="scripts/script.js"></script>
</body>
</html>
