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
                    header.style.border = "1px solid rgba(0, 0, 0, 0.1)";
                }
            }
        });
        sidebar.addEventListener('mouseleave', function () {
            if (!isExpanded) {
                var currentWidth = parseInt(window.getComputedStyle(sidebar).width);
                if (currentWidth === 280) {
                    sidebar.style.width = '70px';
                    header.style.border = "none";
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
}

function expandSidebar() {
    var sidebar = document.querySelector('.sidebar');
    var header = sidebar.querySelector("header");
    var currentWidth = parseInt(window.getComputedStyle(sidebar).width);
    if (currentWidth === 70) {
        $(".main-content").animate({marginLeft: "280px"}, 200);
        sidebar.style.width = '280px';
        header.style.border = "1px solid rgba(0, 0, 0, 0.1)";
        isExpanded = true;
    } else {
        $(".main-content").animate({marginLeft: "70px"}, 200);
        sidebar.style.width = '70px';
        header.style.border = "none";
        isExpanded = false;
    }
}

function callForm(placeholder, value, idCategory) {
    document.getElementById('id-category').value = idCategory;
    document.getElementById('add-form').style.display = 'block';
    document.getElementById('name-form').value = value;
    document.getElementById('new-name').placeholder = placeholder;
}

var modal = document.getElementById('addForm');

function x_function() {
    document.getElementById('add-form').style.display = 'none';
}

// Lấy tất cả các form
const forms = document.querySelectorAll('.nameForm');

// Duyệt qua từng form
forms.forEach((form) => {
    // Trong mỗi form, lấy phần tử input và saveInput
    const input = form.querySelector('.name');
    const saveInput = form.querySelector('.save-input');

    // Thêm sự kiện 'keyup' cho phần tử input
    input.addEventListener('keyup', function (event) {
        // Number 13 is the "Enter" key on the keyboard
        if (event.keyCode === 13) {
            // Cancel the default action, if needed
            event.preventDefault();
            // Trigger the button element with a click
            saveInput.click();
        }
    });
});

function toggleSubcategories(category) {
    const subcategories = category.nextElementSibling;
    const toggleIcon = category.querySelector(".toggle-icon");
    toggleIcon.textContent = subcategories.style.display === "block" ? "▶" : "▼";
    if (subcategories) {
        subcategories.style.display = subcategories.style.display === "block" ? "none" : "block";
    }
}

function editInput(clickedElement) {
    event.stopPropagation();
    const container = clickedElement.parentNode
    const saveInput = container.querySelector('.save-input');
    const deleteInput = container.querySelector('.delete-input');
    const cancelSpan = container.querySelector('.cancel-span');
    clickedElement.style.display = 'none';
    deleteInput.style.display = 'none';
    saveInput.style.display = 'inline';
    cancelSpan.style.display = 'inline';
    const form = container.parentNode;
    const input = form.querySelector('.name');
    input.disabled = false;
    input.style.pointerEvents = 'auto';
    input.focus();
}

function cancelEdit(clickedElement, name) {
    event.stopPropagation();
    const container = clickedElement.parentNode;
    const saveInput = container.querySelector('.save-input');
    const deleteInput = container.querySelector('.delete-input');
    const editSpan = container.querySelector('.edit-span');
    clickedElement.style.display = 'none';
    saveInput.style.display = 'none';
    deleteInput.style.display = 'inline';
    editSpan.style.display = 'inline';
    const form = container.parentNode;
    const input = form.querySelector('.name');
    input.value = name;
    input.disabled = true;
    input.style.pointerEvents = 'none';
}

// function addInput(spanElement,name) {
//     var newInput = document.createElement("input");
//     newInput.setAttribute("type", "text");
//     newInput.setAttribute("name", name);
//     newInput.classList.add("inputadd");
//     newInput.addEventListener("keydown", function(event) {
//         if (event.key === "Enter") {
//             newInput.blur();
//         }
//     });
//     newInput.addEventListener("blur", function() {
//         if (newInput.value.length===0){
//             newInput.remove();
//         }
//     });
//     var newBr = document.createElement("br");
//     spanElement.parentNode.insertBefore(newInput, spanElement.nextSibling);
//     spanElement.parentNode.insertBefore(newBr, spanElement.nextSibling);
// }


