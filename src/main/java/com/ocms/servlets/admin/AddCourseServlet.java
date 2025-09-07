package com.ocms.servlets.admin;

import com.ocms.dao.CourseDao;
import com.ocms.models.Course;
import org.bson.types.ObjectId;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AddCourseServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String title = req.getParameter("title");
        String description = req.getParameter("description");
        CourseDao courseDao = new CourseDao();
        Course course = new Course(null, title, description, null);
        ObjectId id = courseDao.insert(course);
        resp.sendRedirect(req.getContextPath() + "/jsp/admin/dashboard.jsp?added=" + id);
    }
}

