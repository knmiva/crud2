<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Все пользователи</title>

</head>
<body>

<h2>Список всех пользователей</h2>
<table style=" width: 15%; border: 4px double black;">
    <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Email</th>
        <th>Country</th>
        <th>Mobile</th>
    </tr>
    <c:forEach items="${requestScope.list}" var="user">
        <tr>
            <td style="border: 1px solid black; text-align: left">${user.id}</td>
            <td style="border: 1px solid black; text-align: left">${user.name}</td>
            <td style="border: 1px solid black; text-align: left">${user.email}</td>
            <td style="border: 1px solid black; text-align: left">${user.country}</td>
            <td style="border: 1px solid black; text-align: left">${user.mobile}</td>
            <td>
                <form action="${pageContext.request.contextPath}/edit" method="GET">
                    <input type="submit" value="Изменить"/>
                    <input type="hidden" name="id" value=${user.id} />
                </form>
            </td>
            <td>
                <form action="${pageContext.request.contextPath}/delete" method="POST">
                    <input type="submit" value="Удалить"/>
                    <input type="hidden" name="id" value=${user.id} />
                </form>
            </td>

        </tr>
    </c:forEach>
</table>


<form action="${pageContext.request.contextPath}/register" method="GET">
    <input type="submit" value="Добавить пользователя"/>
</form>

</body>
</html>