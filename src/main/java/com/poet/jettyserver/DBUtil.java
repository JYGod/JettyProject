package com.poet.jettyserver;


import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

public class DBUtil {

    public static MongoCollection getCollection(){
        MongoClient mongoClient = new MongoClient("localhost", 27017);
        MongoDatabase mongoDatabase = mongoClient.getDatabase("jy");
        MongoCollection<Document> collection = mongoDatabase.getCollection("user");
        return collection;
    }
}
