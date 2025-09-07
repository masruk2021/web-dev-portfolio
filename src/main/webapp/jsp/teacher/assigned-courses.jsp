<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Assigned Courses</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css">
</head>
<body>
<jsp:include page="/jsp/common/navbar.jspf" />
<div class="container py-4">
    <h3 class="mb-4">Assigned Courses</h3>
    <c:choose>
        <c:when test="${empty requestScope.courses}">
            <div class="alert alert-info">No assigned courses yet.</div>
        </c:when>
        <c:otherwise>
            <table class="table table-bordered">
                <thead>
                <tr>
                    <th>Title</th>
                    <th>Description</th>
                    <th>Students</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="c" items="${requestScope.courses}">
                    <tr>
                        <td>${c.title}</td>
                        <td>${c.description}</td>
                        <td>
                            <a class="btn btn-sm btn-outline-primary" href="${pageContext.request.contextPath}/teacher/course-students?courseId=${c.idHex}">View Students</a>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </c:otherwise>
    </c:choose>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>

