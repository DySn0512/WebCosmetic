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
