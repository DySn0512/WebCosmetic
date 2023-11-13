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

function callForm(placeholder, action, idCategory) {
    document.getElementById('add-form').style.display = 'block';
    document.getElementById('new-name').placeholder = placeholder;
    var nameForm = document.getElementById('name-form');
    if (nameForm) {
        nameForm.action = action;
    }
    var idCategoryElement = document.getElementById('id-category');
    if (idCategoryElement) {
        idCategoryElement.value = idCategory;
    }
}

var modal = document.getElementById('addForm');

function x_function() {
    document.getElementById('add-form').style.display = 'none';
}

// Lấy tất cả các form
const forms = document.querySelectorAll('.nameForm');

forms.forEach((form) => {
    const input = form.querySelector('.name');
    const saveInput = form.querySelector('.save-input');
    input.addEventListener('keyup', function (event) {
        if (event.keyCode === 13) {
            event.preventDefault();
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
    const cancelSpan = container.querySelector('.cancel-input');
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
    const editSpan = container.querySelector('.edit-input');
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

function removeParent(element) {
    element.parentNode.remove();
}

function addImage() {
    var x = document.getElementById("img-input").value;
    if (x !== "") {
        document.getElementById("img-input").value = "";

        const div = document.createElement("div");
        div.innerHTML = `
        <input type="button" class="delete-div" onclick="removeParent(this)" value="X">
        <img class="img-product" src="${x}" alt="">
        <input type="hidden" name="strImage" value="${x}">
    `;
        document.getElementById("image-container").appendChild(div);
    }
}
function updateSaleIput(checkbox) {
    var div = checkbox.closest('.detail-item');
    var input = div.querySelector('#sale-price');
    input.required = checkbox.checked;
}
function addProductDetails() {
    var newDiv = document.createElement('div');
    newDiv.className='detail-item';
    newDiv.innerHTML = `
         <input type="button" onclick="removeParent(this)" value="X">
          <input type="hidden" name="idDetail" value="" >
         <div>
            <label>
                Đơn vị sản phẩm:
                <input type="text" name="unit" required>
            </label>
             <label class="right">
                Giảm giá:
                <input type="checkbox" id="is-sale" name="isSale" onchange="updateSaleIput(this)">
            </label>
        </div>
        <div>
            <label>
                Giá:
                <input type="number" id="price" name="price" required pattern="\d*" title="Chỉ được nhập số.">
            </label>
            <label class="right">
                Giá được giảm:
                <input type="number" id="sale-price" name="salePrice" pattern="\d*" title="Chỉ được nhập số.">
            </label>
        </div>
        `;
    document.getElementById('detail-container').appendChild(newDiv);
}

window.onload = function() {
    var checkboxes= document.querySelectorAll('#is-sale');
    checkboxes.forEach(function(checkbox) {
        if (checkbox.checked) {
            updateSaleIput(checkbox);
        }
    });
};










