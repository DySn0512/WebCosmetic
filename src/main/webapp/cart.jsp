<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 11/22/2023
  Time: 2:18 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<link rel="stylesheet" href="style/cart.css">
<head>
    <title>Giỏ Hàng</title>
</head>
<body>
<h1>Đơn hàng</h1>
<div class="header">
    <table>
        <thead>
        <tr>
            <th>Checkbox</th>
            <th>Tên sản phẩm</th>
            <th>Số lượng</th>
            <th>Phân loại</th>
            <th>Đơn giá</th>
            <th>Số tiền</th>
            <th>Thao tác</th>
        </tr>
        </thead>
    </table>
</div>

<div class="content">
    <form id="cart-form" method="post">
        <table>
            <tbody>
            <c:forEach items="${cart.lineItems}" var="lineItem">
                <tr>
                    <input type="hidden" value="${lineItem.detailProduct.currentPrice}" name="currentPrice">
                    <td><input type="checkbox" value="${lineItem.detailProduct.id}" name="idDetailProduct"
                               onchange="totalPrice()"
                    <c:if test="${lineItem.detailProduct.price==0}">
                               disabled
                    </c:if>>
                    </td>
                    <td>
                        <a class="noUnderline" href="detail?name=${lineItem.detailProduct.product.name}">
                                ${lineItem.detailProduct.product.name}
                        </a>
                    </td>
                    <td>
                        <div class="quantity-controls">
                            <button type="button" onclick="decreaseQuanity(this,'${lineItem.detailProduct.id}')">-
                            </button>
                            <input id="quantity" type="text" value="${lineItem.quantity}" oninput="inputChange(this)"
                                   onblur="handleBlur(this,'${lineItem.detailProduct.id}')" name="quantity">
                            <button type="button" onclick="increaseQuanity(this,'${lineItem.detailProduct.id}')">+
                            </button>
                        </div>
                    </td>
                    <td>${lineItem.detailProduct.unit}</td>
                    <td>
                        <c:if test="${lineItem.detailProduct.sale}">
                            <s>${lineItem.detailProduct.price}</s>
                            ${lineItem.detailProduct.salePrice}
                        </c:if>
                        <c:if test="${!lineItem.detailProduct.sale}">
                            ${lineItem.detailProduct.price}
                        </c:if>
                    </td>
                    <td>${lineItem.getTotal()} </td>
                    <td>
                        <button type="button" onclick="removeLineItem('${lineItem.detailProduct.id}',this)"> xoá
                        </button>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        <button name="action" value="remove" onclick="setAction('cart')">Xoá tất cả</button>
        <button name="action" value="create" onclick="setAction('order')">Mua hàng</button>
        <div id="price-total">0</div>
    </form>
</div>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script src="scripts/script.js"></script>
</body>
</html>
