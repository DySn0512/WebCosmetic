<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 11/7/2023
  Time: 12:43 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>${ariacurrent}</title>
    <meta charset="UTF-8">
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
                <li class="breadcrumb-item"><a href="product.jsp">/Sản Phẩm</a></li>
                <li class="breadcrumb-item active" aria-current="page">/${ariacurrent}</li>
            </ol>
        </nav>
    </header>
    <div style="margin: 10px">
        <form action="" method="post">
            <label>
                Tên sản phẩm:
                <input type="text"/><br/>
            </label>
            <label>
                Xuất xứ:
                <input type="text"/><br/>
            </label>
            <label>
                Mô tả:
                <textarea id="description"></textarea><br/>
            </label>
            <label>
                Thương hiệu:
                <select name="Brand">
                    <c:forEach items="${brands}" var="brand">
                        <option value="${brand.id}">${brand.name}</option>
                    </c:forEach>
                </select>
            </label><br>
            <label>
                Danh mục sản phẩm:
                <select name="ProductCategory">
                    <c:forEach items="${productCategories}" var="productCategory">
                        <option value="${productCategory.id}">${productCategory.name}</option>
                    </c:forEach>
                </select>
            </label><br>
            <label>
                Danh mục sản phẩm:
                <select name="SubCategory">
                    <c:forEach items="${subCategories}" var="subCategory">
                        <option value="${subCategory.id}">${subCategory.name}</option>
                    </c:forEach>
                </select>
            </label><br>
            <label>
                Từ Khoá:
                <span id="addKeywordButton" class="input-keyword" onclick="addKeywordInput(this)">+</span>
                <c:forEach items="${keyWords}" var="keyWord">
                    <input type="text" name="keyword" class="input-keyword" value="keyWord.word">
                </c:forEach>
            </label>

        </form>
        <input type="submit" value="Lưu thông tin"/>
    </div>
</div>
</body>
</html>
