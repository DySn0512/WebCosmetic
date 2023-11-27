<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="HeaderTemplate.jsp" %>
<html>
<head>
    <title>Thông tin sản phẩm</title>
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

<div class="container">
    <div class="upper">

    </div>

    <div class="bottom">
        <div class="left">
            <img src="image/admin.png">
        </div>
        <div class="right">
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
                <input type="text" id="number" name="quantity" value="1" oninput="inputChange(this)"
                       onblur="if (parseInt(this.value)===0){this.value=1;}"/>
                <input type="button" onclick="increaseNumber()" value="+"/>
                <button value="add" name="action" onclick="checkSelect()">Thêm vào giỏ hàng</button>
            </form>

            <!-- Hiển thị các nút ứng với từng unit -->
            <c:forEach items="${product.details}" var="detail">
                <button class="select-detail" onclick="selectDetail(${detail.sale}, ${detail.price}, ${detail.salePrice}, ${detail.id}, this) ">${detail.unit} </button>
            </c:forEach>


            <!-- Hiển thị hình ảnh sản phẩm -->
            <!-- <img src="${product.images[0].link}" alt="${product.name} Image"> -->

        </div>
    </div>
</div>

<script src="scripts/script.js"></script>
</body>
</html>
