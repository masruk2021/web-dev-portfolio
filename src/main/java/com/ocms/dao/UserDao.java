package com.ocms.dao;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.ocms.config.MongoConnection;
import com.ocms.models.Role;
import com.ocms.models.User;
import org.bson.Document;
import org.bson.types.ObjectId;

import static com.mongodb.client.model.Filters.eq;

public class UserDao {
    private final MongoCollection<Document> users;

    public UserDao() {
        MongoDatabase db = MongoConnection.getDatabase();
        this.users = db.getCollection("users");
    }

    public User findByUsername(String username) {
        Document doc = users.find(eq("username", username)).first();
        if (doc == null) return null;
        return fromDoc(doc);
    }

    public User findById(ObjectId id) {
        Document doc = users.find(eq("_id", id)).first();
        if (doc == null) return null;
        return fromDoc(doc);
    }

    public ObjectId insert(User user) {
        Document doc = new Document()
                .append("username", user.getUsername())
                .append("password", user.getPassword())
                .append("role", user.getRole().name());
        users.insertOne(doc);
        return doc.getObjectId("_id");
    }

    private User fromDoc(Document d) {
        return new User(
                d.getObjectId("_id"),
                d.getString("username"),
                d.getString("password"),
                Role.valueOf(d.getString("role"))
        );
    }
}

