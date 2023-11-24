<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="HeaderTemplate.jsp" %>
<html>
<head>
    <title>Thông tin sản phẩm</title>
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

        function selectDetail(button, sale, price, salePrice, id) {
            var isSelected = button.getAttribute('data-selected') === 'true';

            if (isSelected) {
                // Nếu đã chọn, thực hiện các thay đổi cần thiết khi click lại
                button.classList.remove('n-ioz2');
                button.setAttribute('data-selected', 'false');
            } else {
                // Nếu chưa chọn, thực hiện các thay đổi cần thiết khi click lần đầu
                button.classList.add('n-ioz2');
                button.setAttribute('data-selected', 'true');
            }
        }
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

        .container {
            display: flex;
            flex-direction: column;
        }

        .upper {
            margin-top: 0px; /* Điều chỉnh giá trị này để tạo khoảng trống phù hợp */
            display: flex;
            flex-direction: column;
        }

        .bottom {
            display: flex;
            flex: 1; /* Phần dưới chiếm phần tỉ lệ linh hoạt của container */
        }

        .left, .right {
            flex: 1; /* Phần trái và phải chiếm bằng nhau */
        }

        .bR6mEk {
            flex-basis: 515px;
            max-width: 515px;
            flex-wrap: wrap;
            max-height: 220px;
            overflow-y: auto;
            margin-top: -8px;
        }

        .items-center {
            align-items: center;
        }

        .flex, .h-center {
            display: flex;
        }

        .items-center {
            align-items: center;
        }

        .flex, .h-center {
            display: flex;
        }

        .hUWqqt:hover {
            color: var(--brand-primary-color,#ee4d2d);
            border-color: var(--brand-primary-color,#ee4d2d);
        }
        ._69cHHm {
            padding-left: 2.5rem;
        }
        .n-ioz2 {
            color: var(--brand-primary-color,#ee4d2d);
            border-color: var(--brand-primary-color,#ee4d2d);
        }
        .hUWqqt {
            overflow: visible;
            cursor: pointer;
            min-width: 5rem;
            min-height: 2.5rem;
            box-sizing: border-box;
            padding: .5rem;
            margin: 8px 8px 0 0;
            color: rgba(0,0,0,.8);
            text-align: left;
            border-radius: 2px;
            border: 1px solid rgba(0,0,0,.09);
            position: relative;
            background: #fff;
            outline: 0;
            word-break: break-word;
            display: inline-flex;
            align-items: center;
            justify-content: center;
        }
        button, html input[type=button], input[type=reset], input[type=submit] {
            -webkit-appearance: button;
            cursor: pointer;
        }

        button, select {
            text-transform: none;
        }
        button {
            overflow: visible;
        }
        button, input, optgroup, select, textarea {
            color: inherit;
            font: inherit;
            margin: 0;
        }
        user agent stylesheet
        button:active {
            border-style: inset;
        }
        user agent stylesheet
        button {
            appearance: auto;
            text-rendering: auto;
            color: buttontext;
            letter-spacing: normal;
            word-spacing: normal;
            line-height: normal;
            text-transform: none;
            text-indent: 0px;
            text-shadow: none;
            display: inline-block;
            text-align: center;
            align-items: flex-start;
            cursor: default;
            box-sizing: border-box;
            background-color: buttonface;
            margin: 0em;
            padding-block: 1px;
            padding-inline: 6px;
            border-width: 2px;
            border-style: outset;
            border-color: buttonborder;
            border-image: initial;
        }

        .hUWqqt[data-selected="true"] {
            /* Các thuộc tính CSS ở đây */
            background-color: #ff0000; /* Ví dụ: đổi màu nền thành đỏ */
        }

        /* Kiểu cho button chưa được chọn */
        .hUWqqt[data-selected="false"] {
            /* Các thuộc tính CSS ở đây */
            background-color: #00ff00; /* Ví dụ: đổi màu nền thành xanh lá cây */
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
                <input type="number" id="number" name="quantity" value="1" />
                <input type="button" onclick="increaseNumber()" value="+"/>
                <button value="add" name="action" onclick="checkSelect()">Thêm vào giỏ hàng</button>
            </form>

            <div class="flex items-center bR6mEk">
                <!-- Hiển thị các nút ứng với từng unit -->
                <c:forEach items="${product.details}" var="detail">
                    <button class="hUWqqt _69cHHm" onclick="selectDetail(${detail.sale}, ${detail.price}, ${detail.salePrice}, ${detail.id}) " data-selected="false">${detail.unit} </button>
                </c:forEach>
            </div>




            <!-- Hiển thị hình ảnh sản phẩm -->
            <!-- <img src="${product.images[0].link}" alt="${product.name} Image"> -->

        </div>
    </div>
</div>

<script src="scripts/script.js"></script>
</body>
</html>
