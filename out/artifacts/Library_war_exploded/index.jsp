<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <title>Онлайн бібліотека::Вхід</title>
        <link href="${pageContext.request.contextPath}/css/style_index.css" rel="stylesheet" type="text/css">
    </head>

    <body>
        <div class="main">

            <div class="content">
                <p class="title"><span class="text"><img class="image" src="${pageContext.request.contextPath}/images/phone.png" width="76" height="77" hspace="10" vspace="10" align="middle"></span></p>
                <p class="title">Онлайн бібліотека</p>
                <p class="text">Вітаємо в онлайн бібліотеці, де ми зможете знайти будь-яку книгу на ваш смак.</p>
                <p class="text">Проект знаходиться в розробці, тому дизайн і функціонал будуть удосконалюватись.</p>
                <p class="text">У разі виникнення питань звертайтесь: <a href="mailto:crashtime078@gmail.com">crashtime078@gmail.com</a></p>
                <p>&nbsp;</p>

            </div>

            <div class="login_div">
                <p class="title">Для входу введіть дані:</p>
                <form class="login_form" name="username" action="${pageContext.request.contextPath}/pages/main.jsp" method="POST">
                    Ім'я: <input type="text" name="username" value="" size="20" />
                    <input type="submit" value="Ввійти" />
                </form>

            </div>

            <div class="footer">
                Руслан Харевич - 2017
            </div>
        </div>


    </body>
</html>
