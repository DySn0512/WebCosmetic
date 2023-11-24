const container = document.getElementById('container');
const registerBtn = document.getElementById('register');
const loginBtn = document.getElementById('login');

registerBtn.addEventListener('click', () => {
    container.classList.add('active');
});

loginBtn.addEventListener('click', () => {
    container.classList.remove('active');
});

function isLogin(name, page) {
    if (name !== "") {
        window.location.href = page;
    } else {
        window.location.href = 'login_customer.jsp';
    }
}

function sendOtp() {
    var nameValue = document.querySelector('input[name="name"]').value;
    var phoneValue = document.querySelector('input[name="phone"]').value;
    var emailValue = document.querySelector('input[name="email"]').value;
    var addressValue = document.querySelector('input[name="address"]').value;
    var passwordValue = document.querySelector('input[name="password"]').value;
    var confirmPasswordValue = document.querySelector('input[name="confirmPassword"]').value;
    if (nameValue === "" || phoneValue === "" || emailValue === "" || addressValue === "" || passwordValue === "" || confirmPasswordValue === "") {
        alert("Vui lòng điền đầy đủ thông tin vào các trường!");
    } else {
        $.ajax({
            type: 'POST',
            url: 'otp',
            data: {
                name: nameValue,
                email: emailValue
            },
        });
    }
}
function registerServlet() {
    var nameValue = document.querySelector('input[name="name"]').value;
    var phoneValue = document.querySelector('input[name="phone"]').value;
    var emailValue = document.querySelector('input[name="email"]').value;
    var addressValue = document.querySelector('input[name="address"]').value;
    var passwordValue = document.querySelector('input[name="password"]').value;
    var confirmPasswordValue = document.querySelector('input[name="confirmPassword"]').value;
    var otpValue = document.querySelector('input[name="otp"]').value;
    if (nameValue === "" || phoneValue === "" || emailValue === "" || addressValue === "" || passwordValue === "" || confirmPasswordValue === "") {
        alert("Vui lòng điền đầy đủ thông tin vào các trường!");
    } else {
        $.ajax({
            type: 'POST',
            url: 'register',
            data: {
                name: nameValue,
                phone: phoneValue,
                email: emailValue,
                address: addressValue,
                password: passwordValue,
                otp:otpValue
            },
            success : [
                function(response) {
                    if(response==="login_customer.jsp")
                    {
                        window.location.href=response;
                    }
                    else {
                        var messageElement = document.getElementById('message');
                        messageElement.innerHTML = response;
                    }
                }
            ]
        });
    }
}
