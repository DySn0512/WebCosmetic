<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Thương Hiệu</title>
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
                <li class="breadcrumb-item active" aria-current="page">/Thương Hiệu</li>
            </ol>
        </nav>
    </header>
    <div style="margin: 10px">

        <div id="add-form" class="modal">
            <div class="modal-content">
                <span class="close" onclick="x_function()">&times;</span>
                <form action="brand" method="post" id="">
                    <input type="text" id="new-name" name="newName" value="" required>
                    <input type="submit" name="action" value="Thêm">
                </form>
            </div>
        </div>
        <button onclick="callForm('Tên thương hiệu','','')">Thêm Thương Hiệu</button>
        <c:forEach items="${brands}" var="brand">
            <div class="brand">
                <form action="brand" class="nameForm">
                    <input type="hidden" value="${brand.id}" name="id">
                    <input type="text" value="${brand.name}" name="newName" disabled required
                           class="name">
                    <div>
                        <input type="button" class="edit-input" onclick="editInput(this)" value="Chỉnh sửa">
                        <input type="submit" name="action" value="Lưu" class="save-input"
                               style="display: none">
                        <input type="submit" name="action" value="Xoá" class="delete-input">
                        <input type="button" class="cancel-input" onclick="cancelEdit(this,'${brand.name}')"
                              style="display: none" value="Huỷ">
                    </div>
                </form>
            </div>

        </c:forEach>
    </div>
</div>
</body>
</html>

