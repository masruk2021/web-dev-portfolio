package com.ocms.config;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;

import javax.servlet.ServletContext;

/**
 * Provides a singleton MongoClient and database accessor for the app lifecycle.
 */
public class MongoConnection {
    private static MongoClient mongoClient;
    private static String databaseName;

    public static synchronized void initialize(ServletContext context) {
        if (mongoClient != null) {
            return;
        }
        String uri = context.getInitParameter("MONGODB_URI");
        databaseName = context.getInitParameter("MONGODB_DB");
        if (uri == null || uri.isEmpty()) {
            uri = "mongodb://localhost:27017";
        }
        if (databaseName == null || databaseName.isEmpty()) {
            databaseName = "ocms";
        }
        ConnectionString connectionString = new ConnectionString(uri);
        MongoClientSettings settings = MongoClientSettings.builder()
                .applyConnectionString(connectionString)
                .build();
        mongoClient = MongoClients.create(settings);
    }

    public static MongoDatabase getDatabase() {
        if (mongoClient == null) {
            throw new IllegalStateException("MongoConnection not initialized");
        }
        return mongoClient.getDatabase(databaseName);
    }

    public static synchronized void close() {
        if (mongoClient != null) {
            mongoClient.close();
            mongoClient = null;
        }
    }
}

