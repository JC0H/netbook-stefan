function saveProduct(brand, model, processor, graphics, memory, screen, ram,
                     network, color, weight, operatingSystem, usb,
                     additionalInformation, price) {
    $.ajax({
        type: "POST",
        contentType: "application/json",
        url: "api/stefan/notebook/products",
        data: JSON.stringify({
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

$(document).ready(function () {
    $("#create-product-btn").click(function () {
        var productPopup = "#add-product-popup";
        $(productPopup).show();
        $(productPopup).draggable();
        $('#save-product-btn').show();
        $('#update-product-btn').hide();
        $("#create-product-btn").attr("disabled", true);
        $(".update-product-class").attr("disabled", true);
        $(".delete-product-class").attr("disabled", true);
    });

    $("#cancel-btn").click(function () {
        $("#add-product-popup").hide();
        $("#create-product-btn").attr("disabled", false);
        $(".update-product-class").attr("disabled", false);
        $(".delete-product-class").attr("disabled", false);
    });

    $("#save-product-btn").click(function () {
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
        saveProduct(brand, model, processor, graphics, memory, screen, ram, network,
            color, weight, operatingSystem, usb, additionalInformation, price
        );
    });
});