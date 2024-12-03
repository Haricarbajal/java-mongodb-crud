package org.example;

import com.mongodb.client.MongoCollection;
import org.bson.Document;


public class Delete {
    public Delete(){}

    public void revomeAll(MongoCollection<Document> collection){
        collection.deleteMany(new Document());
    }

    public void removeUser(MongoCollection<Document> collection, String nombre){
        Document findDocument = new Document("name", nombre);
        collection.findOneAndDelete(findDocument);
    }
}
