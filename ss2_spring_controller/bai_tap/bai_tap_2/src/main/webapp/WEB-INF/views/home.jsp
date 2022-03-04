<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 3/2/2022
  Time: 11:32 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1 style="text-align: center; color: cyan">CALCULATION</h1>
<form action="/home" method="post" style="text-align: center">
    <label>Number One<input type="text" name="numberOne" placeholder="numberOne"></label>
    <label>Number Two<input type="text" name="numberTwo" placeholder="numberTwo"></label><br>
    <label><button type="submit" name="button" value="Addition" style="color: blue">Addition +</button></label>
    <label><button type="submit" name="button" value="Subtraction" style="color: blue">Subtraction -</button></label>
    <label><button type="submit" name="button" value="Multiplication" style="color: blue">Multiplication *</button></label>
    <label><button type="submit" name="button" value="Division" style="color: blue">Division /</button></label><br>
    <label>Result: ${result} ${message}</label>
</form>

</body>
</html>
