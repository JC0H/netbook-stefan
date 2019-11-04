function getEmployeeDetails() {
    $.ajax({url: "/prd", success: function(result){
            $(".table tbody").html('');
            if(result.length>0) {
                $.each(result, function( index, value ) {
                    var htmlStr =
                        "<tr><td>"+result[index].id+"</td>" +
                        "<td>"+result[index].brand+"</td>" +
                        "<td>"+result[index].model+"</td>" +
                        "<td>"+result[index].processor+"</td>" +
                        "<td>"+result[index].graphics+"</td>" +
                        "<td>"+result[index].memory+"</td>" +
                        "<td>"+result[index].screen+"</td>" +
                        "<td>"+result[index].ram+"</td>" +
                        "<td>"+result[index].network+"</td>" +
                        "<td>"+result[index].color+"</td>" +
                        "<td>"+result[index].weight+"</td>" +
                        "<td>"+result[index].operatingSystem+"</td>" +
                        "<td>"+result[index].usb+"</td>" +
                        "<td>"+result[index].additionalInformation+"</td>" +
                        "<td>"+result[index].price+"</td>" +
                        "<td><img src=\""+result[index].productPicPath+"\">" + "</td>" +
                        "</tr>";
                    $(".table tbody").append(htmlStr);
                });
            } else {
                $(".table tbody").append('<tr><td colspan="4" style="color:red;">No records to display</td></tr>');
            }
        }});
}

$(document).ready(function () {
    getEmployeeDetails();
    $(".alert-success").hide();
    $(".alert-danger").hide();
    $("#btnSubmit").click(function () {
        var form = $('#fileUploadForm')[0];
        var data = new FormData(form);
        var jsonDataObj = {
            "brand": $("#brand").val(),
            "model": $("#model").val(),
            "processor": $("#processor").val(),
            "graphics": $("#graphics").val(),
            "memory": $("#memory").val(),
            "screen": $("#screen").val(),
            "ram": $("#ram").val(),
            "network": $("#network").val(),
            "color": $("#color").val(),
            "weight": $("#weight").val(),
            "operatingSystem": $("#operatingSystem").val(),
            "usb": $("#usb").val(),
            "additionalInformation": $("#additionalInformation").val(),
            "price": $("#price").val()
        };
        data.append("prdJson", JSON.stringify(jsonDataObj));
        $("#btnSubmit").prop("disabled", true);
        $.ajax({
            type: "POST",
            enctype: 'multipart/form-data',
            url: "/prd",
            data: data,
            processData: false,
            contentType: false,
            cache: false,
            timeout: 600000,
            success: function (data) {

                console.log("SUCCESS : ", data);
                $("#btnSubmit").prop("disabled", false);
                $(".alert-success").show();
                $(".alert-danger").hide();
                getEmployeeDetails();

            },
            error: function (e) {
                $(".alert-success").hide();
                $(".alert-danger").show();
                console.log("ERROR : ", e);
                $("#btnSubmit").prop("disabled", false);
            }
        });
    });
});