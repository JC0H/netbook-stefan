function getAllProducts() {
    $.ajax({
        type: "GET",
        dataType: "json",
        contentType: "application/json",
        data: "",
        url: "api/stefan/notebook/products",
        success: function (result) {
        $(result).each(function () {
            var product = this;
            var brand = product.brand;
            var productDetails = this.productDetailsDtoList;
            $(productDetails).each(function () {
                console.log(brand);
                console.log(this.model);
                console.log(this.processor);
                console.log(this.memory);
                console.log(this.screen);
                console.log(this.ram);
                console.log("------------------------------")
            })
        })},
        error: function (response) {
        debugger;
            alert('error');
        }
    });
        // .then(function (data) {
        // $(data).each(function () {
        //     console.log(data);
        // });
    // });
}

function productSuccess(data, status, req) {
    if(status === "success") {
        $("#employeesTable").empty();
        $(data).each(function () {
            console.log(data);
        });
    }
}

function productError(data, status, req) {
    console.log("stiopa, sajt bude za rik");
}

$(document).ready(function () {
        console.log("in table function");
        getAllProducts();
        // callController();
    }
);