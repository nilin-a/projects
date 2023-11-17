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
            <a href="songs" class="navbar-brand">Назад</a>
        </div>

        <ul class="navbar-nav">
            <li><a class="nav-link">Измените выбранную песню</a></li>
        </ul>
    </nav>
</header>
<br>
<div class="container col-md-5">
    <div class="card">
        <div class="card-body">
            <form action="update-song" method="post">
                <caption>
                    <h2>Изменение песни</h2>
                </caption>
                <fieldset class="form-group">
                    <input type="hidden" id="id" name="id" value="${song.getId()}">
                    <label>Название</label> <input type="text"
                                                   id="name"
                                                   name="name"
                                                   class="form-control"
                                                   minlength="2"
                                                   value="${song.getName()}"
                                                   required>

                    <label>Длительность</label>
                    <input id="duration" type="time" name="duration" step="1" class="form-control" value="${song.getDuration()}" required/>
                </fieldset>

                <button type="submit" class="btn btn-success" style="background-color: darkcyan">Ок</button>
            </form>
        </div>
    </div>
</div>
</body>
</html>
