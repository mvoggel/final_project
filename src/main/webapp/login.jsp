<%--
  Created by IntelliJ IDEA.
  User: matth
  Date: 5/1/2024
  Time: 8:04 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Login</title>
    <link rel="stylesheet" href="styles.css">
</head>
<body>
<h1>Login</h1>
<form action="/LoginServlet" method="post">
    <label for="username">Username:</label>
    <input type="text" id="username" name="username"><br>

    <label for="password">Password:</label>
    <input type="password" id="password" name="password"><br>

    <input type="submit" value="Login" >
</form>
</body>
</html>