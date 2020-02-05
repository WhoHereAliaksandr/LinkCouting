<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Сайтик</title>
    <link href="css/indexStyle.css" rel="stylesheet" type="text/css" />
    <script src="script/script.js"></script>
</head>

<body>
    <div id="panel">
        <table>
            <tr>
                <td>
                    Анализируемая страница
                </td>
            </tr>
            <form method="POST" action="main">
                <tr>
                    <td>
                        <input type="text" name = "link" required>
                    </td>
                </tr>
                <tr>
                    <td class = "error empty">
                        <p>${error}</p>
                    </td>
                </tr>
                <tr>
                    <td class="empty">
                         <input type="submit" value="Анализировать" onClick = "waitingBox(this)">
                    </td>
                </tr>
            </form>
        </table>
        <div id="links">
            <table>
                <caption>Обнаруженные ссылки</caption>
                <thead>
                    <tr>
                        <td style="width: 30px;">
                            №
                            <br> п/П
                        </td>
                        <td>
                            Имя ссылки
                        </td>
                        <td>
                            Адрес ссылки
                        </td>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${links}" var="link" varStatus="loop">
                        <tr>
                            <td>
                                ${loop.index}
                            </td>
                            <td>
                                ${link.name}
                            </td>
                            <td>
                                <form method="GET" action="main">
                                    <a href = "#" onClick="addToParsedLinks(this)">${link.link}</a>
                                </form>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
        <form method="POST" action="clear">
            <input type="submit" value="Очистить">
        </form>
    </div>
    <div id = "waitingBox">
       <div class = "loadingImg">

       </div>
       <div class = "loadingText">
           <p>Идёт обработка...</p>
       </div>
    </div>
</body>
</html>