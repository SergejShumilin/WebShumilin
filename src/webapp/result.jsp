<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>${message} парсер</title>
</head>
<body>

<h1>${message} парсер</h1>

<a href="index.jsp">Back to main page</a>
<hr>

<c:forEach var="car" items="${result}">

<table border="1">
    <tr>
        <th>Поле</th>
        <th>Значение</th>
    </tr>

</table>

</c:forEach>

</body>
</html>