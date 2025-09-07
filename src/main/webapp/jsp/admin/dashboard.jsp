<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Admin Dashboard</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css">
</head>
<body>
<jsp:include page="/jsp/common/navbar.jspf" />
<div class="container py-4">
    <h3 class="mb-4">Admin Dashboard</h3>

    <div class="row">
        <div class="col-md-6">
            <div class="card mb-4">
                <div class="card-header">Add New Course</div>
                <div class="card-body">
                    <form method="post" action="${pageContext.request.contextPath}/admin/add-course">
                        <div class="mb-3">
                            <label class="form-label">Title</label>
                            <input name="title" class="form-control" required />
                        </div>
                        <div class="mb-3">
                            <label class="form-label">Description</label>
                            <textarea name="description" class="form-control" rows="3"></textarea>
                        </div>
                        <button class="btn btn-primary" type="submit">Add Course</button>
                    </form>
                </div>
            </div>
        </div>

        <div class="col-md-6">
            <div class="card mb-4">
                <div class="card-header">Assign Teacher to Course</div>
                <div class="card-body">
                    <form method="post" action="${pageContext.request.contextPath}/admin/assign-teacher">
                        <div class="mb-3">
                            <label class="form-label">Course ID</label>
                            <input name="courseId" class="form-control" placeholder="ObjectId of course" required />
                        </div>
                        <div class="mb-3">
                            <label class="form-label">Teacher ID</label>
                            <input name="teacherId" class="form-control" placeholder="ObjectId of teacher" required />
                        </div>
                        <button class="btn btn-secondary" type="submit">Assign</button>
                    </form>
                    <div class="form-text">In a real app, these would be dropdowns. For simplicity, use IDs.</div>
                </div>
            </div>
        </div>
    </div>
    <c:if test="${param.added != null}">
        <div class="alert alert-success">Course added successfully.</div>
    </c:if>
    <c:if test="${param.assigned != null}">
        <div class="alert alert-success">Teacher assigned successfully.</div>
    </c:if>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>

