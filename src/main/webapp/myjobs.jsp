<%--
  Created by IntelliJ IDEA.
  User: matth
  Date: 5/1/2024
  Time: 8:22 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import ="models.JobModel" %>
<!DOCTYPE html>
<html>
<head>
    <title>Applied Jobs</title>
    <link rel="stylesheet" href="styles.css">
</head>
<body>
<h1>Applied Jobs</h1>
<table>
    <thead>
    <tr>
        <th>Title</th>
        <th>Description</th>
        <th>Salary</th>
    </tr>
    </thead>
    <tbody>
    <!-- this pulls the list of appliedJobs based on our JobModel (which references our JobApplicationServlet, where
    we designate from our alljobs.jsp page on if a job is applied to or not (button click changes the userID mapping
    in the database from 0 to 1, which indicates it IS applied for, and therefore should appear here)-->
    <c:forEach var="job" items="${appliedJobs}">
        <tr>
            <td>${job.title}</td>
            <td>${job.description}</td>
            <td>${job.salary}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
