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
        console.log("save that bitch")
        var
    });
});