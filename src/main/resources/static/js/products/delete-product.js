function deleteProductById(id) {
    console.log(id);
    if(confirm("Are You fuckin' sure, pal?") === true) {
        $.ajax({
            type: "DELETE",
            contentType: "application/json",
            timeout: 5000,
            url: "api/stefan/notebook/products/"+id,
            success: function () {
                location.reload();
            },
            error: function () {

            },
            done: function () {

            }
        });

    }

}