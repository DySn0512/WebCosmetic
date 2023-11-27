<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Sản Phẩm</title>
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
                <li class="breadcrumb-item active" aria-current="page">/Sản Phẩm</li>
            </ol>
        </nav>
    </header>
    <div style="margin: 10px">
        <form method="post" action="product">
            <div class="tool-bar">
                <div class="search-bar">
                    <div class="search-input-wrapper">
                        <input type="text" id="search-input" name="search" placeholder="Nhập từ khóa tìm kiếm"
                               list="auto-complete" onkeydown="checkEnter()">
                        <datalist id="auto-complete">
                            <c:forEach items="${brands}" var="brand">
                            <option value="${brand.name}" class="brand">
                                </c:forEach>
                                <c:forEach items="${categories}" var="category">
                            <option value="${category.name}" class="category">
                                <c:forEach items="${category.subCategories}" var="subCategory">
                            <option value="${subCategory.name}" class="subCategory">
                                </c:forEach>
                                </c:forEach>
                        </datalist>
                        <button type="button" onclick="searchProduct()" id="find">🔍</button>
                    </div>
                    <select class="search-type" name="findBy" onchange="changeAutoComplete(this.value)">
                        <option value="name">Tên</option>
                        <option value="brand">Thương Hiệu</option>
                        <option value="category">Danh Mục</option>
                        <option value="subCategory">Danh Mục Con</option>
                    </select>
                    <label class="radio-label">
                        <input type="radio" name="isSale" value="all" id="discount-all" checked>
                        Tất cả
                    </label>
                    <label class="radio-label">
                        <input type="radio" name="isSale" value="true" id="discount-yes">
                        Giảm giá
                    </label>
                    <label class="radio-label">
                        <input type="radio" name="isSale" value="false" id="discount-no">
                        Không giảm giá
                    </label>
                </div>
                <div>
                    <button value="add" name="action" class="add-button">Thêm mới</button>
                    <button value="remove" name="action" class="delete-button">Xoá</button>
                </div>
            </div>
            <div>
                <table id="productTable">
                    <thead>
                    <tr>
                        <th></th>
                        <th>Ảnh</th>
                        <th>Tên sản phẩm</th>
                        <th>Xuất xứ</th>
                        <th>Thương hiệu</th>
                        <th>Danh mục</th>
                        <th>Danh mục con</th>
                        <th></th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${products}" var="product">
                        <tr>
                            <th><input type="checkbox" name="id" value="${product.id}"></th>
                            <th style="width:200px"><img src="${product.images[0].link}" alt=""
                                                         style=" max-width: 100%; height: auto;"></th>
                            <th>${product.name}</th>
                            <th>${product.origin}</th>
                            <th>${product.brand.name}</th>
                            <th>${product.productCategory.name}</th>
                            <th>${product.subCategory.name}</th>
                            <th><a href="product?action=update&id=${product.id}">Chỉnh sửa</a></th>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </form>
    </div>
</div>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script src="../scripts/script.js"></script>
</body>
</html>

