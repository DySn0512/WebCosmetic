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
                <input type="hidden" name="action" value="customer">
                <h2>Thông tin người dùng</h2>
                <input type="text" class="inputs" name="name" placeholder="Name"/>
                <input type="text" name="phone" placeholder="Phone"/>
                <input type="email" name="email" placeholder="Email"/>
                <input type="text" name="address" placeholder="Address"/>
                <h2>Thông tin tài khoản</h2>
                <input type="text" name="userName" placeholder="UserName"/>
                <div>
                    <input type="password" name="password" placeholder="Password" />
                    <div class="indicator">
                        <span class="weak"></span>
                        <span class="medium"></span>
                        <span class="strong"></span>
                    </div>
                    <div class="text"></div>
                </div>
                <input type="password" placeholder="EnterPassword" required>
                <input type="submit" value="Register"/>
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
                    <div class="remember-sign-in">
                        <label><input type="checkbox" name=""> Nhớ mật khẩu</label>
                    </div>
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
                    <p>Nhập thông tin cá nhân của bạn để sử dụng tất cả các tính năng của trang web</p>
                    <button class="hidden" id="login">Đăng nhập</button>
                </div>
                <div class="toggle-panel toggle-right">
                    <h1>Xin chào, bạn!</h1>
                    <p>Đăng ký với thông tin cá nhân của bạn để sử dụng tất cả các tính năng của trang web</p>
                    <button class="hidden" id="register" >Đăng ký</button>
                </div>
            </div>
        </div>
    </div>
    <script src="./scripts/login.js"></script>
</body>
</html>
