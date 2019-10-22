function updateProductAjax(productId, brand, model, processor, graphics, memory, screen, ram, network,
                           color, weight, operatingSystem, usb, additionalInformation, price) {
    $.ajax({
        type: "PATCH",
        contentType: "application/json",
        url: "api/stefan/notebook/products",
        data: JSON.stringify({
            id: productId,
            brand: brand,
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
        }),
        timeout: 5000,
        success: function () {
            location.reload();
        },
        error: function () {
            alert("shit")
        }
    });
}

function findProductToUpdate(productId) {
        $.ajax({
            type: "GET",
            dataType: "json",
            contentType: "application/json",
            data: "",
            url: "api/stefan/notebook/products/" + productId,
            success: oneProductSuccess,
            error: function (response) {
                alert('error');
            }
        });
}

function oneProductSuccess(data) {
    disableButtons();
    productId = data.id;
    brand = data.brand;
    model = data.model;
    processor = data.processor;
    graphics = data.graphics;
    memory = data.memory;
    screen = data.screen;
    ram = data.ram;
    network = data.network;
    color = data.color;
    weight = data.weight;
    operatingSystem = data.operatingSystem;
    usb = data.usb;
    additionalInformation = data.additionalInformation;
    price = data.price;

    $('#product-id-input').val(productId);
    $('#brand-input').val(brand);
    $('#model-input').val(model);
    $('#processor-input').val(processor);
    $('#graphics-input').val(graphics);
    $('#memory-input').val(memory);
    $('#screen-input').val(screen);
    $('#ram-input').val(ram);
    $('#network-input').val(network);
    $('#color-input').val(color);
    $('#weight-input').val(weight);
    $('#operatingSystem-input').val(operatingSystem)
    $('#usb-input').val(usb);
    $('#additionalInformation-input').val(additionalInformation);
    $('#price-input').val(price);
}

function disableButtons() {
    var productPopup = "#add-product-popup";
    $(productPopup).show();
    $(productPopup).draggable();
    $('#save-product-btn').hide();
    $('#update-product-btn').show();
    $("#create-product-btn").attr("disabled", true);
    $(".update-product-class").attr("disabled", true);
    $(".delete-product-class").attr("disabled", true);
}

$(document).ready(function () {
    $("#cancel-btn").click(function () {
        $("#add-product-popup").hide();
        $("#create-product-btn").attr("disabled", false);
        $(".update-product-class").attr("disabled", false);
        $(".delete-product-class").attr("disabled", false);
    });

    $("#update-product-btn").click(function () {
        var productId = $('#product-id-input').val(),
            brand = $('#brand-input').val(),
            model = $('#model-input').val(),
            processor = $('#processor-input').val(),
            graphics = $('#graphics-input').val(),
            memory = $('#memory-input').val(),
            screen = $('#screen-input').val(),
            ram = $('#ram-input').val(),
            network = $('#network-input').val(),
            color = $('#color-input').val(),
            weight = $('#weight-input').val(),
            operatingSystem = $('#operatingSystem-input').val(),
            usb = $('#usb-input').val(),
            additionalInformation = $('#additionalInformation-input').val(),
            price = $('#price-input').val();
        updateProductAjax(productId, brand, model, processor, graphics, memory, screen, ram, network,
            color, weight, operatingSystem, usb, additionalInformation, price
        );
    });
});