<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Error</title>
</head>
<body>
${message}: ${exception}<br>
<ul>
    <c:forEach items="${exception.stackTrace}" var="exception">
        ${exception}<br/>
    </c:forEach>
</ul>
</body>
</html>
