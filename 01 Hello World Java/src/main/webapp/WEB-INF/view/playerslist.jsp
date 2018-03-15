<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <title>Players</title>
</head>
<body>
<form:form method="post" modelAttribute="player" action="/playerslist/form">
    <label><spring:message code="players.name"/><form:input path="name" type="text"/></label>
    <label><spring:message code="players.surname"/><form:input path="surname" type="text"/></label>
    <button type="submit" value="Add"><spring:message code="players.add"/></button><br>
    <form:errors path="name"/><br>
    <form:errors path="surname"/><br>
</form:form>
<table>
    <tr>
        <th><spring:message code="players.name"/></th>
        <th><spring:message code="players.surname"/></th>
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
