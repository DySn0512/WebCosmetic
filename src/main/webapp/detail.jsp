<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="HeaderTemplate.jsp" %>
<html>
<head>
    <title>Product Detail</title>
    <script>
        function selectDetail(sale, price, salePrice, id) {
            var priceDisplay = document.getElementById('price-display');
            if (sale) {
                priceDisplay.innerHTML = "<del>" + price + "</del> " + salePrice;
            } else {
                priceDisplay.textContent = price;
            }
            document.getElementById('id-detail').value = id;
        }

        document.addEventListener("DOMContentLoaded", function () {
            var breadcrumbLinks = document.querySelectorAll(".breadcrumb a:not(:last-child)");

            breadcrumbLinks.forEach(function (link) {
                link.style.opacity = "0.7"; // Làm mờ các mục ngoại trừ mục cuối cùng

                link.addEventListener("mouseenter", function () {
                    this.style.opacity = "1"; // Loại bỏ hiệu ứng làm mờ khi rê chuột vào
                });

                link.addEventListener("mouseleave", function () {
                    this.style.opacity = "0.7"; // Áp dụng hiệu ứng làm mờ lại khi rời chuột ra
                });
            });
        });


    </script>
    <style>
        /* Thiết lập CSS cho breadcrumb */
        .breadcrumb a:not(:last-child)::after {
            content: " > ";
            color: #999; /* Màu của dấu phân cách */
            margin: 0 5px; /* Khoảng cách giữa dấu phân cách và mục tiêu */
        }

        .breadcrumb a:not(:last-child) {
            text-decoration: none; /* Loại bỏ gạch chân ở các mục không phải cuối cùng */
        }

        .breadcrumb a:not(:last-child):hover {
            opacity: 0.7; /* Làm mờ các mục khi rê chuột qua */
        }

    </style>
</head>
<body>
<div class="breadcrumb">
    <!-- Hiển thị Home -->
    <a href="/WebCosmetic/home">Home</a>
    <!-- Hiển thị ProductCategory -->
    <c:if test="${not empty productCategoryBread}">
        <a href="#">${productCategoryBread.name}</a>
    </c:if>
    <!-- Hiển thị SubCategory -->
    <c:if test="${not empty productSubBread}">
        <a href="#">${productSubBread.name}</a>
    </c:if>
    <!-- Hiển thị tên sản phẩm -->
    <span>${productBread.name}</span>
</div>
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
    <form action="cart" method="post">
        <input type="hidden" name="idDetail" id="id-detail">
        <input type="button" onclick="decreaseNumber()" value="-"/>
        <input type="number" id="number" name="quantity" value="1" />
        <input type="button" onclick="increaseNumber()" value="+"/>
        <button value="add" name="action" onclick="checkSelect()">Thêm vào giỏ hàng</button>
    </form>
    <!-- Hiển thị các nút ứng với từng unit -->
    <c:forEach items="${product.details}" var="detail">
        <button onclick="selectDetail(${detail.sale}, ${detail.price}, ${detail.salePrice}, ${detail.id})">${detail.unit}</button>
    </c:forEach>
    <!-- Hiển thị hình ảnh sản phẩm -->
    <!-- <img src="${product.images[0].link}" alt="${product.name} Image"> -->

</div>
<script src="scripts/script.js"></script>
</body>
</html>
