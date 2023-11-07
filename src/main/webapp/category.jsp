<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 10/31/2023
  Time: 1:50 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Danh Mục</title>
    <link rel="stylesheet" href="style/main.css">
    <style>

        .category {
            list-style-type: none;
            margin: 0;
            padding: 0;
        }

        .category li {
            background-color: #f0f0f0;
            border: 1px solid #ddd;
            margin: 5px;
            padding: 10px;
            cursor: pointer;
            width: 600px;
        }

        .subcategory {
            list-style-type: none;
            margin: 0;
            padding: 0;
            display: none;
        }

        .subcategory li {
            background-color: #f9f9f9;
            border: 1px solid #ccc;
            margin: 5px;
            padding: 5px;
            max-width: 500px;
        }
    </style>
</head>
<body>

<jsp:include page="sidebar.jsp"/>
<div class="main-content">
    <header style="height: 70px">
        <div id="IconSidebar" onclick="expandSidebar()">&#9776;</div>
        <nav aria-label="breadcrumb">
            <ol class="breadcrumb">
                <li class="breadcrumb-item"><a href="admin.jsp">Trang Chủ</a></li>
                <li class="breadcrumb-item active" aria-current="page">/Danh Mục</li>
            </ol>
        </nav>
    </header>
    <div>
        <button onclick="callForm()">Ẩn Form</button>
        <form style="display: none;" id="myForm" >
            <input type="text" >
            <input type="submit" value="Thêm danh mục" >
        </form>
        <ul class="category">
            <c:forEach items="${dataMap}" var="entry">
                <li><span class="toggle-icon">▶</span>${entry.key}
                    <ul class="subcategory">
                        <c:forEach items="${entry.value}" var="subcategory">
                            <li>${subcategory}</li>
                        </c:forEach>
                    </ul>
                </li>
            </c:forEach>
        </ul>
        <script>
            function callForm() {
                var form = document.getElementById("myForm");
                form.style.display = 'block';
            }
            const categoryItems = document.querySelectorAll('.category > li');

            categoryItems.forEach(categoryItem => {
                categoryItem.addEventListener('click', () => {
                    const subcategory = categoryItem.querySelector('.subcategory');
                    const toggleIcon = categoryItem.querySelector('.toggle-icon');
                    if (subcategory.style.display === 'block') {
                        subcategory.style.display = 'none';
                        toggleIcon.innerHTML = '▶';
                    } else {
                        subcategory.style.display = 'block';
                        toggleIcon.innerHTML = '▼';
                    }
                });
            });
        </script>
    </div>
</div>
</body>
</html>
