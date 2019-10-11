function callController(serviceName, Request, processSuccess, processError) {
    var serviceUrl = "api/stefan/notebook" + serviceName;
    $.getJSON({
        type: "GET",
        url: serviceUrl,
        contentType: "application/json, charset=utf-8",
        dataType: "json",
        data: Request,
        success: function (data, status, req) {
            processSuccess(data, status, req);
        },
        error: function (data, status, req) {
            location.reload();
            processError(data, status, req);
        }
    });
}