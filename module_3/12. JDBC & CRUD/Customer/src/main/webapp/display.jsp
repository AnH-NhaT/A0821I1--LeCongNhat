<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>Title</title>
    <link rel="stylesheet" href="bootstrap-4.6.1-dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="bootstrap-4.6.1-dist/css/bootstrap.css">
    <script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"
            integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
            crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-fQybjgWLrvvRgtW6bFlB7jaZrFsaBXjsOMm/tB9LTS58ONXgqbR9W8oWht/amnpF"
            crossorigin="anonymous"></script>
</head>
<style>
    .th, .td {
        margin-top: 6px
    }

    .add, .edit, .delete {
        height: 37px;
    }

    #top_bar input, #top_bar button {
        height: 38px;
    }

    input, button {
        height: 45px;
    }
</style>
<body>
<div class="container">
    <a href="/Home">
        <h1 class="d-flex justify-content-center text-danger font-weight-bolder">Customer Management</h1>
    </a>
    <nav class="navbar navbar-expand-lg navbar-light bg-light">

        <div class="collapse navbar-collapse" id="navbarTogglerDemo03">
            <ul class="navbar-nav mr-auto mt-2 mt-lg-0">
                <li class="nav-item">
                    <div class="dropdown">
                        <button class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenuButton"
                                data-toggle="dropdown" aria-expanded="false">
                            SORT BY NAME
                        </button>
                        <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
                            <a class="dropdown-item" href="/Home?action=asc">Ascending Order</a>
                            <a class="dropdown-item" href="/Home?action=desc">Descending Order</a>
                        </div>
                    </div>
                </li>
            </ul>
            <form class="form-inline my-2 my-lg-0" id="top_bar" method="post" action="/Home?action=search">
                <input class="form-control mr-sm-2" placeholder="Search By Name" name="words" required>
                <button class="btn btn-info my-2 my-sm-0" type="submit">Search</button>
            </form>
        </div>

    </nav>
    <div class="d-flex justify-content-center">
        <table class="table table-hover">
            <tr class="bg-dark text-warning text-uppercase">
                <th>
                    <div class="th">id</div>
                </th>
                <th>
                    <div class="th">name</div>
                </th>
                <th>
                    <div class="th">email</div>
                </th>
                <th>
                    <div class="th">nation</div>
                </th>
                <th>
                    <button class="btn btn-primary add"
                            data-toggle="modal"
                            data-target="#ModalSave"
                            data-id="${0}"
                            data-name=""
                            data-email=""
                            data-nation="">Add Customer
                    </button>
                </th>
            </tr>
            <c:forEach var="customer" items="${customerList}">
                <tr style="font-weight: bold">
                    <td style="color: black">
                        <div class="td">${customer.id}</div>
                    </td>
                    <td style="color: red">
                        <div class="td">${customer.name}</div>
                    </td>
                    <td style="color: blue">
                        <div class="td">${customer.email}</div>
                    </td>
                    <td style="color: purple">
                        <div class="td">${customer.nation}</div>
                    </td>
                    <td>
                        <button class="btn btn-success edit"
                                data-toggle="modal"
                                data-target="#ModalSave"
                                data-id="${customer.id}"
                                data-name="${customer.name}"
                                data-email="${customer.email}"
                                data-nation="${customer.nation}">Edit
                        </button>
                        <button class="btn btn-danger delete"
                                data-toggle="modal"
                                data-target="#ModalDelete"
                                data-id="${customer.id}"
                                data-name="${customer.name}"
                                data-email="${customer.email}"
                                data-nation="${customer.nation}">Delete
                        </button>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>
</div>


<div class="modal fade" id="ModalSave" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog d-flex justify-content-center">
        <div class="modal-content" style="width: 550px">

            <div class="modal-header">
                <h5 style="color: red">Fill out this from with your info</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>

            <div class="modal-body">
                <form method="post" action="/Home?action=save">
                    <table class="table table-responsive-lg table-light">
                        <input type="hidden" id="id" name="id"/>
                        <tr>
                            <th>Customer Name:</th>
                            <td colspan="2">
                                <input id="name" type="text" name="name" size="45" required/>
                            </td>
                        </tr>
                        <tr>
                            <th>Customer Email:</th>
                            <td colspan="2">
                                <input id="email" type="text" name="email" size="45"
                                       pattern="^[a-z][a-z_0-9]{0,}@gmail.com$" required/>
                            </td>
                        </tr>
                        <tr>
                            <th>Customer Nation:</th>
                            <td>
                                <input id="nation" type="text" name="nation" size="33" required/>
                            </td>
                            <td>
                                <button class="btn btn-outline-success"
                                        style="line-height: 15px; width: 70px;
                                font-weight: bold">SAVE
                                </button>
                            </td>
                        </tr>
                    </table>
                </form>
            </div>

        </div>
    </div>
</div>


<div class="modal fade" id="ModalDelete" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog d-flex justify-content-center">
        <div class="modal-content" style="width: 550px">

            <div class="modal-header">
                <h5 style="color: red">Are you sure to delete?</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>

            <div class="modal-body">
                <form method="post" action="/Home?action=delete">
                    <table class="table table-responsive-lg table-light">
                        <input type="hidden" id="id_del" name="id"/>
                        <tr>
                            <th>Customer Name:</th>
                            <td>
                                <input id="name_del" name="name" size="45" disabled/>
                            </td>
                        </tr>
                        <tr>
                            <th>Customer Email:</th>
                            <td>
                                <input id="email_del" name="email" size="45" disabled>
                            </td>
                        </tr>
                        <tr>
                            <th>Customer Nation:</th>
                            <td>
                                <input id="nation_del" name="nation" size="45" disabled/>
                            </td>
                        </tr>
                    </table>
                    <div class="d-flex justify-content-end">
                        <button class="btn btn-secondary" data-dismiss="modal">CANCEL</button>
                        <button class="btn btn-danger ml-2 mr-2">DELETE</button>
                    </div>
                </form>
            </div>

        </div>
    </div>
</div>


</body>
</html>
<script>
    $(".add").click(function () {
        $("#ModalSave").modal("show");
        $("#id").val($(this).data("id"));
        $("#name").val($(this).data("name"));
        $("#email").val($(this).data("email"));
        $("#nation").val($(this).data("nation"));
    })
    $(".edit").click(function () {
        $("#ModalSave").modal("show");
        $("#id").val($(this).data("id"));
        $("#name").val($(this).data("name"));
        $("#email").val($(this).data("email"));
        $("#nation").val($(this).data("nation"));
    })
    $(".delete").click(function () {
        $("#ModalDelete").modal("show");
        $("#id_del").val($(this).data("id"));
        $("#name_del").val($(this).data("name"));
        $("#email_del").val($(this).data("email"));
        $("#nation_del").val($(this).data("nation"));
    })
</script>