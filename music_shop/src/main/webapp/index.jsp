<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
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
            <a class="navbar-brand"
               style="color: whitesmoke">Лабораторная работа 8</a>
        </div>

        <ul class="navbar-nav">
            <li>Дунилина Елизавета, группа 6133</li>
        </ul>
    </nav>
</header>

<div class="row">
    <div class="container">
        <h3 class="text-center">Музыкальный магазин</h3>
        <hr>
        <div class="container text-left">
            <a href="<%=request.getContextPath()%>/singers"
               class="btn btn-success"
               style="background-color: darkcyan">
                Исполнители</a>
            <a href="<%=request.getContextPath()%>/albums"
               class="btn btn-success"
               style="background-color: darkcyan">
                Альбомы</a>
            <a href="<%=request.getContextPath()%>/songs"
               class="btn btn-success"
               style="background-color: darkcyan">
                Песни</a>
        </div>
        <br>
    </div>
</div>
</body>
</html>