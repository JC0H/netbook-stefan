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
    productNumber = 1,
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
    $("#products-table").empty();
    $(data).each(function () {
        product = this;
        productId = this.id;
        brand = product.brand;
        productDetails = this.productDetailsDtoList;

        $(productDetails).each(function () {
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
                price,
                productNumber
            );
            productNumber++;
        });
    })
}

function loadProducts(
    brand, detailsId, model, processor, graphics, memory, screen, ram, network, color, weight,
    operatingSystem, usb, additionalInformation, price, productNumber
) {
    var html = '';
    var productTable = $('#products-table');
    html = "<div id='products-row' style='width:150px;height:150px;background:navajowhite;margin-bottom:5px;'>" +
                "<img src='#' alt='image' style='width:20px;height:20px;align:center'>" +
                "<div id='product-description'>" +
                    brand + delimeter + model + delimeter +
                    processor + delimeter + graphics + delimeter + ram + delimeter +
                    operatingSystem + delimeter + price +
                "</div>" +
            "</div>";
    if(productNumber%2 === 0) html+= "</div>";
    productTable.append(html);
}

$(document).ready(function () {
        console.log("in table function");
        getAllProducts();
    }
);