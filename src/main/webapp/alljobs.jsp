<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>All Jobs</title>
    <link rel="stylesheet" href="styles.css">
</head>
<body>
<h1>All Jobs</h1>


<c:choose>
    <c:when test="${empty jobsList}">
        <p>No jobs found.</p>
    </c:when>
    <c:otherwise>
        <c:forEach var="job" items="${jobsList}">
            <p> Here are all of the jobs currently listed:</p>
            <p>Title: ${job.title}</p>
            <p>Description: ${job.description}</p>
            <p>Salary: ${job.salary}</p>
            <p>Category: ${job.category}</p>
            <!-- Button to add job to myjobs.jsp page, calling our JobApplicationServlet within an onclick action with
            a hidden input type. This should take the job id from this alljobs page which pulls from our jobsList, and add it to
            myjobs.jsp-->
            <form action="JobApplicationServlet" method="post">
                <input type="hidden" name="jobId" value="${job.id}">
                <button type="submit">Add</button>
            </form>
        </c:forEach>
    </c:otherwise>
</c:choose>

</body>
</html>

