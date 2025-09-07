package com.ocms.dao;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.ocms.config.MongoConnection;
import com.ocms.models.Enrollment;
import org.bson.Document;
import org.bson.types.ObjectId;

import java.util.ArrayList;
import java.util.List;

import static com.mongodb.client.model.Filters.and;
import static com.mongodb.client.model.Filters.eq;

public class EnrollmentDao {
    private final MongoCollection<Document> enrollments;

    public EnrollmentDao() {
        MongoDatabase db = MongoConnection.getDatabase();
        this.enrollments = db.getCollection("enrollments");
    }

    public ObjectId insert(Enrollment enrollment) {
        Document doc = new Document()
                .append("studentId", enrollment.getStudentId())
                .append("courseId", enrollment.getCourseId());
        enrollments.insertOne(doc);
        return doc.getObjectId("_id");
    }

    public boolean exists(ObjectId studentId, ObjectId courseId) {
        return enrollments.find(and(eq("studentId", studentId), eq("courseId", courseId))).first() != null;
    }

    public List<Enrollment> findByStudent(ObjectId studentId) {
        List<Enrollment> list = new ArrayList<>();
        for (Document d : enrollments.find(eq("studentId", studentId))) {
            list.add(fromDoc(d));
        }
        return list;
    }

    public List<Enrollment> findByCourse(ObjectId courseId) {
        List<Enrollment> list = new ArrayList<>();
        for (Document d : enrollments.find(eq("courseId", courseId))) {
            list.add(fromDoc(d));
        }
        return list;
    }

    private Enrollment fromDoc(Document d) {
        return new Enrollment(
                d.getObjectId("_id"),
                d.get("studentId", ObjectId.class),
                d.get("courseId", ObjectId.class)
        );
    }
}

