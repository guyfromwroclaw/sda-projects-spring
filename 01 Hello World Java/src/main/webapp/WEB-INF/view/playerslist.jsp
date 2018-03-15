<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Players</title>
</head>
<body>
<form:form method="post" modelAttribute="player" action="/playerslist/form">
    <label>Name: <form:input path="name" type="text"/></label>
    <label>Surname: <form:input path="surname" type="text"/></label>
    <button type="submit" value="Add">Add</button>
</form:form>
<table>
    <tr>
        <th>Name</th>
        <th>Surname</th>
    </tr>
    <c:forEach items="${players}" var="player">
        <tr>
            <td>${player.name}</td>
            <td>${player.surname}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
