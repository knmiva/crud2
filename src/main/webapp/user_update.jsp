<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <title>Изменение пользователя.</title>
</head>
<body>
<table style=" width: 15%; border: 4px double black;">
    <form action="${pageContext.request.contextPath}/edit" method="POST">
        <h2>Изменить данные пользователя:</h2>
        <tr>

            <td style="border: 1px solid black; text-align: left">
                ID:
            </td>
            <td>
                <input type="hidden" name="id" value=${id} />
                ${id}

            </td>
        </tr>
        <tr>
            <td style="border: 1px solid black; text-align: left">
                Name:
            </td>
            <td><label>
                <input type="text" name="name" value=${name} />
            </label></td>
        </tr>
        <tr>
            <td style="border: 1px solid black; text-align: left">
                Email:
            </td>
            <td><label>
                <input type="text" name="name" value=${email} />
            </label></td>
        </tr>
        <tr>
            <td style="border: 1px solid black; text-align: left">
                Country:
            </td>
            <td><label>
                <input type="text" name="name" value=${country} />
            </label></td>
        </tr>
        <tr>
            <td style="border: 1px solid black; text-align: left">
                Mobile:
            </td>
            <td><label>
                <input type="text" name="name" value=${mobile} />
            </label></td>
        </tr>

        <tr>
            <td></td>
            <td>
                <input type="submit" value="Изменить данные пользователя">
            </td>
        </tr>
    </form>

</table>

</body>
</html>