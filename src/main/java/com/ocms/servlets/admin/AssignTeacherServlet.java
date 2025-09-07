package com.ocms.servlets.admin;

import com.ocms.dao.CourseDao;
import org.bson.types.ObjectId;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AssignTeacherServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String courseId = req.getParameter("courseId");
        String teacherId = req.getParameter("teacherId");
        CourseDao dao = new CourseDao();
        dao.assignTeacher(new ObjectId(courseId), new ObjectId(teacherId));
        resp.sendRedirect(req.getContextPath() + "/jsp/admin/dashboard.jsp?assigned=1");
    }
}

