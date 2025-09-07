package com.ocms.servlets.auth;

import com.ocms.dao.UserDao;
import com.ocms.models.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        UserDao userDao = new UserDao();
        User user = userDao.findByUsername(username);
        if (user != null && user.getPassword().equals(password)) {
            HttpSession session = req.getSession(true);
            session.setAttribute("user", user);
            session.setAttribute("role", user.getRole().name());
            switch (user.getRole()) {
                case ADMIN:
                    resp.sendRedirect(req.getContextPath() + "/jsp/admin/dashboard.jsp");
                    return;
                case TEACHER:
                    resp.sendRedirect(req.getContextPath() + "/jsp/teacher/dashboard.jsp");
                    return;
                case STUDENT:
                    resp.sendRedirect(req.getContextPath() + "/jsp/student/dashboard.jsp");
                    return;
            }
        }
        req.setAttribute("error", "Invalid username or password");
        req.getRequestDispatcher("/index.jsp").forward(req, resp);
    }
}

