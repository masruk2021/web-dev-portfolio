<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Course Students</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css">
</head>
<body>
<jsp:include page="/jsp/common/navbar.jspf" />
<div class="container py-4">
    <h3 class="mb-4">Registered Students</h3>
    <c:choose>
        <c:when test="${empty requestScope.students}">
            <div class="alert alert-info">No students registered yet.</div>
        </c:when>
        <c:otherwise>
            <ul class="list-group">
                <c:forEach var="s" items="${requestScope.students}">
                    <li class="list-group-item">${s.username}</li>
                </c:forEach>
            </ul>
        </c:otherwise>
    </c:choose>
    <a class="btn btn-link mt-3" href="${pageContext.request.contextPath}/teacher/assigned-courses">Back</a>
    
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>

