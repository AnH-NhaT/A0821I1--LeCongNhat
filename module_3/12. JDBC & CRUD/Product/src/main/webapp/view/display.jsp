<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>HomePage</title>
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
    body, button {
        text-transform: capitalize;
    }

    h4 {
        display: inline;
    }

    #name_del {
        color: red;
        font-weight: bolder;
    }
</style>
<body>
<div class="container">
    <div></div>
    <div></div>
    <div></div>
    <div></div>
    <div></div>
    <div></div>

    <%--    header--%>
    <div>
        <h1><a href="/Servlet">product management</a></h1>
    </div>

    <%--    searchBar--%>
    <div class="d-flex justify-content-between">
        <div>
            <form action="/Servlet?action=search" method="post">
                name <input name="na" placeholder="name">
                color <input name="co" placeholder="color">
                category
                <select name="ca">
                    <option value="">-- option --</option>
                    <c:forEach items="${subList}" var="c">
                        <option value="${c.id}">${c.name}</option>
                    </c:forEach>
                </select>
                <button type="submit">search</button>
            </form>
        </div>
        <div>
            <button type="button"
                    onclick="clearAddForm()"
                    data-toggle="modal"
                    data-target="#modalSave">add a product
            </button>
        </div>
    </div>

    <%--    tableOfContent--%>
    <div>
        <table class="table table-hover table-bordered">
            <thead>
            <tr>
                <th scope="col">id<%--order--%></th>
                <th scope="col">name</th>
                <th scope="col">price</th>
                <th scope="col">quantity</th>
                <th scope="col">color</th>
                <th scope="col">description</th>
                <th scope="col">category</th>
                <th scope="col">date</th>
                <th scope="col">type</th>
                <th scope="col">action</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="p" items="${mainList}" varStatus="status">
                <tr>
                    <td><%--${status.count}--%>${p.id}</td>
                    <td>${p.name}</td>
                    <td>${p.price}</td>
                    <td>${p.quantity}</td>
                    <td>${p.color}</td>
                    <td>${p.description}</td>
                    <td>${p.category_name}</td>
                    <td>${p.date}</td>
                    <c:if test="${p.type}">
                        <td>real</td>
                    </c:if>
                    <c:if test="${!p.type}">
                        <td>fake</td>
                    </c:if>
                    <td>
                        <button type="button" class="edit"
                                data-toggle="modal"
                                data-target="#modalSave"
                                onclick="editFunc('${p.id}','${p.name}',
                                        '${p.price}','${p.quantity}',
                                        '${p.color}','${p.description}',
                                        '${p.date}','${p.category_id}','${p.type}')">
                            edit
                        </button>
                        <button type="button" class="delete"
                                data-toggle="modal"
                                data-target="#modalDelete"
                                onclick="deleteFunc('${p.id}','${p.name}')">delete
                        </button>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>

    <%--    pagination--%>
    <nav aria-label="Page navigation example" class="d-flex justify-content-end">
        <ul class="pagination">
            <li class="page-item">
                <a id="previousP" class="page-link" href="/Servlet?pageNum=${0}">Previous</a>
            </li>
            <c:forEach items="${rows}" var="row">
                <li class="page-item">
                    <a class="page-link" href="/Servlet?pageNum=${row-1}">${row}</a>
                </li>
            </c:forEach>
            <li class="page-item">
                <a id="nextP" class="page-link" href="/Servlet?pageNum=${lengthP-1}">Next</a>
            </li>
        </ul>
    </nav>

    <div></div>
    <div></div>
    <div></div>
    <div></div>
    <div></div>
    <div></div>
</div>

<%--ModalPopup save--%>
<div class="modal fade" id="modalSave" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
     aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">save information</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <form id="saveFormId" action="/Servlet?action=save" method="post">
                    <input id="id" name="id" type="hidden" value="0">
                    <table>
                        <tr>
                            <th>name</th>
                            <td><input id="name" name="name" required></td>
                        </tr>
                        <tr>
                            <th>price</th>
                            <td><input id="price" name="price" required></td>
                        </tr>
                        <tr>
                            <th>quantity</th>
                            <td><input id="quantity" name="quantity" required></td>
                        </tr>
                        <tr>
                            <th>color</th>
                            <td><input id="color" name="color" required></td>
                        </tr>
                        <tr>
                            <th>description</th>
                            <td><input id="description" name="description" required></td>
                        </tr>
                        <tr>
                            <th>category</th>
                            <th>
                                <select id="category_id" name="category_id">
                                    <c:forEach var="c" items="${subList}">
                                        <option id="category_id${c.id}" value="${c.id}">${c.name}</option>
                                    </c:forEach>
                                </select>
                            </th>
                        </tr>
                        <tr>
                            <th>date</th>
                            <td><input id="date" name="date" type="date" required></td>
                        </tr>
                        <tr>
                            <th>type</th>
                            <td>
                                real <input id="real_id" type="radio" name="type" value="true" checked>
                                fake <input id="fake_id" type="radio" name="type" value="false">
                            </td>
                        </tr>
                    </table>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancel</button>
                        <button type="submit" class="btn btn-primary">Save changes</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>

<%--ModalPopup delete--%>
<div class="modal fade" id="modalDelete" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
     aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5>are you sure to delete?</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <form method="post" action="/Servlet?action=delete">
                <input id="id_delete" name="id" type="hidden">
                <div class="modal-body">
                    <h4>product name: </h4><h4 id="name_del"></h4>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancel</button>
                    <button type="submit" class="btn btn-primary">Save changes</button>
                </div>
            </form>
        </div>
    </div>
</div>

<%--ModalPopup success--%>
<div class="modal fade" id="myModal1" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
     aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="alert alert-success d-flex justify-content-center" role="alert">
            <h1>successfully!!!</h1>
        </div>
    </div>
</div>

<%--ModalPopup failure--%>
<div class="modal fade" id="myModal0" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
     aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="alert alert-danger d-flex justify-content-center" role="alert">
            <h1>unsuccessfully!!!</h1>
        </div>
    </div>
</div>

<%--getVariables--%>
<input id="isSuccess" value="${mess}" type="hidden">
<input id="pageNum" value="${pageNum}" type="hidden">
<input id="lengthP" value="${lengthP}" type="hidden">
</body>
</html>
<script>

    function clearAddForm() {
        document.getElementById("saveFormId").reset();
    }

    let a = document.getElementById("isSuccess").value
    if (a !== "" && a === "true")
        $('#myModal1').modal('show')
    if (a !== "" && a === "false")
        $('#myModal0').modal('show')

    function deleteFunc(id, name) {
        document.getElementById("id_delete").value = id
        document.getElementById("name_del").innerText = name
    }

    function editFunc(id, name, price, quantity, color, description, date, category_id, type) {
        document.getElementById("id").value = id
        document.getElementById("name").value = name
        document.getElementById("price").value = price
        document.getElementById("quantity").value = quantity
        document.getElementById("color").value = color
        document.getElementById("description").value = description
        document.getElementById("date").value = date
        document.getElementById("category_id" + category_id).selected = true
        if (type === "false") document.getElementById("fake_id").checked = true
        else document.getElementById("real_id").checked = true
    }

    let pageNum = document.getElementById("pageNum").value
    let lengthP = document.getElementById("lengthP").value
    if (pageNum >= 0 && pageNum < lengthP - 1)
        document.getElementById("nextP").href = "/Servlet?pageNum=" + (parseInt(pageNum) + 1)
    if (pageNum === "")
        document.getElementById("nextP").href = "/Servlet?pageNum=1"
    if (pageNum > 0 && pageNum <= lengthP - 1)
        document.getElementById("previousP").href = "/Servlet?pageNum=" + (parseInt(pageNum) - 1)

</script>
