<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Java web</title>

    <link rel="stylesheet"
          href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
          crossorigin="anonymous">

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script>
        $(document).ready(function () {
            $("#singerName").on("input", function () {
                var inputText = $(this).val();
                var selectElement = $("#singer");
                var url = "find-singer?singername=" + inputText;
                $.ajax({
                    url: url,
                    type: "GET",
                    success: function (singers) {
                        selectElement.empty();
                        singers.forEach(function (singer) {
                            var option = new Option(singer.name, singer.id);
                            selectElement.append(option);
                        });
                    }
                });
            });

            $("#singer").on("change", function () {
                // Устанавливаем id автора в скрытое поле
                $("#singer").val($(this).val());
                // Устанавливаем имя автора в поле ввода
                $("#singerName").val($(this).find(":selected").text());
            });
        });
    </script>
</head>

<body>
<header>
    <nav class="navbar navbar-expand-md navbar-dark"
         style="background-color: cadetblue">
        <div>
            <a href="albums" class="navbar-brand">Назад</a>
        </div>

        <ul class="navbar-nav">
            <li><a class="nav-link">Создайте новый альбом</a></li>
        </ul>
    </nav>
</header>
<br>
<div class="container col-md-5">
    <div class="card">
        <div class="card-body">
            <form action="create-album" method="post">
                <caption>
                    <h2>Добавление альбома</h2>
                </caption>
                <fieldset class="form-group">
                    <label>Название</label> <input type="text"
                                                   id="name"
                                                   name="name"
                                                   class="form-control"
                                                   minlength="2"
                                                   required>
                    <label>Жанр</label> <input type="text"
                                               id="genre"
                                               name="genre"
                                               class="form-control"
                                               minlength="2"
                                               required>

                    <label>Исполнитель</label> <input type="text"
                                                      id="singerName"
                                                      name="singerName"
                                                      class="form-control"
                                                      minlength="2"
                                                      placeholder=""
                                                      required>
                    <select id="singer" name="singer"></select>
                </fieldset>
                <button type="submit" class="btn btn-success" style="background-color: darkcyan">Создать</button>
            </form>
        </div>
    </div>
</div>
</body>
</html>
