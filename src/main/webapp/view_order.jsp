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


</head>
<body>
<c:forEach items="${userOrders}" var="order">
    <c:forEach items="${order.details}" var="detail">
        <p>Tên sản phẩm: ${detail.nameProduct} </p>
        Phân loại: ${detail.unit}
        Số lượng: x${detail.quantity}
        Giá: ${detail.price}
    </c:forEach>
    Tổng tiền: ${order.getTotal()}
</c:forEach>
</body>
</html>
