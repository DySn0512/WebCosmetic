<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Product Detail</title>
    <script>
        function showPrice(sale, price, salePrice) {
            var priceDisplay = document.getElementById('price-display');
            if (sale) {
                priceDisplay.innerHTML = "<del>" + price + "</del> " + salePrice;
            } else {
                priceDisplay.textContent = price;
            }
        }
    </script>
</head>
<body>
<h1>Product Detail</h1>
<div>
    <h2>Name: ${product.name}</h2>
    <p>Description: ${product.description}</p>
    <!-- Hiển thị giá tiền -->
    <p>Price: <span id="price-display">
    <c:if test="${product.details[0].sale}">
        <s>${product.details[0].price}</s>
        ${product.price}
    </c:if>
    <c:if test="${!product.details[0].sale}">
        ${product.price}
    </c:if>
    </span>
    </p>

    <!-- Hiển thị các nút ứng với từng unit -->
    <c:forEach items="${product.details}" var="detail">
        <button onclick="showPrice(${detail.sale}, ${detail.price}, ${detail.salePrice})">${detail.unit}</button>
    </c:forEach>

    <!-- Hiển thị hình ảnh sản phẩm -->
    <!-- <img src="${product.images[0].link}" alt="${product.name} Image"> -->
</div>
</body>
</html>
