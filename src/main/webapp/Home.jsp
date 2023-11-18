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
          /* CSS để tạo pop-up */
          .modal {
              display: none;
              position: fixed;
              z-index: 1;
              left: 0;
              top: 0;
              width: 100%;
              height: 100%;
              overflow: auto;
          }

          .modal-content {
              position: absolute;
              top: 50%;
              left: 50%;
              transform: translate(-50%, -50%);
              background-color: white;
              padding: 20px;
              text-align: center;
          }

          .close {
              color: #aaa;
              float: right;
              font-size: 28px;
              font-weight: bold;
          }

          .close:hover,
          .close:focus {
              color: black;
              text-decoration: none;
              cursor: pointer;
          }

          /* Lớp mờ cho phần nền xung quanh pop-up */
          .overlay {
              position: fixed;
              top: 0;
              left: 0;
              width: 100%;
              height: 100%;
              background-color: rgba(0, 0, 0, 0.5); /* Màu đen với độ mờ 0.5 */
              z-index: 0;
              display: none;
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
      <c:forEach items="${productCategories}" var="productCategory">
          <div class="dropdown">
              <a href="#">${productCategory.name}</a>
              <div class="dropdown-content">
                  <c:forEach items="${productCategory.subCategories}" var="subCategory">
                      <a href="#">${subCategory.name}</a>
                  </c:forEach>
              </div>
          </div>
      </c:forEach>

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
  <!-- Popup -->
  <!-- Lớp mờ -->
  <div id="overlay" class="overlay"></div>

  <!-- Modal -->
  <div id="myModal" class="modal">
      <div class="modal-content">
          <span class="close" onclick="closeModal()">&times;</span>
          <img src="image/popup.gif" alt="Popup Image">
      </div>
  </div>
  <script src="scripts/script.js"></script>
  <script>
      window.onload = function() {
          openModal(); // Gọi hàm mở pop-up khi trang được tải
      };
  </script>
  </body>
</html>
