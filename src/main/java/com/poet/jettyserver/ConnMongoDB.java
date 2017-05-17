package com.poet.jettyserver;

import com.google.gson.Gson;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
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
        @Path("/selectAllUser")
        @Produces(MediaType.TEXT_HTML)
        public String selectAllUser(){
            MongoCollection collection=DBUtil.getCollection();
            FindIterable findIterable = collection.find();
            MongoCursor cursor = findIterable.iterator();
            ArrayList<Object>documents=new ArrayList<Object>();
            while (cursor.hasNext()){
               documents.add(cursor.next());
            }
            Gson gson=new Gson();
            String resJson= gson.toJson(documents,documents.getClass());
            return resJson;

        }

        @GET
        @Path("/mongodb")
        @Produces(MediaType.TEXT_HTML)
        public String mongodb(){
            MongoCollection collection=DBUtil.getCollection();
            Document document = new Document("name", "mq");
            Document document1 = new Document("name", "lc");
            List<Document> documents = new ArrayList<Document>();
            documents.add(document);
            documents.add(document1);
            collection.insertMany(documents);
            return document.toString();
        }



}
