<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Java web</title>

    <link rel="stylesheet"
          href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
          crossorigin="anonymous">
</head>

</head>
<body>
<header>
    <nav class="navbar navbar-expand-md navbar-dark"
         style="background-color: cadetblue">
        <div>
            <a href="/" class="navbar-brand">Меню</a>
        </div>

        <ul class="navbar-nav">
            <li><a class="nav-link">Просмотр и обработка исполнителей</a></li>
        </ul>
    </nav>
</header>

<div class="row">

    <div class="container">
        <h3 class="text-center">Исполнители</h3>
        <hr>
        <div class="container text-left">

            <a href="create-singer"
               class="btn btn-success"
               style="background-color: darkcyan">
                Добавить</a>
        </div>
        <br>
        <table class="table table-bordered">
            <thead>
            <tr>
                <th>id</th>
                <th>Имя</th>
                <th>Опции</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${singers}" var="singer">
                <tr>
                    <td>${singer.getId()}</td>
                    <td>${singer.getName()}</td>
                    <td>
                        <div class="container text-left">
                            <a href="update-singer?id=${singer.getId()}"
                               class="btn btn-success"
                               style="background-color: darkcyan">
                                Редактировать</a>
                            <a href="delete-singer?id=${singer.getId()}"
                               class="btn btn-success"
                               style="background-color: darkcyan">
                                Удалить</a>
                        </div>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>
</body>
</html>
