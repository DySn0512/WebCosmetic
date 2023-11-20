<%--
  Created by IntelliJ IDEA.
  User: huynhthihuyentrang
  Date: 20/11/2023
  Time: 14:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <style>
    body {
      font-family: 'Inconsolata', monospace;
    }
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
      font-family: 'Inconsolata', monospace;
      font-size: 20px; /* Kích thước chữ */
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
  </style>
  <link href="https://fonts.googleapis.com/css2?family=Inconsolata&display=swap" rel="stylesheet">
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
        <a href="./login_customer.jsp">
          <img src="image/account.png" alt="Tài khoản cá nhân"/>
        </a>
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
</head>
<body>

</body>
</html>
