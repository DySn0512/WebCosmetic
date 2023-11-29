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
  </head>
  <body>
  <div class="slideshow-container">
      <div class="mySlides fade">
          <img src="image/slide1.jpg" width="100%" alt="">
      </div>
      <div class="mySlides fade">
          <img src="image/slide4.jpg" width="100%" alt="">
      </div>
      <div class="mySlides fade">
          <img src="image/slide3.jpg" width="100%" alt="">
      </div>

  </div>
  <div class="black-friday-banner">
      <p>GET THE BEST DEAL THIS BLACK FRIDAY - SALE OFF UP TO 40% </p>
  </div>
  <div class="product-container">
      <c:forEach items="${products}" var="product">
          <div class="product">
              <div class="product-image">
                  <a href="detail?name=${product.name}">
                      <img src="${product.images[0].link}" alt="">
                  </a>
              </div>
              <a class="product-name" href="detail?name=${product.name}">
                  <p>${product.name}</p>
              </a>
              <p class="product-price">${product.price}</p>
          </div>
      </c:forEach>
  </div>
  <!-- Hiển thị phân trang -->
  <div id="pagination-container">
      <div id="pagination">
          <!-- Hiển thị các liên kết chuyển trang -->
          <c:forEach begin="${startPage}" end="${endPage}" var="i">
              <a href="${find}${i}" onclick="selectPage(this)" class="${i eq currentPage ? 'current-page' : ''}">${i}</a>
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
  </body>
</html>
