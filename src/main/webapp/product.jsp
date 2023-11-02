<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Sản Phẩm</title>
    <link rel="stylesheet" href="style/main.css">
</head>
<body>
<h1>Danh sách sản phẩm</h1>
<div>
    <div class="search-bar">
        <div>
            <form>
                <div class="search-input-wrapper">
                    <input type="text" id="search-input" name="search-input" placeholder="Nhập từ khóa tìm kiếm">
                    <button type="submit" id="search-button">
                        <span class="search-icon">🔍</span> Tìm kiếm
                    </button>
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
            </form>
        </div>
        <div style=" margin-left: auto;">
            <button class="add-button">Thêm Mới</button>
            <button class="delete-button">Xoá</button>
        </div>
    </div>
</div>
</body>
</html>

