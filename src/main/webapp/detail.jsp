<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <title>Product Detail</title>
  <!-- Đưa vào các tệp CSS, JavaScript, hoặc thư viện cần thiết -->
</head>
<body>
<div class="product-detail">
  <h1>Product Detail</h1>
  <%-- Chỗ này bạn có thể lấy thông tin sản phẩm từ model hoặc các thông tin khác --%>
  <h2>${product.name}</h2>
  <p>Price: ${price}</p>
  <div class="product-image">
    <img src="${product.images[0].link}" alt="${product.name}">
  </div>
  <div class="product-description">
    <!-- Hiển thị thông tin mô tả hoặc chi tiết sản phẩm -->
    <p>${product.description}</p>
  </div>
</div>
</body>
</html>
