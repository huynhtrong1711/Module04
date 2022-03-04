<jsp:useBean id="users" scope="request" type="com.codegym.model.User"/>
<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 3/2/2022
  Time: 3:17 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<fieldset>
<legend><h1>Welcome</h1></legend>
<h3>Account: ${users.account}</h3>
<h3>Name: ${users.name}</h3>
<h3>Email: ${users.email}</h3>
<h3>Age: ${users.age}</h3>
</fieldset>
</body>
</html>