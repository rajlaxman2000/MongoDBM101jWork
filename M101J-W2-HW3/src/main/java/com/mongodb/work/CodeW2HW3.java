package com.mongodb.work;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Sorts;
import com.mongodb.helper.Helpers;
import org.bson.Document;
import org.bson.conversions.Bson;

import java.util.ArrayList;
import java.util.List;

public class CodeW2HW3 {

    public static void main(String[] args) {
        MongoClient client = new MongoClient();
        MongoDatabase database = client.getDatabase("students");
        MongoCollection<Document> collection = database.getCollection("grades");

        //Bson filter = Filters.and(filters);
        Bson filter = Filters.eq("type", "homework");
        Bson sort = Sorts.ascending("student_id", "score");

        //Bson projection = Projections.excludeId();
        //List<Document> all = collection.find().projection(projection).sort(sort).into(new ArrayList<Document>());

        List<Document> all = collection.find().filter(filter).sort(sort).into(new ArrayList<Document>());

        int old_id = 10000;

        for (Document cur : all) {
            int std_id = cur.getInteger("student_id");
            if (old_id != std_id) {
                collection.deleteOne(Filters.eq("_id", cur.get("_id")));
                //System.out.println("Delete this entry");
                //System.out.println(cur.get("_id"));
            }
            old_id = std_id;
            Helpers.printJson(cur);
        }

        System.out.println("Count of documnets:" + collection.count());
    }

}
