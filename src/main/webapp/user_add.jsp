<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <title>Добавление пользователя.</title>
</head>
<body>
<table style=" width: 15%; border: 4px double black;">
    <form action="${pageContext.request.contextPath}/register" method="POST">
        <h2>Добавить пользователя:</h2>
        <tr>
            <td style="border: 1px solid black; text-align: left">
                Name:
            </td>
            <td><label>
                <input type="text" name="name"/>
            </label></td>
        </tr>
        <tr>
            <td style="border: 1px solid black; text-align: left">
                Email:
            </td>
            <td><label>
                <input type="text" name="email"/>
            </label></td>
        </tr>
        <tr>
            <td style="border: 1px solid black; text-align: left">
                Country:
            </td>
            <td><label>
                <input type="text" name="country"/>
            </label></td>
        </tr>
        <tr>
            <td style="border: 1px solid black; text-align: left">
                Mobile:
            </td>
            <td><label>
                <input type="text" name="mobile"/>
            </label></td>
        </tr>

        <tr>
            <td></td>
            <td>
                <input type="submit" value="Добавить">
            </td>
        </tr>
    </form>

</table>

</body>
</html>