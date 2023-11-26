<%--@elvariable id="user" type="jdk.javadoc.internal.doclets.toolkit.PropertyUtils"--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Trang Đăng Nhập</title>
    <link rel="stylesheet" type="text/css" href="./style/login.css">
    <link rel="stylesheet" href="https://pro.fontawesome.com/releases/v5.10.0/css/all.css">
</head>
<body>
<div class="container" id="container">
    <div class="form-container sign-up" id="register-form-id">
        <form action="register" method="post">
            <h2>Thông tin người dùng</h2>
            <input type="text" class="inputs" name="name" placeholder="Name" required/>
            <input type="text" name="phone" placeholder="Phone" required oninput="inputChange(this)"  maxlength="10"/>
            <input type="email" name="email" placeholder="Email" required/>
            <input type="text" name="address" placeholder="Address" required/>

            <h2>Thông tin tài khoản</h2>
            <input type="password" name="password" placeholder="Password" id="password" required/>
            <span class="toggle-password" onclick="togglePassword()">👁️</span>

            <input type="password" name="confirmPassword" placeholder="Enter Password" id="confirmPassword" required/>
            <span class="toggle-confirm-password" onclick="toggleConfirmPassword()">👁️</span>

            <h2>Check OTP </h2>
            <div id="spinner"></div>
            <button type="button" onclick="sendOtp()">Gửi OTP</button>
            <input type="text" placeholder="EnterOTP" name="otp" id="otpInput" required>
            <button type="button" onclick="registerServlet()">Đăng kí</button>
            <div id="message"></div>
        </form>
    </div>

    <div class="form-container sign-in">
        <form class="login_form" action="login" method="post" name="form">
            <input type="hidden" name="action" value="customer">
            <h1>Đăng nhập </h1>
            <div class="input-wrapper">
                <input type="text" class="inputs" name="phone" placeholder="Please enter your Phone" value="${phone}" oninput="inputChange(this)" maxlength="10">
                <input type="password" name="password" placeholder="Please enter your Password" id="signInPassword"  value="${password}">
                <span class="toggle-sign-in-password" onclick="toggleSignInPassword()">👁️</span>
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
                <button class="hidden" id="register">Đăng ký</button>
            </div>
        </div>
    </div>
</div>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script src="./scripts/script.js"></script>
<script src="./scripts/login.js"></script>
</body>
</html>