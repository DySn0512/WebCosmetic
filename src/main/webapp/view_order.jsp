<%--
  Created by IntelliJ IDEA.
  User: huynhthihuyentrang
  Date: 29/11/2023
  Time: 14:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Your Order History </title>
    <link href="https://fonts.googleapis.com/css2?family=Inconsolata&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="style/view-order.css">
</head>
<body>
<div class ="button-row" id ="button_click">
    <div class="filter-order active" onclick="searchUserOrder('Chờ xác nhận',this)">Chờ xác nhận </div>
    <div class="filter-order" onclick="searchUserOrder('Đang giao',this)">Đang giao</div>
    <div class="filter-order" onclick="searchUserOrder('Đã giao',this)">Đã giao</div>
</div>
</div>
<div id = "order_history">
    <table>
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
