<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" href="style/edit_customer.css">
<html>
<head>
    <title>Sửa thông tin</title>
</head>
<body>
<div class="container">
    <section class="box_info">
        <img src="image/customer.png" alt="logo" width="100px" height="100px">
    </section>
    <h1> Sửa thông tin</h1>
    <form action="user" method="post">
        <div class="inputGroup">
            <input type="text" name="name" placeholder="Name" value="${customer.name}" required>
            <input type="text" name="phone" placeholder="Phone" value="${customer.phone}" oninput="inputChange(this)" maxlength="10" required/>
            <input type="text" name="address" placeholder="Address" value="${customer.address}" required/>
        </div>

        <button class="button" name="action" value="update" >Chỉnh sửa</button>

    </form>
</div>
</body>
</html>
