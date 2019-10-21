// function updateProduct(productId, brand, detailsId, model, processor, graphics, memory, screen, ram, network, color, weight, operatingSystem, usb, additionalInformation, price) {
function updateProduct(detailsId) {

    console.log(detailsId);

    // getProductById(detailsId);
    // console.log(additionalInformation);
    // console.log(brand);
    // console.log(model);
    // console.log(processor);
    // console.log(graphics);
    // console.log(memory);
    // console.log(screen);
    // console.log(ram);
    // console.log(network);
    // console.log(color);
    // console.log(weight);
    // console.log(operatingSystem);
    // console.log(usb);
    // console.log(additionalInformation);
    // console.log(price);
}

function disableButtons() {
    var productPopup = "#add-product-popup";
    $(productPopup).show();
    $(productPopup).draggable();
    $("#create-product-btn").attr("disabled", true);
    $(".update-product-class").attr("disabled", true);
}

function oneProductSuccess(data) {
    console.log(data);
}

$(document).ready(function () {

});