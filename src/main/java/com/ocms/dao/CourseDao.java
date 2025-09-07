package com.ocms.dao;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.ocms.config.MongoConnection;
import com.ocms.models.Course;
import org.bson.Document;
import org.bson.types.ObjectId;

import java.util.ArrayList;
import java.util.List;

import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Updates.set;

public class CourseDao {
    private final MongoCollection<Document> courses;

    public CourseDao() {
        MongoDatabase db = MongoConnection.getDatabase();
        this.courses = db.getCollection("courses");
    }

    public ObjectId insert(Course course) {
        Document doc = new Document()
                .append("title", course.getTitle())
                .append("description", course.getDescription())
                .append("teacherId", course.getTeacherId());
        courses.insertOne(doc);
        return doc.getObjectId("_id");
    }

    public void assignTeacher(ObjectId courseId, ObjectId teacherId) {
        courses.updateOne(eq("_id", courseId), set("teacherId", teacherId));
    }

    public Course findById(ObjectId id) {
        Document d = courses.find(eq("_id", id)).first();
        if (d == null) return null;
        return fromDoc(d);
    }

    public List<Course> findAll() {
        List<Course> result = new ArrayList<>();
        FindIterable<Document> docs = courses.find();
        for (Document d : docs) {
            result.add(fromDoc(d));
        }
        return result;
    }

    public List<Course> findByTeacher(ObjectId teacherId) {
        List<Course> result = new ArrayList<>();
        for (Document d : courses.find(eq("teacherId", teacherId))) {
            result.add(fromDoc(d));
        }
        return result;
    }

    private Course fromDoc(Document d) {
        ObjectId teacherId = d.get("teacherId", ObjectId.class);
        return new Course(
                d.getObjectId("_id"),
                d.getString("title"),
                d.getString("description"),
                teacherId
        );
    }
}

