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
<script>
    function updateSubCategories(selectElement) {
        var id = selectElement.value;
        var subSelect = document.getElementById("subCategorySelect");
        <c:forEach items="${productCategories}" var="productCategory">
        if (id === "${productCategory.id}") {
            while (subSelect.options.length > 0) {
                subSelect.remove(0);
            }
            <c:forEach items="${productCategory.subCategories}" var="subCategory">
            var newOption = new Option("${subCategory.name}", "${subCategory.id}");
            subSelect.add(newOption);
            </c:forEach>
        }
        </c:forEach>
    }
</script>
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
                Danh mục:
                <select name="ProductCategories" id="CategorySelect" onchange="updateSubCategories(this)">
                    <c:choose>
                        <c:when test="${empty product.productCategory.id}">
                            <option>Chọn danh mục</option>
                        </c:when>
                        <c:otherwise>
                            <option value="${product.productCategory.id}">${product.productCategory.name}</option>
                        </c:otherwise>
                    </c:choose>
                    <c:set var="matchedProductCategory" value="${null}"/>
                    <c:forEach items="${productCategories}" var="productCategory">
                        <c:choose>
                            <c:when test="${productCategory.id == product.productCategory.id}">
                                <c:set var="matchedProductCategory" value="${productCategory}"/>
                            </c:when>
                            <c:otherwise>
                                <option value="${productCategory.id}">${productCategory.name}</option>
                            </c:otherwise>
                        </c:choose>
                    </c:forEach>
                </select>
            </label><br>
            <label>
                Danh mục con:
                <select name="SubCategories" id="subCategorySelect">
                    <c:choose>
                        <c:when test="${empty product.subCategory.id}">
                            <option>Chọn danh mục con</option>
                        </c:when>
                        <c:otherwise>
                            <option value="${product.subCategory.id}">${product.subCategory.name}</option>
                        </c:otherwise>
                    </c:choose>
                    <c:forEach items="${matchedProductCategory.subCategories}" var="subCategory">
                        <c:if test="${subCategory.id != product.subCategory.id}">
                            <option value="${subCategory.id}">${subCategory.name}</option>
                        </c:if>
                    </c:forEach>
                </select>
            </label><br>
            <label>
                Từ Khoá:
                <div>
                    <span id="add-input" class="input-keyword" onclick="addInput(this)">+</span>
                    <c:forEach items="${keyWords}" var="keyWord">
                        <div class="input-container">
                            <input type="text" name="keyword" class="input-keyword" value="${keyWord.word}" required>
                            <span class="delete-keyword" onclick="this.parentElement.remove();">x</span>
                        </div>
                    </c:forEach>
                </div>
            </label>
        <input type="submit" value="Lưu thông tin"/>
        </form>
    </div>
</div>
</body>
</html>
