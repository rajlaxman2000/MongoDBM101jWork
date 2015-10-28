/**
 *
 */
package com.mongo.crud;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.helper.Helpers;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author rajeshQatar
 */
public class MongoRetrieve {

    /**
     * @param args
     */
    public static void main(String[] args) {
        MongoRetrieve retrieve = new MongoRetrieve();
        retrieve.approach1();
    }


    public void approach1() {
        MongoClient client = new MongoClient();
        MongoDatabase db = client.getDatabase("course");
        MongoCollection<Document> coll = db.getCollection("findWithFilterTest");

        coll.drop();

        for (int i = 0; i < 10; i++) {
            coll.insertOne(new Document()
                    .append("x", new Random().nextInt(2))
                    .append("y", new Random().nextInt(100)));
        }

        List<Document> all = coll.find().into(new ArrayList<Document>());

        for (Document doc : all) {
            Helpers.printJson(doc);
        }

        long count = coll.count();
        System.out.println("\n" + count);


    }
}
