<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Sản Phẩm</title>
    <link rel="stylesheet" href="style/main.css">
</head>
<body>
<jsp:include page="sidebar.jsp"/>
<div class="main-content">
    <header style="height: 70px">
        <div id="IconSidebar" onclick="expandSidebar()">&#9776;</div>
        <nav aria-label="breadcrumb">
            <ol class="breadcrumb">
                <li class="breadcrumb-item"><a href="admin.jsp">Trang Chủ</a></li>
                <li class="breadcrumb-item active" aria-current="page">/Sản Phẩm</li>
            </ol>
        </nav>
    </header>
    <div style="margin: 10px" >
        <form method="post" action="product">
            <input type="hidden" name="action" id="action" value="">
            <div class="tool-bar">
                <div class="search-bar">
                    <div class="search-input-wrapper">
                        <input type="text" id="search-input" name="search-input" placeholder="Nhập từ khóa tìm kiếm">
                        <input type="submit" value="🔍" onclick="setAction('find')">
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
                    <input type="submit" class="add-button" value="Thêm mới" onclick="setAction('add')">
                    <input type="submit" class="delete-button" value="Xoá" onclick="setAction('remove')">
                </div>
            </div>
        </form>
    </div>
</div>
</body>
</html>

