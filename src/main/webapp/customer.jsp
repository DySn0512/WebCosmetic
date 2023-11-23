<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 11/22/2023
  Time: 12:34 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" href="style/customer.css">
<html>
<head>
    <title>Thông tin cá nhân</title>
</head>
<body>
<div class="container">
    <div class="box">
        <header class="box_header">
            <div class="icon">
                <i class="fa-solid fa-angle-left"></i>
            </div>
            <div class="yourFile">
                <p>Thông tin cá nhân</p>
            </div>
        </header>

        <section class="box_info">
            <div class="avatar">
                <img src="https://i.pinimg.com/originals/89/9d/ba/899dbae8d1a12e57a17feabced8ebe61.jpg" alt="">
                <input type="file" name="" id="form_file">
            </div>

            <div class="info">
                <p class="name">//Tên</p>
            </div>

            <label for="form_file" class="edit">
                <i class="fa-solid fa-pen-to-square"></i>
            </label>
        </section>


        <aside class="box_content">
            <div class="idea">
                <nav class="dashboard first">
                    <div class="adventure">
                        <div class="menu">
                            <div class="circle">
                                <div class="cursor">
                                    <i class="bi bi-credit-card"></i>
                                </div>
                                <span>Họ và tên</span>
                            </div>

                            <div class="notify">
                                //Thông tin tên
                            </div>
                        </div>

                        <div class="menu">
                            <div class="circle">
                                <div class="cursor">
                                    <i class="bi bi-shield-check"></i>
                                </div>
                                <span>Số điện thoại</span>
                            </div>

                            <div class="notify">
                                //03735986
                            </div>
                        </div>

                        <div class="menu">
                            <div class="circle">
                                <div class="cursor">
                                    <i class="bi bi-shield-check"></i>
                                </div>
                                <span>Email</span>
                            </div>

                            <div class="notify">
                                //..@gmail.com
                            </div>
                        </div>

                        <div class="menu">
                            <div class="circle">
                                <div class="cursor">
                                    <i class="bi bi-shield-check"></i>
                                </div>
                                <span>Addres</span>
                            </div>

                            <div class="notify">
                                //7/1
                            </div>
                        </div>

                        <div class="menu">
                            <div class="circle">
                                <div class="cursor">
                                    <i class="bi bi-shield-check"></i>
                                </div>
                                <span>Password</span>
                            </div>

                            <div class="notify">
                                //0373586
                            </div>
                        </div>
                    </div>
                </nav>
            </div>
        </aside>
        <button class="continue-application">
            <div>
                <div class="pencil"></div>
                <div class="folder">
                    <div class="top">
                        <svg viewBox="0 0 24 27">
                            <path d="M1,0 L23,0 C23.5522847,-1.01453063e-16 24,0.44771525 24,1 L24,8.17157288 C24,8.70200585 23.7892863,9.21071368 23.4142136,9.58578644 L20.5857864,12.4142136 C20.2107137,12.7892863 20,13.2979941 20,13.8284271 L20,26 C20,26.5522847 19.5522847,27 19,27 L1,27 C0.44771525,27 6.76353751e-17,26.5522847 0,26 L0,1 C-6.76353751e-17,0.44771525 0.44771525,1.01453063e-16 1,0 Z"></path>
                        </svg>
                    </div>
                    <div class="paper"></div>
                </div>
            </div>
            Sửa thông tin cá nhân
        </button>

        <button class="continue-application">
            <div>
                <div class="pencil"></div>
                <div class="folder">
                    <div class="top">
                        <svg viewBox="0 0 24 27">
                            <path d="M1,0 L23,0 C23.5522847,-1.01453063e-16 24,0.44771525 24,1 L24,8.17157288 C24,8.70200585 23.7892863,9.21071368 23.4142136,9.58578644 L20.5857864,12.4142136 C20.2107137,12.7892863 20,13.2979941 20,13.8284271 L20,26 C20,26.5522847 19.5522847,27 19,27 L1,27 C0.44771525,27 6.76353751e-17,26.5522847 0,26 L0,1 C-6.76353751e-17,0.44771525 0.44771525,1.01453063e-16 1,0 Z"></path>
                        </svg>
                    </div>
                    <div class="paper"></div>
                </div>
            </div>
            Đổi password
        </button>
        <button class="Btn">
            <div class="sign">
                <img src="image/output.png">
            </div>
            <div class="text">Logout</div>
        </button>
    </div>
</div>

<script src="./scripts/customer.js"></script>
</body>
</html>
