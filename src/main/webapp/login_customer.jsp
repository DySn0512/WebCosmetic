<%--@elvariable id="user" type="jdk.javadoc.internal.doclets.toolkit.PropertyUtils"--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>

    <title>Trang Đăng Nhập</title>
    <link rel="stylesheet" type="text/css" href="./style/login.css">
</head>
<body>
    <div class="container" id="container">
        <div class="form-container sign-up" id="register-form-id">
            <form action="register" method="post">
                <h2>Thông tin người dùng</h2>
                <input type="text" class="inputs" name="name" placeholder="Name" required/>
                <input type="number" name="phone" placeholder="Phone" required/>
                <input type="email" name="email" placeholder="Email" required/>
                <input type="text" name="address" placeholder="Address" required/>

                <h2>Thông tin tài khoản</h2>
                <input type="password" name="password" placeholder="Password" required/>
                <input type="password" placeholder="EnterPassword" required>
                <button type="submit">Đăng kí</button>
                <div id="message">${message}</div>
            </form>
        </div>

        <div class="form-container sign-in">
            <form class="login_form" action="login" method="post" name="form">
                <input type="hidden" name="action" value="customer">
                <h1>Đăng nhập </h1>
                <div class="input-wrapper">
                    <input autocomplete="off" type="text" class="inputs" name="phone" placeholder="Please enter your Phone">
                    <input type="password" name="password" placeholder="Please enter your Password" autocomplete="off">
                </div>

                <div class="checkbox-container">
                    <label class="checkbox" for="checkbox">
                        <input type="checkbox" id="checkbox" name="savedPassword">
                    </label>
                    <label for="checkbox" class="checkbox-text">Nhớ mật khẩu</label>
                </div>

                <a href="toForgetPassword">Quên mật khẩu?</a>
                <button type="submit">Đăng nhập</button>
                <p>${message}</p>
            </form>
        </div>


        <div class="toggle-container">
            <div class="toggle">
                <div class="toggle-panel toggle-left">
                    <h1>Xin chào,</h1>
                    <p>Nhập thông tin cá nhân của bạn thông tin cá nhân của bạn để mua hàng tiện liện và nhanh chóng</p>
                    <button class="hidden" id="login">Đăng nhập</button>
                </div>

                <div class="toggle-panel toggle-right">
                    <h1>Xin chào</h1>

                    <p>Đăng ký với thông tin cá nhân của bạn để mua hàng tiện liện và nhanh chóng</p>
                    <button class="hidden" id="register" >Đăng ký</button>
                </div>
            </div>
        </div>
    </div>
<script src="./scripts/login.js"></script>
</body>
</html>
