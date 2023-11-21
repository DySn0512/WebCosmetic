<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 11/22/2023
  Time: 2:18 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <link rel="stylesheet" href="style/cart.css">
<head>
    <h1>Đơn hàng</h1>
    <div class="header">
        <table>
            <thead>
                <tr>
                    <th>Checkbox</th>
                    <th>Tên sản phẩm</th>
                    <th>Số lượng</th>
                    <th>Đơn giá</th>
                    <th>Số tiền</th>
                    <th>Thao tác</th>
                </tr>
            </thead>
        </table>
    </div>

    <div class="content">
        <table>
            <tbody>
            <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
            <c:forEach var="lineItems" items="${cart.lineItems}">
                <tr>
                    <td><input type="checkbox" name="id" value="${cart.id}"</td>
                    <td>${cart.lineItem.detailProduct.product.name} </td>
                    <td>${cart.size} </td>
                    <td>${cart.lineItem.detailProduct.price} </td>
                    <td>${cart.lineItem.total} </td>
                    <td><a href="cart?action=delete&id=${cart.id}">Xoá sản phẩm</a> </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>

    <lable>Tổng thanh toán</lable>
    <form action="" method="post">
        <input type="hidden" name="action" value="checkout">
        <input type="submit" value="Mua Hàng">
    </form>
</head>
<body>

</body>
</html>
