<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 3/1/2022
  Time: 4:23 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <style>
        /*.table{*/
        /*    width: 65px;*/
        /*    margin-left: auto;*/
        /*    margin-right: auto;*/
        /*}*/
    </style>
</head>
<body>
<h1 style="text-align: center">Sandwich Condiments</h1>
<h3 style="text-align: center">Bạn hãy chọn topping cho sandwich của bạn đi nào!</h3>
<form style="text-align: center" action="sandwich" method="post">
    <label><input type="checkbox" name="condiments" value="Lettuce">Lettuce</label><br>
    <label><input type="checkbox" name="condiments" value="Tomato">Tomato</label><br>
    <label><input type="checkbox" name="condiments" value="Mustard">Mustard</label><br>
    <label><input type="checkbox" name="condiments" value="Sprouts">Sprouts</label><br>
    <button type="submit">Save</button>
</form>

    <table border="1" style="margin-left: auto; margin-right: auto; width: 65px">
        <thead>
        <tr>
            <th>Topping</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="condiments" items="${list}">
            <tr>
               <td>${condiments}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</body>
</html>