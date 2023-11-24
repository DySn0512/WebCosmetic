function toggleInfo(infoType) {
    var infoElement = document.getElementById(infoType + 'Info');
    infoElement.style.display = infoElement.style.display === 'none' ? 'block' : 'none';
}

function togglePassword() {
    var passwordInfo = document.getElementById('passwordInfo');
    var passwordElement = document.getElementById('password');
    if (passwordElement.type === 'password') {
        passwordElement.type = 'text';
        passwordInfo.innerHTML = ''; // Display the password
    } else {
        passwordElement.type = 'password';
        passwordInfo.innerHTML = ''; // Clear the displayed password
    }
}
function logout() {
    var xhr = new XMLHttpRequest();
    xhr.open("POST", "logout", true);
    xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");

    xhr.onreadystatechange = function() {
        if (xhr.readyState === XMLHttpRequest.DONE) {
            if (xhr.status === 200) {
                // Hiển thị thông báo đăng xuất thành công
                document.getElementById("message").innerText = xhr.responseText;
                // Chuyển hướng đến trang home sau 2 giây
                setTimeout(function() {
                    window.location.href = "home"; // Thay đổi đường dẫn đến trang home tại đây
                }, 2000); // Chuyển hướng sau 2 giây (2000ms)
            } else {
                console.error("Đã xảy ra lỗi trong quá trình đăng xuất.");
            }
        }
    };

    xhr.send();
}