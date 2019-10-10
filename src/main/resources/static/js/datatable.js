$(document).ready( function () {
    var table = $('#productsList').DataTable({
        "sAjaxSource": "/api/stefan/notebook/products",
        "sAjaxDataProp": "",
        "order": [[ 0, "asc" ]],
        "aoColumns": [
            { "mData": "id"},
            { "mData": "brand" }
            // { "mData": "model" },
            // { "mData": "processor" },
            // { "mData": "graphics" },
            // { "mData": "memory" },
            // { "mData": "screen"},
            // { "mData": "ram" },
            // { "mData": "network" },
            // { "mData": "color" },
            // { "mData": "weight" },
            // { "mData": "operatingSystem" },
            // { "mData": "usb"},
            // { "mData": "additionalInformation" },
            // { "mData": "price" }
        ]
    })
});