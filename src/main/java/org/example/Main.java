package org.example;

import com.mongodb.*;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import javax.print.Doc;
import java.util.Collection;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        try (var mongoClient = MongoClients.create("mongodb://localhost:27017")) {
            MongoDatabase database = mongoClient.getDatabase("users_system");
            MongoCollection<Document> collection = database.getCollection("usuarios");

            boolean valor = false;
            int opcion = 0;
            do {
                scan.nextLine();
                System.out.println("Elige la operacion que deseas ralizar...\n");
                System.out.println("-------------------------------------------");
                System.out.println("1.Create\n2.Delete\n3.Update\n4.Listar Usuarios\n0.Exit");
                opcion = scan.nextInt();
                switch (opcion) {
                    case 0:
                        System.out.println("Gracias...");
                        break;
                    case 1:
                        Create create = new Create();
                        Document newUser = create.Insert();
                        collection.insertOne(newUser);
                        System.out.println("Nuevo usuario insertado correctamente");
                    case 4:
                        Read read = new Read();
                        read.ListAll(collection);
                }
            } while ( opcion != 0);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}