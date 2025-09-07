package com.ocms.models;

import org.bson.types.ObjectId;

public class Enrollment {
    private ObjectId id;
    private ObjectId studentId;
    private ObjectId courseId;

    public Enrollment() {}

    public Enrollment(ObjectId id, ObjectId studentId, ObjectId courseId) {
        this.id = id;
        this.studentId = studentId;
        this.courseId = courseId;
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public ObjectId getStudentId() {
        return studentId;
    }

    public void setStudentId(ObjectId studentId) {
        this.studentId = studentId;
    }

    public ObjectId getCourseId() {
        return courseId;
    }

    public void setCourseId(ObjectId courseId) {
        this.courseId = courseId;
    }
}

