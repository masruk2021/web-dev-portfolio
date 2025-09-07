package com.ocms.servlets;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.ocms.config.MongoConnection;
import com.ocms.dao.CourseDao;
import com.ocms.dao.UserDao;
import com.ocms.models.Course;
import com.ocms.models.Role;
import com.ocms.models.User;
import org.bson.Document;
import org.bson.types.ObjectId;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SeedServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        MongoDatabase db = MongoConnection.getDatabase();
        MongoCollection<Document> users = db.getCollection("users");
        MongoCollection<Document> courses = db.getCollection("courses");
        MongoCollection<Document> enrollments = db.getCollection("enrollments");

        users.drop();
        courses.drop();
        enrollments.drop();

        UserDao userDao = new UserDao();
        CourseDao courseDao = new CourseDao();

        ObjectId adminId = userDao.insert(new User(null, "admin", "admin123", Role.ADMIN));
        ObjectId teacherId = userDao.insert(new User(null, "teacher1", "teach123", Role.TEACHER));
        ObjectId studentId = userDao.insert(new User(null, "student1", "stud123", Role.STUDENT));

        ObjectId courseA = courseDao.insert(new Course(null, "Intro to Java", "Basics of Java programming", teacherId));
        ObjectId courseB = courseDao.insert(new Course(null, "Web Development", "HTML, CSS, JS essentials", null));

        resp.sendRedirect(req.getContextPath() + "/jsp/seed.jsp?ok=1");
    }
}

