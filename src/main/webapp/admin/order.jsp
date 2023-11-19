<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
  <meta charset="UTF-8">
  <title>Order</title>
  <link rel="stylesheet" href="../style/dysn.css">
</head>
<body>
<jsp:include page="/admin/sidebar.jsp"/>
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
    <h1>Quản lý đơn hàng</h1>
    <table>
      <thead>
      <tr>
        <th>Số đơn hàng</th>
        <th>Tên khách hàng</th>
        <th>Số Điện Thoại</th>
        <th>Email</th>
        <th>Địa chỉ</th>
        <th>Tên Sản phẩm</th>
        <th>Số lượng</th>
        <th>Đơn vị</th>
        <th>Giá</th>
        <th>Thành tiền</th>
      </tr>
      </thead>
      <tbody>
      <tr>
        <td>1</td>
        <td></td>
        <td></td>
        <td></td>
        <td></td>
        <td></td>
        <td></td>
        <td></td>
        <td></td>
        <td></td>
      </tr>
      <tr>
        <td></td>
        <td></td>
        <td></td>
        <td></td>
        <td></td>
        <td></td>
        <td></td>
        <td></td>
        <td></td>
        <td></td>
      </tr>
      </tbody>
    </table>
</div>

</body>
</html>
