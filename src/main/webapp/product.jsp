<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Sản Phẩm</title>
    <link rel="stylesheet" href="style/main.css">
</head>
<body>
<jsp:include page="/sidebar.jsp"/>
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
                        <input type="text" id="search-input" name="search-input" placeholder="Nhập từ khóa tìm kiếm">
                        <button value="find" name="action">🔍</button>
                    </div>
                    <select class="search-type">
                        <option value="">Tìm theo...</option>
                        <option value="search-by-name">id</option>
                        <option value="search-by-location">Tên</option>
                    </select>
                    <label class="radio-label">
                        <input type="radio" name="discount-radio" value="all" id="discount-all">
                        Tất cả
                    </label>
                    <label class="radio-label">
                        <input type="radio" name="discount-radio" value="yes" id="discount-yes">
                        Giảm giá
                    </label>
                    <label class="radio-label">
                        <input type="radio" name="discount-radio" value="no" id="discount-no">
                        Không giảm giá
                    </label>
                </div>
                <div>
                    <button value="add" name="action" class="add-button">Thêm mới</button>
                    <button value="remove" name="action" class="delete-button">Xoá</button>
                </div>
            </div>
            <div>

                <table>
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
</body>
</html>

