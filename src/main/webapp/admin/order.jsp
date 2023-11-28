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
                <li class="breadcrumb-item active" aria-current="page">/Đơn Hàng</li>
            </ol>
        </nav>
    </header>
    <div style="margin: 10px">
        <h1>Quản lý đơn hàng</h1>
        <label>
            <select onchange="searchOrder(this.value)">
                <c:forEach var="item" items="${status}">
                    <option value="${item}">${item}</option>
                </c:forEach>
            </select>
        </label>
        <table>
            <thead>
            <tr>
                <th>Tên khách hàng</th>
                <th>Số Điện Thoại</th>
                <th>Địa chỉ</th>
                <th>Ngày mua hàng</th>
                <th>Thành tiền</th>
                <th>Trạng thái</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="order" items="${orders}">
                <tr class="order">
                    <td onclick="selectOrder('${order.id}')">${order.user.name}</td>
                    <td onclick="selectOrder('${order.id}')">${order.phone}</td>
                    <td onclick="selectOrder('${order.id}')">${order.address}</td>
                    <td onclick="selectOrder('${order.id}')">${order.timeOrder}</td>
                    <td onclick="selectOrder('${order.id}')">${order.total}</td>
                    <td>
                        <select name="status" style="width: 100%; font-size: 20px"
                                onchange="updateOrder('${order.id}',this.value)">
                            <option value="${order.status}">${order.status}</option>
                            <c:forEach var="item" items="${status}">
                                <c:if test="${item!=order.status}">
                                    <option value="${item}">${item}</option>
                                </c:if>
                            </c:forEach>
                        </select>
                    </td>
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
