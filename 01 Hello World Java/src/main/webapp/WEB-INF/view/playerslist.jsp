<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Players</title>
</head>
<body>
<ul>
    <c:forEach items="${players}" var="player">
        <li>${player}</li>
    </c:forEach>
</ul>
</body>
</html>
