var product,
    productDetails,
    productId,
    brand,
    detailsId,
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
    products = {},
    rowNumber,
    delimeter = ', ';

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
        product = this;
        productId = this.id;
        brand = product.brand;
        productDetails = this.productDetailsDtoList;

        $(productDetails).each(function () {
            rowNumber++;
            detailsId = this.id;
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

            products[detailsId] = {
                productId: productId,
                brand: brand,
                detailsId: detailsId,
                model: model,
                processor: processor,
                graphics: graphics,
                memory: memory,
                screen: screen,
                ram: ram,
                network: network,
                color: color,
                weight: weight,
                operatingSystem: operatingSystem,
                usb: usb,
                additionalInformation: additionalInformation,
                price: price
            };
            loadProducts(
                brand,
                detailsId,
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
    })
}

function loadProducts(
    brand, givenProductId, model, processor, graphics, memory, screen, ram, network, color, weight,
    operatingSystem, usb, additionalInformation, price
) {
    var html = '';
    var productTable = $('#products-table');
    html += "<div class='product-description" + givenProductId + "' style='width:50%;border: 1px solid #dddddd;background:navajowhite'>" +
        "<img src='../../img/lenovo-laptop-330-a9-8gb-256ssd-w10,42833394161_7.jpg' " +
        "alt='image' style='width:50px;height:50px'><br>" +
        brand + delimeter + model + delimeter +
        processor + delimeter + graphics + delimeter + ram + delimeter +
        operatingSystem + delimeter + price +
        "<button id='delete-product' onclick='deleteProductById("+givenProductId+")'>Delete</button>" +
        "</div>";
    productTable.append(html);
}

$(document).ready(function () {
    getAllProducts();
});