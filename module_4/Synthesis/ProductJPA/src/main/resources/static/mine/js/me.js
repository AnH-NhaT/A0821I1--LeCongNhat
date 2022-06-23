$(function () {
    $(".add").click(function () {
        $("input[name='id']").val(null)
    })
    $("#modalSave").on("hidden.bs.modal", function () {
        window.location.replace("http://localhost:8080/")
    });
    $(".edit").click(function () {
        $('#currentUrl2').val(window.location.href)
        $("input[name='id']").val($(this).data("id"))
        $("input[name='name']").val($(this).data("name"))
        $("input[name='price']").val($(this).data("price"))
        $("input[name='expiration']").val($(this).data("expiration"))
        let temp = $(this).data("category")
        $("select[name='category'] option").each(function () {
            if ($(this).val() == temp) $(this).prop("selected", true)
        });
    })
    $(".delete").click(function () {
        $('#currentUrl').val(window.location.href)
        $("#id_delete").val($(this).data("id"))
        $(".nameDel").text("product: " + $(this).data("name"))
    })
    $("select[name='category_id'] option").each(function () {
        if ($(this).val() == $('#getCateId').val()) $(this).prop("selected", true)
    });
})