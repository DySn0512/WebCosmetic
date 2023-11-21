<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 10/31/2023
  Time: 1:50 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Danh Mục</title>
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
                <li class="breadcrumb-item active" aria-current="page">/Danh Mục</li>
            </ol>
        </nav>
    </header>
    <div>
        <div id="add-form" class="modal">
            <div class="modal-content">
                <span class="close" onclick="x_function()">&times;</span>
                <form action="" method="post" id="name-form">
                    <input type="hidden" id="id-category" name="idCategory" value>
                    <input type="text" id="new-name" name="newName" value="" required>
                    <input type="submit" name="action" value="Thêm">
                </form>
            </div>
        </div>
        <button onclick="callForm('Tên danh mục','category','')">Thêm Danh Mục</button>
        <ul>
            <c:forEach items="${productCategories}" var="productCategory">
                <div class="category" onclick="toggleSubcategories(this)">
                    <span class="toggle-icon">▶</span>
                    <form action="category" class="nameForm">
                        <input type="hidden" value="${productCategory.id}" name="id">
                        <input type="text" value="${productCategory.name}" disabled required
                               style="pointer-events: none;" name="newName" class="name">
                        <div>
                            <input type="button" class="edit-input" onclick="editInput(this)" value="Chỉnh sửa">
                            <button value="update" name="action" class="save-input"
                                    style="display: none">Lưu</button>
                            <button value="remove" name="action" class="delete-input">Xoá</button>
                            <input type="button" class="cancel-input"
                                   onclick="cancelEdit(this,'${productCategory.name}')"
                                   style="display: none" value="Huỷ">
                        </div>
                    </form>
                </div>
                <div class="subcategories">
                    <div class="subcategory-item" id="addInput"
                         onclick="callForm('Tên danh mục con','subcategory','${productCategory.id}')">
                        +
                    </div>
                    <c:forEach items="${productCategory.subCategories}" var="subCategory">
                        <div class="subcategory-item">
                            <form action="subcategory" class="nameForm">
                                <input type="hidden" value="${productCategory.id}" name="idCategory">
                                <input type="hidden" value="${subCategory.id}" name="id">
                                <input type="text" value="${subCategory.name}" name="newName" disabled required
                                       class="name">
                                <div>
                                    <input type="button" class="edit-input" onclick="editInput(this)" value="Chỉnh sửa">
                                    <button value="update" name="action" class="save-input"
                                            style="display: none">Lưu</button>
                                    <button value="remove" name="action" class="delete-input">Xoá</button>
                                    <input type="button" class="cancel-input"
                                           onclick="cancelEdit(this,'${subCategory.name}')"
                                           style="display: none" value="Huỷ">
                                </div>
                            </form>
                        </div>
                    </c:forEach>
                </div>
            </c:forEach>
        </ul>
    </div>
</div>
</body>
</html>
