<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: marcos
  Date: 13/1/20
  Time: 17:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<ul>
    <%--<c:forEach var="genre" items="${genres}">
        <li><a href="./categoria/${genre}">${genre}</a></li>
    </c:forEach>--%>
        <c:forEach var="film" items="${films}">
            <li>${film.title}</li>
        </c:forEach>
</ul>
</body>
</html>
