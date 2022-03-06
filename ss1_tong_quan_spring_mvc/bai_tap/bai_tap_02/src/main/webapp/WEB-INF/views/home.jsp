<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 2/28/2022
  Time: 4:52 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/translate">
    <label>TRANSLATE</label>
    <input type="text" name="english" placeholder="english">
    <input type="submit" value="translate">
</form>
<h1>Kết quả: ${search}</h1>
</body>
</html>
