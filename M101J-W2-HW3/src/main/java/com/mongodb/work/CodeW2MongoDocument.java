package com.mongodb.work;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.ServerAddress;
import com.mongodb.helper.Helpers;
import org.bson.Document;
import org.bson.types.ObjectId;

import java.util.Arrays;
import java.util.Date;

public class CodeW2MongoDocument {

    public static void main(String[] args) {
        //MongoClient mongoClient = new MongoClient(new MongoClientURI("mongodb://localhost:27017"));
        //new MongoClient(new ServerAddress("localhost",27017));
        //new MongoClient(new MongoClientURI("mongodb://localhost:27017"));

        MongoClientOptions options = new MongoClientOptions.Builder().connectionsPerHost(100).build();
        MongoClient mongoClient = new MongoClient(new ServerAddress(), options);


        Document document = new Document()
                .append("str", "Hello, Mongo World")
                .append("int", 12)
                .append("l", 14L)
                .append("double", 1.1)
                .append("b", false)
                .append("date", new Date())
                .append("objectId", new ObjectId())
                .append("null", null)
                .append("embeddedDoc", new Document("x", 0))
                .append("list", Arrays.asList("list1", "list2", 3));

        String str = document.getString("str");
        int i = document.getInteger("int");

        Helpers.printJson(document);


    }
}
