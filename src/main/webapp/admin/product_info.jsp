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
    <link rel="stylesheet" href="../style/main.css">
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
        <form action="productInfo" method="post" class="info-product-form" onsubmit="submitProductForm(this)">
            <c:choose>
                <c:when test="${empty product}">
                    <input type="hidden" name="action" value="add">
                </c:when>
                <c:otherwise>
                    <input type="hidden" name="action" value="update">
                </c:otherwise>
            </c:choose>
            <div id="info-product">
                <h1>Thông tin sản phẩm</h1>
                <input type="hidden" value="${product.id}" name="idProduct">
                <label>
                    Tên sản phẩm:
                    <input type="text" value="${product.name}" name="name" required><br/>
                </label>
                <label>
                    Xuất xứ:
                    <input type="text" value="${product.origin}" name="origin" required><br/>
                </label>
                <label>
                    Mô tả:
                    <textarea name="description" required>${product.description}</textarea><br/>
                </label>
                <label>
                    Thương hiệu:
                    <select name="brand" required>
                        <c:choose>
                            <c:when test="${empty product.brand.id}">
                                <option value="">Chọn thương hiệu</option>
                            </c:when>
                            <c:otherwise>
                                <option value="${product.brand.id}">${product.brand.name}</option>
                            </c:otherwise>
                        </c:choose>
                        <c:forEach items="${brands}" var="brand">
                            <c:if test="${brand.id != product.brand.id}">
                                <option value="${brand.id}">${brand.name}</option>
                            </c:if>
                        </c:forEach>
                    </select>
                </label><br>
                <label>
                    Danh mục:
                    <select name="productCategory" id="CategorySelect" required onchange="updateSubCategories(this)">
                        <c:choose>
                            <c:when test="${empty product.productCategory.id}">
                                <option value="">Chọn danh mục</option>
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
                    <select name="subCategory" id="subCategorySelect" required>
                        <c:choose>
                            <c:when test="${empty product.subCategory.id}">
                                <option value="">Chọn danh mục con</option>
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
                <input type="submit" value="Lưu thông tin"/>
            </div>
            <div id="detail-container">
                <h1>Chi tiết sản phẩm</h1>
                <br>
                <div onclick="addProductDetails()" id="add-detail">+</div>
                <c:forEach items="${product.details}" var="detail">
                    <div class="detail-item">
                        <input type="button" onclick="removeParent(this)" value="X">
                        <input type="hidden" name="idDetail" value="${detail.id}">
                        <div>
                            <label>
                                Đơn vị sản phẩm:
                                <input type="text" name="unit" value="${detail.unit}">
                            </label>
                            <label class="right">
                                Giảm giá:
                                <input type="checkbox" name="isSale" id="is-sale"
                                       onchange="updateSaleIput(this)"
                                       <c:if test="${detail.sale}">checked</c:if> >
                            </label>
                        </div>
                        <div>
                            <label>
                                Giá:
                                <input type="number" name="price" value="${detail.price}" required pattern="d*"
                                       title="Chỉ được nhập số." id="price">
                            </label>
                            <label class="right">
                                Giá được giảm:
                                <input type="number" name="salePrice" value="${detail.salePrice}"
                                       pattern="d*" id="sale-price"
                                       title="Chỉ được nhập số.">
                            </label>
                        </div>
                    </div>
                </c:forEach>
            </div>
            <div id="image-container" ondrop="drop(event)" ondragover="allowDrop(event)">
                <h1>Ảnh</h1>
                <c:forEach items="${product.images}" var="image">
                    <div class="image-item">
                        <input type="hidden" value="${image.link}" name="strImage">
                        <input type="button" class="delete-div" onclick="removeImage(this,'${image.link}')" value="X">
                        <img class="img-product" src="${image.link}" alt="">
                    </div>
                </c:forEach>
            </div>
        </form>
    </div>
</div>
</body>
</html>
