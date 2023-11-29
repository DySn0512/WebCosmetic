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
<style>
    table {
        width: 95%; /* Chiều rộng bảng */
        margin-left: auto; /* Canh lề trái tự động */
        margin-right: auto; /* Canh lề phải tự động */
        border-collapse: collapse;
    }

    th, td {
        border: 1px solid #000; /* Đường viền của ô */
        padding: 8px; /* Khoảng cách giữa nội dung và đường viền */
        text-align: left; /* Căn lề văn bản */
    }
    .button-row {
        display: flex; /* Sử dụng flexbox để xếp các ô theo hàng ngang */
        justify-content: space-around; /* Canh lề đều cho các ô trong hàng ngang */
        align-items: center; /* Canh chiều cao của ô theo trục dọc */
    }

    .button {
        padding: 10px 20px; /* Kích thước của từng ô */
        border: 1px solid #ccc; /* Đường viền của ô */
        cursor: pointer; /* Biến con trỏ thành dấu nhấn khi di chuột vào */
    }
</style>
<head>
    <title>Your Order History </title>


</head>
<body>
<div class="button-row">
    <div class="button" onclick="searchUserOrder('Chờ xác nhận')">Chờ xác nhận </div>
    <div class="button" onclick="searchUserOrder('Đang giao')">Đang giao</div>
    <div class="button" onclick="searchUserOrder('Đã giao')">Đã giao</div>
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
                    <td>${detail.nameProduct}</td>
                    <td>${detail.unit}</td>
                    <td>x${detail.quantity}</td>
                    <td>${detail.price}</td>
                </tr>
            </c:forEach>
            <tr>
                <td colspan="3">Tổng tiền:</td>
                <td>${order.getTotal()}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

</div>

</body>

</html>
