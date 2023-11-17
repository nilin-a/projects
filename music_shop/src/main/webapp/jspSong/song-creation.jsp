<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Java web</title>

    <link rel="stylesheet"
          href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
          crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"
            type="text/javascript"></script>
<%--    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>--%>
    <script>
        $(document).ready(function() {
            $("#albumName").on("input", function() {
                var inputText = $(this).val();
                var selectElement = $("#album");
                var url = "find-album?albumname=" + inputText;

                $.ajax({
                    url: url,
                    type: "GET",
                    success: function(albums) {
                        console.log(albums);
                        selectElement.empty();
                        albums.forEach(function(album) {
                            console.log(album);
                            var option = new Option(album.name, album.id);
                            selectElement.append(option);
                        });
                    }
                });
            });

            $("#album").on("change", function() {
                $("#album").val($(this).val());
                $("#albumName").val($(this).find(":selected").text());
            });
        });
    </script>

</head>

<body>

<header>
    <nav class="navbar navbar-expand-md navbar-dark"
         style="background-color: cadetblue">
        <div>
            <a href="songs" class="navbar-brand">Назад</a>
        </div>

        <ul class="navbar-nav">
            <li><a class="nav-link">Создайте новую песню</a></li>
        </ul>
    </nav>
</header>
<br>
<div class="container col-md-5">
    <div class="card">
        <div class="card-body">
            <form action="create-song" method="post">
                <caption>
                    <h2>Добавление песни</h2>
                </caption>
                <fieldset class="form-group">
                    <label>Название</label> <input type="text"
                                                   id="name"
                                                   name="name"
                                                   class="form-control"
                                                   minlength="2"
                                                   required>

                    <label>Длительность</label> <input type="time"
                                                       id="duration"
                                                       name="duration"
                                                       class="form-control"
                                                       value="11:11:11"
                                                       step="1"
                                                       required>
                    <label>Альбом</label> <input type="text"
                                                 id="albumName"
                                                 name="albumName"
                                                 class="form-control"
                                                 minlength="2"
                                                 required>
                    <select id="album" name="album"></select>
                </fieldset>

                <button type="submit" class="btn btn-success" style="background-color: darkcyan">Создать</button>
            </form>
        </div>
    </div>
</div>
</body>
</html>
