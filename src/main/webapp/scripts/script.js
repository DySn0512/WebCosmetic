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

function removeDetailProduct(element, id) {
    element.parentNode.remove();
    if (id !== "") {
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

function drop(ev) {
    ev.preventDefault();
    Array.from(ev.dataTransfer.files).forEach(file => {
        const reader = new FileReader();
        reader.onload = function (e) {
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
// Hiển thị popup
// Hàm mở pop-up
function openModal() {
    document.getElementById('myModal').style.display = 'block';
    document.getElementById('overlay').style.display = 'block';
}

// Hàm đóng pop-up
function closeModal() {
    document.getElementById('myModal').style.display = 'none';
    document.getElementById('overlay').style.display = 'none';
}

// Đóng pop-up khi click ra ngoài
window.onclick = function (event) {
    var modal = document.getElementById('myModal');
    if (event.target == modal) {
        closeModal();
    }
};

function selectPage(element) {
    // Loại bỏ lớp 'selected' từ tất cả các liên kết trang
    const pages = document.querySelectorAll("#pagination a");
    pages.forEach(page => page.classList.remove("selected"));

    // Thêm lớp 'selected' cho trang được chọn
    element.classList.add("selected");
}

function decreaseNumber() {
    var numberField = document.getElementById('number');
    var currentValue = parseInt(numberField.value);

    // Giảm giá trị số lượng không dưới 1
    if (currentValue > 1) {
        numberField.value = currentValue - 1;
    }
}

function increaseNumber() {
    var numberField = document.getElementById('number');
    var currentValue = parseInt(numberField.value);

    // Tăng giá trị số lượng
    numberField.value = currentValue + 1;
}

function checkSelect() {
    var id = document.getElementById('id-detail').value;
    if (id === null || id === "") {
        event.preventDefault();
        alert('Vui lòng chọn 1 phân loại sản phẩm');
    }
}

function removeLineItem(id, button) {
    $.ajax({
        type: 'POST',
        url: 'cart',
        data: {
            action: 'remove',
            idDetailProduct: id,
        }
    });
    var row = button.parentNode.parentNode;
    row.parentNode.removeChild(row);
    totalPrice();
}

function setAction(action) {
    const form = document.getElementById('cart-form');
    form.action = action;
    totalPrice();
}

function inputChange(element) {
    let value = element.value;
    element.value = value.replace(/[^0-9]/g, '');
}

function decreaseQuanity(button, id) {
    let input = button.parentElement.querySelector('input[type="text"]');
    let numericValue = parseInt(input.value);
    if (numericValue > 1) {
        input.value = numericValue - 1;
        updateLineItem(id, input.value);
    }
}

function increaseQuanity(button, id) {
    let input = button.parentElement.querySelector('input[type="text"]');
    let numericValue = parseInt(input.value);
    input.value = numericValue + 1;
    updateLineItem(id, input.value);
}

function handleBlur(element, id) {
    if (element.value === "" || parseInt(element.value) < 1) {
        element.value = 1;
    }
    updateLineItem(id, element.value);
}

async function updateLineItem(id, quantity) {
    totalPrice()
    await $.ajax({
        type: 'POST',
        url: 'cart',
        data: {
            action: 'update',
            idDetailProduct: id,
            quantity: quantity
        }
    });
}

function changeAutoComplete(value) {
    var options = document.querySelectorAll('.brand, .category, .subCategory');
    options.forEach(option => option.disabled = true);
    options = document.querySelectorAll('.' + value);
    options.forEach(option => option.disabled = false);

}

function searchProduct() {
    var isSaleValue = document.querySelector('input[name="isSale"]:checked').value;
    var findByValue = document.querySelector('select[name="findBy"]').value;
    var searchValue = document.querySelector('input[name="search"]').value;
    $.ajax({
        type: 'POST',
        url: 'product',
        data: {
            action: 'find',
            findBy: findByValue,
            search: searchValue,
            isSale: isSaleValue
        },
        success: function (data) {
            var newTbody = $(data).find("#productTable tbody").html();
            $("#productTable tbody").html(newTbody);
        }
    });
}

function checkEnter() {
    if (event.key === "Enter") {
        event.preventDefault();
        var button = document.getElementById("find");
        button.click();
    }
}


function selectDetail(sale, price, salePrice, id, button) {
    var priceDisplay = document.getElementById('price-display');
    if (sale) {
        priceDisplay.innerHTML = "<del>" + price + "</del> " + salePrice;
    } else {
        priceDisplay.textContent = price;
    }
    document.getElementById('id-detail').value = id;
    var buttons = document.querySelectorAll('.select-detail');
    buttons.forEach(item => item.classList.remove('active'));
    button.classList.add('active');
}

document.addEventListener("DOMContentLoaded", function () {
    var breadcrumbLinks = document.querySelectorAll(".breadcrumb a:not(:last-child)");

    breadcrumbLinks.forEach(function (link) {
        link.style.opacity = "0.7"; // Làm mờ các mục ngoại trừ mục cuối cùng

        link.addEventListener("mouseenter", function () {
            this.style.opacity = "1"; // Loại bỏ hiệu ứng làm mờ khi rê chuột vào
        });

        link.addEventListener("mouseleave", function () {
            this.style.opacity = "0.7"; // Áp dụng hiệu ứng làm mờ lại khi rời chuột ra
        });
    });
});

function updateOrder(id, status) {
    $.ajax({
        type: 'POST',
        url: 'order',
        data: {
            action: 'update',
            id: id,
            status: status,
        },
    });
}

function totalPrice() {
    var checkboxes = document.querySelectorAll('input[name="idDetailProduct"]:checked');
    var priceTotalValue = BigInt(0);


    checkboxes.forEach(function (checkbox) {
        const tr = checkbox.parentElement.parentElement;
        const currentPrice = BigInt(tr.querySelector('input[name="currentPrice"]').value);
        const quantity = BigInt(tr.querySelector('input[name="quantity"]').value);
        console.log(quantity);
        priceTotalValue += currentPrice * quantity;
    });
    document.getElementById("price-total").innerHTML = priceTotalValue;
}

function selectOrder(id) {
    window.location.href = "order?action=show&id=" + id;
}

function searchOrder(status) {
    $.ajax({
        type: 'POST',
        url: 'order',
        data: {
            status: status
        },
        success: function (data) {
            var newTbody = $(data).find("table tbody").html();
            $("table tbody").html(newTbody);
        }
    });
}

function changeImg(src) {
    document.getElementById('main-img').src = src;
}
function showproduct(href){
    window.location.href=href;
}

function searchUserOrder(status) {
    $.ajax({
        type: 'GET',
        url: 'order',
        data: {
            action:"view",
            status: status
        },
        success: function (data) {
            var newbody = $(data).find("#button_click").html();
            $("#button_click").html(newbody);
            var parser = new DOMParser();
            var doc = parser.parseFromString(data, 'text/html');
            var orderHistoryElement = doc.getElementById('order_history');
            $("#order_history").html(orderHistoryElement.innerHTML);
        }
    });
}