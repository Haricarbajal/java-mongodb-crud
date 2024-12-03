package org.example;

import com.mongodb.Mongo;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.text.CollationElementIterator;
import java.util.Collection;

public class Read {

    public Read(){}

    public void ListAll(MongoCollection<Document> collections){
        for(Document user : collections.find()){
            System.out.println(user.toJson());
        }
    }

    public void ListUser(MongoCollection<Document> collectios, String name){
        Document filter = new Document("name", name);
        for(Document user : collectios.find(filter)){
            System.out.println(user.toJson());
        }
    }
}
