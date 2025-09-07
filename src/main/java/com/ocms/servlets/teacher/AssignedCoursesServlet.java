package com.ocms.servlets.teacher;

import com.ocms.dao.CourseDao;
import com.ocms.models.Course;
import com.ocms.models.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class AssignedCoursesServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        User user = (User) session.getAttribute("user");
        CourseDao courseDao = new CourseDao();
        List<Course> courses = courseDao.findByTeacher(user.getId());
        req.setAttribute("courses", courses);
        req.getRequestDispatcher("/jsp/teacher/assigned-courses.jsp").forward(req, resp);
    }
}

