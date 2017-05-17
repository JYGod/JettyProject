package com.poet.jettyserver;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;

@Path("/")
public class ConnMongoDB {


        @GET
        @Produces({"text/html"})
        public String index(){
            return "OK";
        }

        @GET
        @Path("/mongodb")
        @Produces(MediaType.TEXT_HTML)
        public String mongodb(){
            MongoClient mongoClient = new MongoClient("localhost", 27017);
            MongoDatabase mongoDatabase = mongoClient.getDatabase("bbddb");
            MongoCollection<Document> collection = mongoDatabase.getCollection("users");
            Document document = new Document("title", "MongoDB");
            List<Document> documents = new ArrayList<Document>();
            documents.add(document);

            collection.insertMany(documents);
            return document.toString();
        }



}
