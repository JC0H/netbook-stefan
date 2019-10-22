var productId,
    brand,
    model,
    processor,
    graphics,
    memory,
    screen,
    ram,
    image,
    network,
    color,
    weight,
    operatingSystem,
    usb,
    additionalInformation,
    price,
    rowNumber,
    delimiter = ', ';

function getAllProducts() {
    $.ajax({
        type: "GET",
        dataType: "json",
        contentType: "application/json",
        data: "",
        url: "api/stefan/notebook/products",
        success: productSuccess,
        error: function (response) {
            alert('error');
        }
    });
}

function productSuccess(data) {
    rowNumber = 0;
    $("#products-table").empty();
    $(data).each(function () {
        productId = this.id;
        brand = this.brand;
        model = this.model;
        processor = this.processor;
        graphics = this.graphics;
        memory = this.memory;
        screen = this.screen;
        ram = this.ram;
        network = this.network;
        color = this.color;
        weight = this.weight;
        operatingSystem = this.operatingSystem;
        usb = this.usb;
        additionalInformation = this.additionalInformation;
        price = this.price;

        loadProducts(
            productId,
            brand,
            model,
            processor,
            graphics,
            memory,
            screen,
            ram,
            network,
            color,
            weight,
            operatingSystem,
            usb,
            additionalInformation,
            price
        );
    });
}

function loadProducts(productId,
                      brand, model, processor, graphics, memory, screen, ram, network, color, weight,
                      operatingSystem, usb, additionalInformation, price
) {
    var html = '';
    var productTable = $('#products-table');
    html += "<div class='product-description" + productId + "' style='width:50%;border: 1px solid #dddddd;background:navajowhite'>" +
        "<img src='../../img/lenovo-laptop-330-a9-8gb-256ssd-w10,42833394161_7.jpg' " +
        "alt='image' style='width:50px;height:50px'><br>" +
        brand + delimiter + model + delimiter +
        processor + delimiter + graphics + delimiter + ram + delimiter +
        operatingSystem + delimiter + price +
        "<button id='delete-product' class='delete-product-class' onclick='deleteProductById(" + productId + ")'>Delete</button>" +
        "<button id='update-product' class='update-product-class' onclick='findProductToUpdate(" + productId + ")'>Update</button>" +
        "</div>";
    productTable.append(html);
}

$(document).ready(function () {
    getAllProducts();
});