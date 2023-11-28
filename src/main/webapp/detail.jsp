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
<div class="container">
    <div class="upper">

    </div>

    <div class="bottom">
        <div class="left">
            <div class="product-images">
                <a href="detail?name=${product.name}">
                    <img src="${product.images[0].link}" alt="">
                </a>
            </div>
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
                <div class="quantity-controls">
                    <p>Số lượng: </p>
                    <input type="hidden" name="idDetail" id="id-detail">
                    <input type="button" onclick="decreaseNumber()" value="-"/>
                    <input type="text" id="number" name="quantity" value="1" oninput="inputChange(this)"
                           onblur="if (parseInt(this.value)===0){this.value=1;}"/>
                    <input type="button" onclick="increaseNumber()" value="+"/>
                </div><br>
                <!-- Hiển thị các nút ứng với từng unit -->
                <c:forEach items="${product.details}" var="detail">
                    <button type="button" class="select-detail" onclick="selectDetail(${detail.sale}, ${detail.price}, ${detail.salePrice}, ${detail.id}, this) ">${detail.unit} </button>
                </c:forEach>
                <button class="CartBtn" value="add" name="action" onclick="checkSelect()">
                        <span class="IconContainer">
                          <svg xmlns="http://www.w3.org/2000/svg" height="1em" viewBox="0 0 576 512" fill="rgb(17, 17, 17)" class="cart"><path d="M0 24C0 10.7 10.7 0 24 0H69.5c22 0 41.5 12.8 50.6 32h411c26.3 0 45.5 25 38.6 50.4l-41 152.3c-8.5 31.4-37 53.3-69.5 53.3H170.7l5.4 28.5c2.2 11.3 12.1 19.5 23.6 19.5H488c13.3 0 24 10.7 24 24s-10.7 24-24 24H199.7c-34.6 0-64.3-24.6-70.7-58.5L77.4 54.5c-.7-3.8-4-6.5-7.9-6.5H24C10.7 48 0 37.3 0 24zM128 464a48 48 0 1 1 96 0 48 48 0 1 1 -96 0zm336-48a48 48 0 1 1 0 96 48 48 0 1 1 0-96z"></path></svg>
                        </span>
                    <p class="text">Thêm vào giỏ hàng</p>
                </button>
            </form>




            <!-- Hiển thị hình ảnh sản phẩm -->
            <!-- <img src="${product.images[0].link}" alt="${product.name} Image"> -->

        </div>
    </div>
</div>

<script src="scripts/script.js"></script>
</body>
</html>
