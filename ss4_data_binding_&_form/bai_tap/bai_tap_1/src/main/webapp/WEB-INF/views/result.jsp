<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 3/2/2022
  Time: 4:33 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1 style="text-align: center; color: pink">Information</h1>
<table border="2" style="margin-left: auto; margin-right: auto; width: 50px">
    <tr>
        <td>Languages: </td>
        <td>${languages}</td>
    </tr>
    <tr>
        <td>Page Size: </td>
        <td>${size}</td>
    </tr>
    <tr>
        <td>Spans Filter: </td>
        <td>${spansFilter}</td>
    </tr>
    <tr>
        <td>Signature: </td>
        <td>${signature}</td>
    </tr>
</table>
</body>
</html>
