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

<body>
<header>
    <nav class="navbar navbar-expand-md navbar-dark"
         style="background-color: cadetblue">
        <div>
            <a href="singers" class="navbar-brand">Назад</a>
        </div>

        <ul class="navbar-nav">
            <li><a class="nav-link">Создайте нового исполнителя</a></li>
        </ul>
    </nav>
</header>
<br>
<div class="container col-md-5">
    <div class="card">
        <div class="card-body">
            <form action="create-singer" method="post">
                <caption>
                    <h2>Добавление исполнителя</h2>
                </caption>
                <fieldset class="form-group">
                    <label>Имя исполнителя</label> <input type="text" id="name"
                                                          name="name" required
                                                          class="form-control"
                                                          minlength="2">
                </fieldset>
                <button type="submit" class="btn btn-success" style="background-color: darkcyan">Создать</button>
            </form>
        </div>
    </div>
</div>
</body>
</html>
