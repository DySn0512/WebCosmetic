<%--@elvariable id="user" type="jdk.javadoc.internal.doclets.toolkit.PropertyUtils"--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Quên Mật Khẩu</title>
    <link rel="stylesheet" type="text/css" href="./style/login.css">
</head>
<body>
<input type="email" name="email" placeholder="Email" required/>

<input type="password" name="password" placeholder="Password" id="password" required/>
<span class="toggle-password" onclick="togglePassword()">👁️</span>

<input type="password" name="confirmPassword" placeholder="Enter Password" id="confirmPassword" required/>
<span class="toggle-confirm-password" onclick="toggleConfirmPassword()">👁️</span>

<button type="button" onclick="sendOtpRepassword()">Gửi OTP</button>
<div id="spinner"></div>
<input type="text" placeholder="EnterOTP" name="otp" id="otpInput" required>
<button type="button" onclick="userServlet()">Đổi Mật Khẩu</button>
<div id="message"></div>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script src="./scripts/login.js"></script>
</body>
</html>