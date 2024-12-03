package org.example;

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
}
