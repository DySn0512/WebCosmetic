<%--
  Created by IntelliJ IDEA.
  User: huynhthihuyentrang
  Date: 25/11/2023
  Time: 12:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<link rel="stylesheet" href="style/order.css">
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Trang thanh toán</title>
</head>

<body>
<header>
    <h1>Thông tin giao hàng</h1>
</header>
<main>
    <form action="order" method="post">
        <section class="shipping-info">
            <h2>Thông tin khách hàng</h2>
            <table>
                <thead>
                <tr>
                    <th>Tên khách hàng</th>
                    <th>Số điện thoại</th>
                    <th>Email</th>
                    <th>Địa chỉ</th>
                </tr>
                </thead>
            </table>
            <table>
                <tbody>
                <tr>
                    <td>${customer.name}</td>
                    <td><input value="${customer.phone}" name="phone" oninput="inputChange(this)" maxlength="10"></td>
                    <td>${customer.email}</td>
                    <td><input value="${customer.address}" name="address"></td>
                </tr>
                </tbody>
            </table>
        </section>

        <section class="shipping-info">
            <h2>Thông tin đơn hàng</h2>
            <table>
                <thead>
                <tr>
                    <th>Tên sản phẩm</th>
                    <th>Số lượng</th>
                    <th>Phân loại</th>
                    <th>Đơn giá</th>
                    <th>Số tiền</th>
                </tr>
                </thead>
            </table>
            <table>
                <tbody>
                <c:set var="total" value="0"/>
                <c:forEach items="${lineItemsOrder}" var="lineItem">
                    <tr>
                        <td>${lineItem.detailProduct.product.name}</td>
                        <td>${lineItem.quantity}</td>
                        <td>${lineItem.detailProduct.unit}</td>
                        <td>${lineItem.detailProduct.currentPrice}</td>
                        <td>${lineItem.getTotal()}</td>
                    </tr>
                    <c:set var="total" value="${total + lineItem.getTotal()}"/>
                </c:forEach>
                </tbody>
            </table>
            <div class="summary">
                <p>Thành Tiền:${total} <span></span></p>
            </div>
        </section>
        <br>
        <button value="add" name="action" type="submit">Check out</button>
    </form>
</main>
</body>
</html>
