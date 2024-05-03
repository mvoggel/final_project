<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Signup</title>
    <link rel="stylesheet" href="styles.css">
</head>
<body>
<h1>Signup</h1>
<form action="SignUpServlet" method="POST">
    <label for="username">Username:</label>
    <input type="text" id="username" name="username"><br>

    <label for="password">Password:</label>
    <input type="password" id="password" name="password"><br>

    <input type="submit" value="Signup">
</form>
</body>
</html>
