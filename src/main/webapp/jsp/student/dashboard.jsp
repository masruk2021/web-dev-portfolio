<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Student Dashboard</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css">
</head>
<body>
<jsp:include page="/jsp/common/navbar.jspf" />
<div class="container py-4">
    <h3 class="mb-3">Student Dashboard</h3>
    <div class="row">
        <div class="col-md-6">
            <div class="card mb-4">
                <div class="card-header">Register for a Course</div>
                <div class="card-body">
                    <form method="post" action="${pageContext.request.contextPath}/student/register-course">
                        <div class="mb-3">
                            <label class="form-label">Course ID</label>
                            <input name="courseId" class="form-control" placeholder="ObjectId of course" required />
                        </div>
                        <button class="btn btn-primary" type="submit">Register</button>
                    </form>
                </div>
            </div>
        </div>
        <div class="col-md-6">
            <div class="card mb-4">
                <div class="card-header">My Courses</div>
                <div class="card-body">
                    <a href="${pageContext.request.contextPath}/student/my-courses" class="btn btn-outline-secondary">View My Courses</a>
                </div>
            </div>
        </div>
    </div>
    <c:if test="${param.registered != null}">
        <div class="alert alert-success">Registered successfully.</div>
    </c:if>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>

