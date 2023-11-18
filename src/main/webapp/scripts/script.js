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

function removeDetailProduct(element,id) {
    element.parentNode.remove();
    if (id!==""){
        var input = document.createElement("input");
        input.type = "hidden";
        input.value = id;
        input.name = "detailRemove";
        document.getElementById('detail-container').appendChild(input);
    }
}
function removeImage(element) {
    element.parentNode.remove();
}
function allowDrop(ev) {
    ev.preventDefault();
}

function drop(ev){
    ev.preventDefault();
    Array.from(ev.dataTransfer.files).forEach(file => {
        const reader = new FileReader();
        reader.onload = function(e) {
            const div = document.createElement("div");
            div.className = "image-item";
            div.innerHTML = `<input type="hidden" value="${e.target.result}" name="strImage">
                             <input type="button" class="delete-div" onclick="removeImage(this)" value="X">
                             <img class="img-product" src="${e.target.result}" alt="">`;
            document.getElementById("image-container").appendChild(div);
        };
        reader.readAsDataURL(file);
    });
}


function updateSaleIput(checkbox) {
    var div = checkbox.closest('.detail-item');
    var inputSalePrice = div.querySelector('#sale-price');
    var inputIsSale = div.querySelector('#is-sale');
    inputSalePrice.required = checkbox.checked;
    inputIsSale.value = checkbox.checked;
}

function addDetailProduct() {
    var newDiv = document.createElement('div');
    newDiv.className = 'detail-item';
    newDiv.innerHTML = `
         <input type="button" onclick="removeDetailProduct(this,'')" value="X">
          <input type="hidden" name="idDetail" value="" >
         <div>
            <label>
                Đơn vị sản phẩm:
                <input type="text" name="unit" required>
            </label>
             <label class="right">
                Giảm giá:
                <input type="hidden" name="isSale" value="false" id="is-sale" >
                <input type="checkbox" value="false" onclick="updateSaleIput(this)">
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

window.onload = function () {
    var checkboxes = document.querySelectorAll('#is-sale');
    checkboxes.forEach(function (checkbox) {
        if (checkbox.checked) {
            updateSaleIput(checkbox);
        }
    });
};

function submitProductForm(form) {
    var divDetails = form.getElementsByClassName('detail-item');
    var divImages = form.getElementsByClassName('image-item');
    if (divDetails.length === 0 || divImages.length === 0) {
        event.preventDefault();
        alert('phải có ít nhất 1 chi tiết sản phẩm và 1 hình ảnh ứng với mỗi sản phẩm');
    }
}
let slideIndex = 0;
const slides = document.querySelectorAll('.mySlides');

function showSlides() {
    for (let i = 0; i < slides.length; i++) {
        slides[i].style.opacity = '0'; // Ẩn tất cả ảnh
    }
    slideIndex++;
    if (slideIndex > slides.length) {
        slideIndex = 1;
    }
    slides[slideIndex - 1].style.opacity = '1'; // Hiển thị ảnh tiếp theo

    setTimeout(showSlides, 4000); // Chuyển đổi ảnh sau 4 giây
}

showSlides(); // Bắt đầu hiển thị ảnh









