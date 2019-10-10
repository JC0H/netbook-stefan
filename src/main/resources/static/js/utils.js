function callController(serviceName, Request, processSuccsses, processError) {
    var serviceUrl = "api/stefan/notebook/products";
    $.getJSON({
        type: "GET",
        url: serviceUrl,
        contentType: "application/json, charset=utf-8",
        dataType: "json",
        data: Request,
        success: function (data, status, req) {
            processSuccsses(data, status, req);
        },
        error: function (data, status, req) {
            location.reload();
            processError(data, status, req);
        }
    });
}