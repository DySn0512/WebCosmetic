<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 11/16/2023
  Time: 2:32 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Title</title>
      <style>
          #sale  {
              width: 6280px;
              height: 60px;
              background-image: url('image/nen_sale1.jpg');
              background-size: contain;
          }
          body {
              margin: 0;
          }
          .header {

              display: flex;
              justify-content: space-between;
              align-items: center;
              background-color: #fff; /* Màu nền của header */
              color: #333; /* Màu chữ trắng */
              padding: 10px 100px; /* Khoảng cách giữa nội dung và biên của header */
          }

          .logo img {
              width: 100px; /* Điều chỉnh kích thước của logo theo ý muốn */

          }

          .search-bar {
              display: flex; /* Sử dụng Flexbox để căn chỉnh nút và thanh tìm kiếm cùng hàng */
              flex-grow: 0.75; /* Thanh tìm kiếm sẽ mở rộng để điền hết phần còn lại của header */
              margin: 0 20px; /* Khoảng cách giữa các phần tử con */
              align-items: center;
              border: 2px solid pink; /* Điều chỉnh màu và độ dày của viền thành màu hồng */
              border-radius: 30px; /* Bo góc thanh tìm kiếm */
          }

          .search-bar input {
              border-radius: 30px; /* Bo góc thanh tìm kiếm */
              height: 40px;
              width: 100%;
              border: none;
              outline: none;
              margin-left: 10px;
          }


          .search-bar button {
              background-color: #fff; /* Màu nền của nút tìm kiếm */
              color: #fff;
              border: none;
              padding: 5px 10px;
              margin-right: 20px;
          }

          .icons {
              display: flex;
              align-items: center;
          }

          .icons .cart-icon,
          .icons .account-icon {
              margin: 0 10px; /* Khoảng cách giữa biểu tượng tin nhắn và giỏ hàng */
          }

          .icons img {
              width: 30px; /* Điều chỉnh kích thước của biểu tượng theo ý muốn */
          }
          nav {
              background-color: #FFB6C1 ; /* Màu hồng pastel */
              padding: 10px;
              text-align: center; /* Căn giữa */
          }

          /* Style for the navigation links */
          nav a {
              color: white;
              text-decoration: none;
              padding: 10px;
              display: inline-block;
              font-family: 'Helvetica Neue', sans-serif; /* Font family */
              font-size: 14px; /* Kích thước chữ */
          }

          /* Style for the dropdown container */
          .dropdown {
              position: relative;
              display: inline-block;
              margin-right: 10px; /* Khoảng cách bên phải */
              margin-left: 10px; /* Khoảng cách bên trái */
          }

          /* Style for the dropdown content (hidden by default) */
          .dropdown-content {
              display: none;
              position: absolute;
              background-color: #FFB6C1; /* Màu hồng */
              min-width: 160px;
              box-shadow: 0 8px 16px rgba(0, 0, 0, 0.2);
              z-index: 1;
              text-align: left; /* Căn trái */
              padding: 10px; /* Khoảng cách bên trong */
          }

          /* Style for the dropdown links */
          .dropdown-content a {
              color: white; /* Chữ trắng */
              padding: 12px 16px;
              display: block;
              text-decoration: none;
              font-family: 'Helvetica Neue', sans-serif; /* Font family */
              font-size: 14px; /* Kích thước chữ */
          }

          /* Change color on hover */
          .dropdown-content a:hover {
              background-color: #ddd;
          }

          /* Show the dropdown menu on hover */
          .dropdown:hover .dropdown-content {
              display: block;
          }
          .slideshow-container {
              position: relative;
              width: 100%;
              height: 400px;
              overflow: hidden;
          }

          .mySlides {
              position: absolute;
              width: 100%;
              height: 100%;
              transition: opacity 1.5s ease-in-out; /* Sử dụng transition để tạo hiệu ứng chuyển đổi */
          }

          .fade {
              opacity: 0; /* Bắt đầu ảnh ở trạng thái ẩn */
          }

          .product-container {
              display: flex;
              flex-wrap: wrap;
              justify-content: center; /* Căn giữa theo chiều ngang */
          }

          /* Khung của mỗi sản phẩm */
          .product {
              width: calc(25% - 20px);
              padding: 10px;
              border: 1px solid #FFC0CB;
              text-align: center;
              margin: 10px; /* Khoảng cách giữa các sản phẩm */
          }

          /* Ảnh sản phẩm */
          .product img {
              max-width: 100%;
              height: auto;
          }
      </style>
      <script>
          loadContent('home');
      </script>
  </head>
  <body>

  <div id="sale">
      <a href="">Sale tháng 11 lên đến 30%</a>
  </div>
  <div class="header">
      <div class="logo">
          <img src="image/logo.png" alt="Logo"/>
      </div>

      <div class="search-bar">
          <input type="text" placeholder="Tìm kiếm..."/>
          <button id="search_button" type="submit"><img src="image/search-icon 2.png" alt="" width="35px" height="35px">
          </button>
      </div>
      <div class="icons">

          <div class="cart-icon">
              <img src="image/cart1.jpeg" alt="Giỏ hàng"/>
          </div>
          <div id="account-icon">
              <img src="image/account.png" alt="Tài khoản cá nhân"/>
          </div>
      </div>
  </div>
  <nav>
      <a href="#">Home</a>
      <div class="dropdown">
          <a href="#">Brands</a>
          <div class="dropdown-content">
              <a href="#">Brand 1</a>
              <a href="#">Brand 2</a>
              <a href="#">Brand 3</a>
          </div>
      </div>
      <div class="dropdown">
          <a href="#">Trang điểm</a>
          <div class="dropdown-content">
              <a href="#">Mặt</a>
              <a href="#">Mắt</a>
              <a href="#">Môi</a>
              <a href="#">Má</a>
          </div>
      </div>
      <div class="dropdown">
          <a href="#">Chăm sóc da</a>
          <div class="dropdown-content">
              <a href="#">Làm sạch</a>
              <a href="#">Mặt nạ</a>
              <a href="#">Tinh chất</a>
              <a href="#">Cấp ẩm</a>
          </div>
      </div>
      <div class="dropdown">
          <a href="#">Chăm sóc mắt</a>
          <div class="dropdown-content">
              <a href="#">Dưỡng môi và chống nắng</a>
          </div>
      </div>
      <div class="dropdown">
          <a href="#">Chăm sóc tóc</a>
          <div class="dropdown-content">
              <a href="#">Dầu gội</a>
              <a href="#">Dầu xả</a>
              <a href="#">Tẩy tế bào chết da đầu</a>
              <a href="#">Dầu dưỡng</a>
          </div>
      </div>
      <div class="dropdown">
          <a href="#">Nước hoa</a>
          <div class="dropdown-content">
              <a href="#">Nước hoa nam</a>
              <a href="#">Nước hoa nữ</a>
          </div>
      </div>
      <div class="dropdown">
          <a href="#">Dưỡng thể</a>
          <div class="dropdown-content">
              <a href="#">Sữa tắm</a>
              <a href="#">Sữa dưỡng thể</a>
              <a href="#">Kem chống nắng body</a>
          </div>
      </div>
  </nav>
  <div class="slideshow-container">
      <div class="mySlides fade">
          <img src="image/slide1.png" style="width:100%">
      </div>

      <div class="mySlides fade">
          <img src="image/slide2.jpg" style="width:100%">
      </div>
      <div class="mySlides fade">
          <img src="image/slide3.jpg" style="width:100%">
      </div>
  </div>
  <div class="product-container">
      <c:forEach items="${products}" var="product">
          <div class="product">
              <img src="${product.images[0].link}" alt="">
              <p>${product.name}</p>
              <p>${product.price}</p>
          </div>
      </c:forEach>

  </div>
  <!-- Hiển thị phân trang -->
  <div>

      <!-- Hiển thị các liên kết chuyển trang -->
      <c:forEach begin="1" end="${totalPages}" var="i">
          <a href="home?page=${i}">Trang ${i}</a>
      </c:forEach>
  </div>
  <script src="scripts/script.js"></script>
  </body>
</html>
