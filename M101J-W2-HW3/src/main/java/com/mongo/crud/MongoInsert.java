package com.mongo.crud;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.util.Arrays;

import static com.mongodb.helper.Helpers.printJson;

public class MongoInsert {

    public static void main(String[] args) {
        MongoClient mongoClient = new MongoClient();
        MongoDatabase database = mongoClient.getDatabase("course");
        MongoCollection<Document> collection = database.getCollection("insertTest");

        collection.drop();

        Document smith = new Document("name", "Smith").append("age", 30).append("profession", "developer");

        Document jones = new Document("name", "jones").append("age", 25).append("profession", "analyst");


        //collection.insertOne(smith);
        collection.insertMany(Arrays.asList(smith, jones));
        printJson(smith);
        printJson(jones);

    }
}
