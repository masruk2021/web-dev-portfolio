package com.ocms.servlets.student;

import com.ocms.dao.CourseDao;
import com.ocms.dao.EnrollmentDao;
import com.ocms.models.Course;
import com.ocms.models.Enrollment;
import com.ocms.models.User;
import org.bson.types.ObjectId;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MyCoursesServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        User user = (User) session.getAttribute("user");
        EnrollmentDao enrollmentDao = new EnrollmentDao();
        CourseDao courseDao = new CourseDao();
        List<Enrollment> enrollments = enrollmentDao.findByStudent(user.getId());
        List<Course> myCourses = new ArrayList<>();
        for (Enrollment e : enrollments) {
            Course c = courseDao.findById(e.getCourseId());
            if (c != null) myCourses.add(c);
        }
        req.setAttribute("courses", myCourses);
        req.getRequestDispatcher("/jsp/student/my-courses.jsp").forward(req, resp);
    }
}

