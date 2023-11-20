<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 11/16/2023
  Time: 2:32 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="HeaderTemplate.jsp" %>
<html>
  <head>

      <title>Banana Cosmetic</title>
      <style>

          .slideshow-container {
              position: relative;
              width: 100%;
              height: 400px;
              overflow: hidden;
          }
          .mySlides img {
              width: 100%;
              height: 100%;
              object-fit: cover; /* Để ảnh đạt kích thước mà không bị thay đổi tỷ lệ khung hình */
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
              width: 150px; /* Kích thước khung sản phẩm */
              padding: 10px;
              border: 1px solid #FFC0CB;
              text-align: center;
              margin: 10px;
          }

          /* Ảnh sản phẩm */
          .product-image {
              height: 250px; /* Độ cao mong muốn cho ảnh */
              overflow: hidden; /* Ảnh vượt quá kích thước sẽ bị ẩn đi */
          }

          .product-image img {
              width: 100%; /* Đảm bảo ảnh vừa với div cha */
              height: auto; /* Đảm bảo tỷ lệ khung hình không bị thay đổi */
          }
          .product a {
              text-decoration: none; /* Ẩn gạch chân */
              color: inherit; /* Giữ màu chữ mặc định */
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
          #pagination-container {
              display: flex;
              justify-content: center;
              margin-top: 20px;
          }

          #pagination a {
              /* Định dạng cho các trang chưa được chọn */
              background-color: white;
              padding: 5px 10px;
              margin: 0 5px;
              text-decoration: none;
              border: 1px solid #ccc;
              border-radius: 5px;
          }

          #pagination a.selected {
              /* Định dạng cho trang được chọn */
              background-color: pink;
          }
          .banner-perfume {
              margin-top: 50px ;
              margin-bottom: 50px;
              margin-left: 70px;
          }

      </style>
  </head>
  <body>
  <div class="slideshow-container">
      <div class="mySlides fade">
          <img src="image/slide1.jpg" style="width:100%">
      </div>
      <div class="mySlides fade">
          <img src="image/slide4.jpg" style="width:100%">
      </div>
      <div class="mySlides fade">
          <img src="image/slide3.jpg" style="width:100%">
      </div>
      <div class="mySlides fade">
          <img src="image/slide5.jpg" style="width:100%">
      </div>

  </div>
  <div class="banner-perfume">
      <img src="image/banner_perfumeGirl.jpg" alt="Banner Nước Hoa" width="1350px" >
  </div>
  <div class="product-container">
      <c:forEach items="${products}" var="product">
          <div class="product">
              <div class="product-image">
                  <a href="detail?name=${product.name}">
                      <img src="${product.images[0].link}" alt="">
                  </a>
              </div>
              <a href="detail?name=${product.name}">
                  <p>${product.name}</p>
              </a>
              <p>${product.price}</p>
          </div>
      </c:forEach>
  </div>
  <!-- Hiển thị phân trang -->
  <div id="pagination-container">
      <div id="pagination">
          <!-- Hiển thị các liên kết chuyển trang -->
          <c:forEach begin="1" end="${totalPages}" var="i">
              <a href="home?page=${i}" onclick="selectPage(this)">${i}</a>
          </c:forEach>
      </div>
  </div>

  <!-- Popup -->
  <!-- Lớp mờ -->
  <div id="overlay" class="overlay"></div>

  <!-- Modal -->
  <div id="myModal" class="modal">
      <div class="modal-content">
          <span class="close" onclick="closeModal()">&times;</span>
          <img src="image/popup.jpeg" alt="Popup Image" width="350px">
      </div>
  </div>
  <script src="scripts/script.js"></script>
  <script>
      window.onload = function() {
          openModal(); // Gọi hàm mở pop-up khi trang được tải
      };
  </script>
  <script src="scripts/script.js"></script>
  </body>
</html>
