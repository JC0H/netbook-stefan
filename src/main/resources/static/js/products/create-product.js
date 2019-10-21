function saveProduct(brand, model, processor, graphics, memory, screen, ram,
                     network, color, weight, operatingSystem, usb,
                     additionalInformation, price) {
    var productDetailsData = {
        brand: brand,
        productDetails: [{
            // detailsId: detailsId,
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
        }]
    };
    var data2send = JSON.stringify(productDetailsData);
    $.ajax({
        type: "POST",
        contentType: "application/json",
        url: "api/stefan/notebook/products",
        data: data2send,
        timeout: 5000,
        success: function () {
            location.reload();
        },
        error: function () {
            alert("shit")
        }
    });
}

$(document).ready(function () {
    $("#create-product-btn").click(function () {
        var productPopup = "#add-product-popup";
        $(productPopup).show();
        $(productPopup).draggable();
        $("#create-product-btn").attr("disabled", true);
    });

    $("#cancel-btn").click(function () {
        $("#add-product-popup").hide();
        $("#create-product-btn").attr("disabled", false);
    });

    $("#save-product-btn").click(function () {
        // var productDetails = $('price-input').val(),
        // productId = $('price-input').val(),
        var brand = $('#brand-input').val(),
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

        console.log(additionalInformation);
        console.log(brand);
        console.log(model);
        console.log(processor);
        console.log(graphics);
        console.log(memory);
        console.log(screen);
        console.log(ram);
        console.log(network);
        console.log(color);
        console.log(weight);
        console.log(operatingSystem);
        console.log(usb);
        console.log(additionalInformation);
        console.log(price);
        saveProduct(brand, model, processor, graphics, memory, screen, ram, network,
            color, weight, operatingSystem, usb, additionalInformation, price
        );
    });
});