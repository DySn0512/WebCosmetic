<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
  <meta charset="UTF-8">
  <title>Order</title>
  <link rel="stylesheet" href="style/dysn.css">
</head>
<body>
<jsp:include page="sidebar.jsp"/>
<div class="main-content">
  <header style="height: 70px">
    <div id="IconSidebar" onclick="expandSidebar()">&#9776;</div>
    <nav aria-label="breadcrumb">
      <ol class="breadcrumb">
        <li class="breadcrumb-item"><a href="admin.jsp">Trang Chủ</a></li>
        <li class="breadcrumb-item active" aria-current="page">/Order</li>
      </ol>
    </nav>
  </header>
  <div style="margin: 10px">
    <div class="admin-container">
      <h2>Quản lý đơn hàng</h2>
      <table>
        <thead>
        <tr>
          <th>Số đơn hàng</th>
          <th>Sản phẩm</th>
          <th>Số lượng</th>
          <th>Khách hàng</th>
          <th>Địa chỉ</th>
          <th>Trạng thái</th>
        </tr>
        </thead>
        <tbody>
        <tr>
          <!-- Đây là nơi bạn có thể thêm dữ liệu từ cơ sở dữ liệu hoặc thông tin đơn hàng -->
        </tr>
          <!-- Thêm các dòng khác tương ứng với các đơn hàng -->
        </tbody>
      </table>
    </div>

    <!-- Container cho thông tin chi tiết đơn hàng -->
    <div class="container">
      <div class="card cart">
        <label class="title">Số đơn hàng: </label><br>
        <label class="title">Sản phẩm: </label><br>
        <label class="title">Số lượng: </label><br>
        <label class="title">Khách hàng: </label><br>
        <label class="title">Địa chỉ: </label><br>
        <label class="title">Trạng thái: </label><br>
      </div>
    </div>
  </div>
</div>
</body>
</html>
