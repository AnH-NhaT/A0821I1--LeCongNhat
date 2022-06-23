$(function () {

    $('button').addClass('btn btn-outline-primary')
    $('select').addClass('custom-select')
    $('input').addClass('form-control')
    $('#searchBox').removeClass('form-control')
    $('input[type=checkbox]').removeClass('form-control')

    if ($('#searchBox').val() === '') {
        $('#searchBox').focus()
    } else $('#searchBox').blur()

    if ($('#sortBy').val() === 'name') {
        $('.hName').hide()
        $('.iName').show().addClass('text-primary')
    }
    if ($('#sortBy').val() === 'price') {
        $('.hPrice').hide()
        $('.iPrice').show().addClass('text-primary')
    }
    if ($('#sortBy').val() === 'expiration') {
        $('.hExpiration').hide()
        $('.iExpiration').show().addClass('text-primary')
    }

    $('.sortName').click(function () {
        $('#sortBy').val('name')
        if (window.location.href !== 'http://localhost:8080/') {
            if ($('#ascOrDesc').val() === '') $('#ascOrDesc').val('asc')
            window.location.replace("http://localhost:8080/" + '?sortBy=' + $('#sortBy').val() + '&ascOrDesc=' + $('#ascOrDesc').val())
        } else {
            if ($('#ascOrDesc').val() === '') $('#ascOrDesc').val('asc')

            if ($('#ascOrDesc').val() === 'asc') {
                $('#sortForm').submit()
            }
            if ($('#ascOrDesc').val() === 'desc') {
                $('#sortForm').submit()
            }
        }
    })


    $('.sortPrice').click(function () {
        $('#sortBy').val('price')
        if (window.location.href !== 'http://localhost:8080/') {
            if ($('#ascOrDesc').val() === '') $('#ascOrDesc').val('asc')
            window.location.replace("http://localhost:8080/" + '?sortBy=' + $('#sortBy').val() + '&ascOrDesc=' + $('#ascOrDesc').val())
        } else {
            if ($('#ascOrDesc').val() === '') $('#ascOrDesc').val('asc')

            if ($('#ascOrDesc').val() === 'asc') {
                $('#sortForm').submit()
            }
            if ($('#ascOrDesc').val() === 'desc') {
                $('#sortForm').submit()
            }
        }
    })


    $('.sortExpiration').click(function () {
        $('#sortBy').val('expiration')
        if (window.location.href !== 'http://localhost:8080/') {
            if ($('#ascOrDesc').val() === '') $('#ascOrDesc').val('asc')
            window.location.replace("http://localhost:8080/" + '?sortBy=' + $('#sortBy').val() + '&ascOrDesc=' + $('#ascOrDesc').val())
        } else {
            if ($('#ascOrDesc').val() === '') $('#ascOrDesc').val('asc')

            if ($('#ascOrDesc').val() === 'asc') {
                $('#sortForm').submit()
            }
            if ($('#ascOrDesc').val() === 'desc') {
                $('#sortForm').submit()
            }
        }
    })

    if ($('#toastMessage').val() === 'success') {
        $('#toastId').text('Your action was successful!!')
        $('#liveToast').toast('show')
    }

    $('#overFive5').find('a').text($('#p5').val())
    $('#overFive4').find('a').text($('#p4').val())
    $('#overFive3').find('a').text($('#p3').val())
    $('#overFive2').find('a').text($('#p2').val())
    $('#overFive1').find('a').text($('#p1').val())

    $('.overFiveAll').hide()
    if ($('#totalPagesId').val() > 5) {
        $('.pageLoop').hide()
        $('.overFiveAll').show()
        $('#next').hide()
        $('#previous').hide()
        if (parseInt($('#totalPagesId').val()) === parseInt($('#currentPageId').val()) + 1) {
            $('#overFiveNext').hide()
            $('#hNext').show()
        }
        if (parseInt($('#currentPageId').val()) === 0) {
            $('#overFivePrevious').hide()
            $('#hPrevious').show()
        }
    }

    let tempArrayPages = []

    function setTempArrayPages() {
        tempArrayPages[0] = $('#overFive1').find('a').text()
        tempArrayPages[1] = $('#overFive2').find('a').text()
        tempArrayPages[2] = $('#overFive3').find('a').text()
        tempArrayPages[3] = $('#overFive4').find('a').text()
        tempArrayPages[4] = $('#overFive5').find('a').text()
        $('#arrPaId').val(tempArrayPages)
    }

    $('#overFivePrevious').click(function () {
        $('#hide').val('0')
        if (parseInt($('#totalPagesId').val()) > 5 && parseInt($('#overFive5').find('a').text()) > 5) {
            $('#overFive5').find('a').text(parseInt($('#overFive5').find('a').text()) - 5)
            $('#overFive4').find('a').text(parseInt($('#overFive4').find('a').text()) - 5)
            $('#overFive3').find('a').text(parseInt($('#overFive3').find('a').text()) - 5)
            $('#overFive2').find('a').text(parseInt($('#overFive2').find('a').text()) - 5)
            $('#overFive1').find('a').text(parseInt($('#overFive1').find('a').text()) - 5)
        }
        $('#curPag1').val($('#overFive1').find('a').text() - 1)
        setTempArrayPages()
        $('#ascOrDesc2').val($('#ascOrDesc').val())
        if ($('#sortBy').val() === 'name') $('#sortBy2').val('name')
        if ($('#sortBy').val() === 'price') $('#sortBy2').val('price')
        if ($('#sortBy').val() === 'expiration') $('#sortBy2').val('expiration')
        $('#formSendData').submit()
    })

    $('#overFiveNext').click(function () {
        if (parseInt($('#overFive5').find('a').text()) < parseInt($('#totalPagesId').val())) {
            if (parseInt($('#overFive5').find('a').text()) > parseInt($('#totalPagesId').val()) - 5) $('#hide').val('1')
            $('#overFive5').find('a').text(parseInt($('#overFive5').find('a').text()) + 5)
            $('#overFive4').find('a').text(parseInt($('#overFive4').find('a').text()) + 5)
            $('#overFive3').find('a').text(parseInt($('#overFive3').find('a').text()) + 5)
            $('#overFive2').find('a').text(parseInt($('#overFive2').find('a').text()) + 5)
            $('#overFive1').find('a').text(parseInt($('#overFive1').find('a').text()) + 5)
        }
        $('#curPag1').val($('#overFive1').find('a').text() - 1)
        setTempArrayPages()
        $('#ascOrDesc2').val($('#ascOrDesc').val())
        if ($('#sortBy').val() === 'name') $('#sortBy2').val('name')
        if ($('#sortBy').val() === 'price') $('#sortBy2').val('price')
        if ($('#sortBy').val() === 'expiration') $('#sortBy2').val('expiration')
        $('#formSendData').submit()
    })

    function func(id, h) {
        let by = $('#by').val()
        let value = $('#value').val()
        let textP = $(id).find('a').text()
        let sortBy = $('#sortBy').val()
        let ascOrDesc = $('#ascOrDesc').val()
        setTempArrayPages()
        $(id).find('a').attr('href', 'http://localhost:8080/search?page=' + (textP - 1) + '&h=' + h + '&by=' + by + '&value=' + value + '&tempArrayPages=' + $('#arrPaId').val() + '&sortBy=' + sortBy + '&ascOrDesc=' + ascOrDesc)
    }

    let tempHide = parseInt($('#totalPagesId').val()) % 5

    if ($('#hide').val() == 1) {

        if (tempHide == 1) $('#overFive2,#overFive3,#overFive4,#overFive5').hide()
        if (tempHide == 2) $('#overFive3,#overFive4,#overFive5').hide()
        if (tempHide == 3) $('#overFive4,#overFive5').hide()
        if (tempHide == 4) $('#overFive5').hide()

        $('#overFive5').click(function () {
            func('#overFive5', '1')
        })
        $('#overFive4').click(function () {
            func('#overFive4', '1')
        })
        $('#overFive3').click(function () {
            func('#overFive3', '1')
        })
        $('#overFive2').click(function () {
            func('#overFive2', '1')
        })
        $('#overFive1').click(function () {
            func('#overFive1', '1')
        })
    } else {
        $('#overFive5').click(function () {
            func('#overFive5', '0')
        })
        $('#overFive4').click(function () {
            func('#overFive4', '0')
        })
        $('#overFive3').click(function () {
            func('#overFive3', '0')
        })
        $('#overFive2').click(function () {
            func('#overFive2', '0')
        })
        $('#overFive1').click(function () {
            func('#overFive1', '0')
        })
    }
    if (parseInt($('#currentPageId').val()) === parseInt($('#totalPagesId').val()) && parseInt($('#totalPagesId').val()) !== 0) {
        if (parseInt($('#totalPagesId').val()) !== parseInt($('#overFive1').find('a').text()) - 1) {
            $('#curPag1').val($('#totalPagesId').val() - 1)
            setTempArrayPages()
            $('#formSendData').submit()
        } else {
            tempArrayPages[0] = $('#overFive1').find('a').text() - 5
            tempArrayPages[1] = $('#overFive2').find('a').text() - 5
            tempArrayPages[2] = $('#overFive3').find('a').text() - 5
            tempArrayPages[3] = $('#overFive4').find('a').text() - 5
            tempArrayPages[4] = $('#overFive5').find('a').text() - 5
            $('#curPag1').val($('#overFive1').find('a').text() - 6)
            $('#arrPaId').val(tempArrayPages)
            $('#formSendData').submit()
        }
    }

    $('.overFiveAll').each(function () {
        if ($(this).find('a').text() - 1 == $('#currentPageId').val()) $(this).addClass('active')
    })
    $('.pageLoop').each(function () {
        if ($(this).find('a').text() - 1 == $('#currentPageId').val()) $(this).addClass('active')
    })

    let checkbox = $('.selectOne')
    let checkbox_name = $('.selectOneName')
    let checkbox_array = []
    let checkbox_array_name = []

    $("#selectAll").click(function () {
        checkbox_array = []
        checkbox_array_name = []
        $('.selectOne').prop("checked", $(this).prop("checked"))
        $('.selectOneName').prop("checked", $(this).prop("checked"))
    })
    $('.lbCheckbox').click(function () {
        checkbox_array = []
        checkbox_array_name = []
        if (!$(this).find('.selectOne').prop('checked')) {
            $("#selectAll").prop("checked", false)
            $(this).find('.selectOneName').prop('checked', false)
        } else $(this).find('.selectOneName').prop('checked', true)
    })
    $('.deleteSelectedOnes').on('click', function () {
        $('#currentUrl').val(window.location.href)
        checkbox.each(function (index) {
            if (checkbox[index].checked) checkbox_array.push($(this).val())
        })
        checkbox_name.each(function (index) {
            if (checkbox_name[index].checked) checkbox_array_name.push($(this).val())
        })
        if (checkbox_array.length === 0) {
            $('#modalDelete').modal('hide')
            $('#toastId').text('You haven\'t selected any record')
            $('#liveToast').toast('show')
        } else {
            $("#id_delete").val(checkbox_array)
            $('#modalDelete').modal('show')
            let one = ''
            $('.nameDel').html($.each(checkbox_array_name, function (index, value) {
                one = one + '<h4>product ' + (index + 1) + ': ' + value + '</h4><br>'
            }))
            $('.nameDel').html(one.substring(0, one.length - 4))
        }
        checkbox_array = []
        checkbox_array_name = []
    })
    $(".add").click(function () {
        $('#currentUrl2').val(window.location.href)
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
    $(".noChoice").on("click", function () {
        $('.dropdown-toggle').text($(this).text())
        $('#by').val($(this).text())
        $('#searchBox').prop('disabled', false)
        $('#cate_value').prop('disabled', true)
        $('#searchBox').show()
    })
    $('.hasChoice').click(function () {
        $('.dropdown-toggle').text('category')
        $('#by').val('category')
        $('#cate_value').val($(this).find('.cId').text())
        $('#searchBox').val('')
        $('#cate_value').prop('disabled', false)
        $('#searchBox').attr("placeholder", $(this).find('.cName').text()).prop('disabled', true)
        $('#searchBox').show()
    })
    if ($('#by').val() === '') $('#by').val('whole')
    if ($('#by').val() === 'category') $('#searchBox').hide()
    if ($('#by').val() === 'whole' || $('#by').val() === 'name' || $('#by').val() === 'price') {
        $('#searchBox').prop('disabled', false)
        $('#cate_value').prop('disabled', true)
    }
    if ($('#by').val() === 'category') {
        $('#searchBox').val('')
        $('#searchBox').prop('disabled', true)
        $('#cate_value').prop('disabled', false)
    }
})