<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 3/2/2022
  Time: 4:09 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1 style="text-align: center; color: pink">EMAIL SETTINGS</h1>
<form:form action="submit" method="post" modelAttribute="settings">
<table border="2" style="margin-left: auto; margin-right: auto; width: 50px">
    <tr>
        <td> <form:label path="languages">Languages:</form:label></td>
        <td>
            <form:select path="languages">
                <option value="English">English</option>
                <option value="Vietnamese">Vietnamese</option>
                <option value="Japanese">Japanese</option>
                <option value="Chinese">Chinese</option>
            </form:select>
        </td>
    </tr>
    <tr>
        <td><form:label path="size">Page Size:</form:label></td>
        <td>
            Show
            <form:select path="size">
                <option value="5">5</option>
                <option value="10">10</option>
                <option value="15">15</option>
                <option value="20">20</option>
                <option value="50">50</option>
                <option value="100">100</option>
            </form:select>
            emails per page
        </td>
    </tr>
    <tr>
        <td><form:label path="spansFilter">Spans filter:</form:label></td>
        <td><form:checkbox path="spansFilter" value="Enable spans filter"/> Enable spans filter</td>
    </tr>
    <tr>
        <td><form:label path="signature">Signature:</form:label></td>
        <td><form:textarea path="signature"/></td>
    </tr>
    <tr>
        <td>
            <form:button value="submit">Update</form:button>
        </td>
        <td><input type="reset" value="cancel"></td>
    </tr>
</table>
</form:form>
</body>
</html>
