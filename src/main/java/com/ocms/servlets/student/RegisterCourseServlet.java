package com.ocms.servlets.student;

import com.ocms.dao.EnrollmentDao;
import com.ocms.models.Enrollment;
import com.ocms.models.User;
import org.bson.types.ObjectId;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class RegisterCourseServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String courseId = req.getParameter("courseId");
        HttpSession session = req.getSession(false);
        User user = (User) session.getAttribute("user");
        ObjectId studentId = user.getId();
        EnrollmentDao dao = new EnrollmentDao();
        ObjectId courseObjectId = new ObjectId(courseId);
        if (!dao.exists(studentId, courseObjectId)) {
            dao.insert(new Enrollment(null, studentId, courseObjectId));
        }
        resp.sendRedirect(req.getContextPath() + "/jsp/student/dashboard.jsp?registered=1");
    }
}

