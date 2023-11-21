const container = document.getElementById('container');
const registerBtn = document.getElementById('register');
const loginBtn = document.getElementById('login');

registerBtn.addEventListener('click', () => {
    container.classList.add('active');
});

loginBtn.addEventListener('click', () => {
    container.classList.remove('active');
});

function isLogin(name){
    if (name!==""){
        console.log("đăng nhập rồi")
    }
    else{
        window.location.href = 'login_customer.jsp';
    }

}

