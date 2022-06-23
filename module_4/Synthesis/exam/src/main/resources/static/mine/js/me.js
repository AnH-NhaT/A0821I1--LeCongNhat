$(function () {

    $(".add").click(function () {
        $("input[name='id']").val(null)
    })


    $("#modalSave").on("hidden.bs.modal", function () {
        window.location.replace("http://localhost:8080/")
    });

    $("#modalView").on("hidden.bs.modal", function () {
        window.location.replace("http://localhost:8080/")
    });


    $(".edit").click(function () {

        $("input[name='id']").val($(this).data("id"))
        $("input[name='title']").val($(this).data("title"))
        $("input[name='answer']").val($(this).data("answer"))
        $("input[name='status']").val($(this).data("status"))
        $("input[name='date_create']").val($(this).data("date_create"))
        $("textarea[name='content']").val($(this).data("content"))

        let temp = $(this).data("question_type_id")
        $("select[name='questionType'] option").each(function () {
            if ($(this).val() == temp) $(this).prop("selected", true)
        });
    })


    $(".delete").click(function () {
        $("#id_delete").val($(this).data("id"))
    })

})