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
                System.out.println("1.Create\n2.Delete\n3.Update\n4.Read\n0.Exit");
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
                        break;
                    case 2:
                        System.out.println("Que operacion deseas realizar...");
                        System.out.println("1.Eliminar la collecion por completo\n2.Eliminar un usuario");
                        int oDel = scan.nextInt();
                        System.out.println("-------------------------------------------------");
                        Delete delete = new Delete();
                        if(oDel == 1){
                            delete.revomeAll(collection);
                            break;
                        }
                        if(oDel == 2){
                            scan.nextLine();
                            System.out.println("Escribe el nombre de la persona que quieres eliminar");
                            String nombre = scan.next();
                            delete.removeUser(collection, nombre);
                            break;
                        }
                    case 4:
                        System.out.println("Que operacion deseas realizar...");
                        System.out.println("1.Listar Todos los usuarios\n2.Buscar un usuario");
                        int oList = scan.nextInt();
                        System.out.println("-------------------------------------------------");
                        Read read = new Read();
                        if(oList == 1){
                            read.ListAll(collection);
                            break;
                        }
                        if(oList == 2){
                            scan.nextLine();
                            System.out.println("Escribe el nombre del usuario que quieres buscar: ");
                            String nombre = scan.nextLine();
                            read.ListUser(collection, nombre);
                            break;
                        }
                }
            } while ( opcion != 0);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}