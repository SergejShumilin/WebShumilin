<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Парсинг</title>
</head>
<body>
<h2 style="color: black">Parser options:</h2>

<form action="/result" method="post">
    <label>
        <select name="choice">
            <option value="dom">DOM</option>
            <option value="jaxb">JAXB</option>
        </select>
    </label><br/>
    <input type="submit" value="Parse">
</form>
</body>
</html>
