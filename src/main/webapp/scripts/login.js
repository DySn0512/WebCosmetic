const container = document.getElementById('container');
const registerBtn = document.getElementById('register');
const loginBtn = document.getElementById('login');

registerBtn.addEventListener('click', () => {
    container.classList.add('active');
});

loginBtn.addEventListener('click', () => {
    container.classList.remove('active');
});

function isLogin(name,page){
    if (name!==""){
        window.location.href = page;
    }
    else{
        window.location.href = 'login_customer.jsp';
    }
}

