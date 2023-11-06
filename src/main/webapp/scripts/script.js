var isExpanded = false;
document.addEventListener('DOMContentLoaded', function () {
    var sidebar = document.querySelector('.sidebar');
    var header = sidebar.querySelector("header");
    if (sidebar) {
        sidebar.addEventListener('mouseenter', function () {
            if (!isExpanded) {
                var currentWidth = parseInt(window.getComputedStyle(sidebar).width);
                if (currentWidth === 70) {
                    sidebar.style.width = '280px';
                    header.style.border="1px solid rgba(0, 0, 0, 0.1)";
                }
            }
        });
        sidebar.addEventListener('mouseleave', function () {
            if (!isExpanded) {
                var currentWidth = parseInt(window.getComputedStyle(sidebar).width);
                if (currentWidth === 280) {
                    sidebar.style.width = '70px';
                    header.style.border="none";
                }
            }
        });
    }
});
function loadContent(servlet) {
    window.location.href = servlet;
}

function setAction(value) {
    document.getElementById("action").value = value;
    console.log("ại")
}

function expandSidebar() {
    var sidebar = document.querySelector('.sidebar');
    var header = sidebar.querySelector("header");
    var currentWidth = parseInt(window.getComputedStyle(sidebar).width);
    if (currentWidth === 70) {
        $(".main-content").animate({ marginLeft: "280px" }, 200);
        sidebar.style.width = '280px';
        header.style.border= "1px solid rgba(0, 0, 0, 0.1)";
        isExpanded = true;
    } else {
        $(".main-content").animate({ marginLeft: "70px" }, 200);
        sidebar.style.width = '70px';
        header.style.border= "none";
        isExpanded = false;
    }
}

