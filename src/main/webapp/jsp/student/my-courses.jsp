<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>My Courses</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css">
</head>
<body>
<jsp:include page="/jsp/common/navbar.jspf" />
<div class="container py-4">
    <h3 class="mb-4">My Courses</h3>
    <c:choose>
        <c:when test="${empty requestScope.courses}">
            <div class="alert alert-info">You are not registered in any courses yet.</div>
        </c:when>
        <c:otherwise>
            <div class="row row-cols-1 row-cols-md-2 g-3">
                <c:forEach var="c" items="${requestScope.courses}">
                    <div class="col">
                        <div class="card h-100">
                            <div class="card-body">
                                <h5 class="card-title">${c.title}</h5>
                                <p class="card-text">${c.description}</p>
                            </div>
                        </div>
                    </div>
                </c:forEach>
            </div>
        </c:otherwise>
    </c:choose>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>

