// var productId,
//     brand,
//     model,
//     processor,
//     graphics,
//     memory,
//     screen,
//     ram,
//     image,
//     network,
//     color,
//     weight,
//     operatingSystem,
//     usb,
//     additionalInformation,
//     price,
//     rowNumber,
//     delimiter = ', ';
//
// function getAllProducts() {
//     $.ajax({
//         type: "GET",
//         dataType: "json",
//         contentType: "application/json",
//         data: "",
//         url: "api/stefan/notebook/products",
//         success: productSuccess,
//         error: function (response) {
//             alert('error');
//         }
//     });
// }
//
// function productSuccess(data) {
//     rowNumber = 0;
//     $("#products-table").empty();
//     $(data).each(function () {
//         productId = this.id;
//         brand = this.brand;
//         model = this.model;
//         processor = this.processor;
//         graphics = this.graphics;
//         memory = this.memory;
//         screen = this.screen;
//         ram = this.ram;
//         network = this.network;
//         color = this.color;
//         weight = this.weight;
//         operatingSystem = this.operatingSystem;
//         usb = this.usb;
//         additionalInformation = this.additionalInformation;
//         price = this.price;
//         image = this.image;
//
//         loadProducts(
//             productId,
//             brand,
//             model,
//             processor,
//             graphics,
//             memory,
//             screen,
//             ram,
//             network,
//             color,
//             weight,
//             operatingSystem,
//             usb,
//             additionalInformation,
//             price,
//             image
//         );
//     });
// }
//
// function loadProducts(productId,
//                       brand, model, processor, graphics, memory, screen, ram, network, color, weight,
//                       operatingSystem, usb, additionalInformation, price, image
// ) {
//     var html = '';
//     var productTable = $('#products-table');
//     html += "<div class='product-description" + productId + "' style='width:50%;border: 1px solid #dddddd;background:navajowhite'>" +
//         "<img src=\""+image+"\">" +
//         "alt='image' style='width:50px;height:50px'><br>" +
//         brand + delimiter + model + delimiter +
//         processor + delimiter + graphics + delimiter + ram + delimiter +
//         operatingSystem + delimiter + price +
//         "<button id='delete-product' class='delete-product-class' onclick='deleteProductById(" + productId + ")'>Delete</button>" +
//         "<button id='update-product' class='update-product-class' onclick='findProductToUpdate(" + productId + ")'>Update</button>" +
//         "</div>";
//     productTable.append(html);
// }
// $(document).ready(function () {
//     getAllProducts();
// });
// function getEmployeeDetails() {
//     $.ajax({
//         url: "/api/stefan/notebook/products",
//         success: function(result){
//             $(".table tbody").html('');
//             if(result.length>0) {
//                 $.each(result, function( index, value ) {
//                     var htmlStr = "<tr>" +
//                         "<td>"+result[index].id+"</td>" +
//                         "<td><img src=\""+result[index].profilePicPath+"\"></td>" +
//                         "</tr>";
//                     $(".table tbody").append(htmlStr);
//                 });
//             }
//         }});
// }
// $(document).ready(function () {
//     getEmployeeDetails();
//     $(".alert-success").hide();
//     $(".alert-danger").hide();
//     $("#btnSubmit").click(function () {
//         var form = $('#fileUploadForm')[0];
//         var data = new FormData(form);
//         var jsonDataObj = {
//             "name": $("#name").val(),
//             "designation" : $("#designation").val()
//         };
//         data.append("empJson", JSON.stringify(jsonDataObj));
//         $("#btnSubmit").prop("disabled", true);
//         $.ajax({
//             type: "POST",
//             enctype: 'multipart/form-data',
//             url: "/api/stefan/notebook/products",
//             data: data,
//             processData: false,
//             contentType: false,
//             cache: false,
//             timeout: 600000,
//             success: function (data) {
//
//                 console.log("SUCCESS : ", data);
//                 $("#btnSubmit").prop("disabled", false);
//                 $(".alert-success").show();
//                 $(".alert-danger").hide();
//                 getEmployeeDetails();
//
//             },
//             error: function (e) {
//                 $(".alert-success").hide();
//                 $(".alert-danger").show();
//                 console.log("ERROR : ", e);
//                 $("#btnSubmit").prop("disabled", false);
//             }
//         });
//     });
// });