<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 11/28/2023
  Time: 11:04 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Sửa thông tin</title>
</head>
<body>
    <form action="user" method="post">
        <input type="text" name="name" placeholder="Name" value="${customer.name}" required/>
        <input type="text" name="phone" placeholder="Phone" value="${customer.phone}" oninput="inputChange(this)" maxlength="10" required/>
        <input type="text" name="address" placeholder="Address" value="${customer.address}" required/>
        <button name="action" value="update" >Chỉnh sửa</button>
    </form>
</body>
</html>
