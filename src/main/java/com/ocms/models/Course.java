package com.ocms.models;

import org.bson.types.ObjectId;

public class Course {
    private ObjectId id;
    private String title;
    private String description;
    private ObjectId teacherId; // nullable until assigned

    public Course() {}

    public Course(ObjectId id, String title, String description, ObjectId teacherId) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.teacherId = teacherId;
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ObjectId getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(ObjectId teacherId) {
        this.teacherId = teacherId;
    }

    public String getIdHex() {
        return id != null ? id.toHexString() : null;
    }
}

