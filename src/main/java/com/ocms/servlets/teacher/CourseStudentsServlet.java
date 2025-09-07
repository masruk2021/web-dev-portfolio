package com.ocms.servlets.teacher;

import com.ocms.dao.EnrollmentDao;
import com.ocms.dao.UserDao;
import com.ocms.models.Enrollment;
import com.ocms.models.User;
import org.bson.types.ObjectId;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CourseStudentsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String courseId = req.getParameter("courseId");
        EnrollmentDao enrollmentDao = new EnrollmentDao();
        UserDao userDao = new UserDao();
        List<Enrollment> enrollments = enrollmentDao.findByCourse(new ObjectId(courseId));
        List<User> students = new ArrayList<>();
        for (Enrollment e : enrollments) {
            User u = userDao.findById(e.getStudentId());
            if (u != null) students.add(u);
        }
        req.setAttribute("students", students);
        req.getRequestDispatcher("/jsp/teacher/course-students.jsp").forward(req, resp);
    }
}

