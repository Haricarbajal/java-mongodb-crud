package org.example;

import com.mongodb.client.MongoCollection;
import org.bson.Document;

import java.util.Collection;
import java.util.Scanner;



public class Create {
    static Scanner scan = new Scanner(System.in);
    User user;

    /*int edad;
    String nombre;
    String apellido;
    String email;*/

    public Create(){

        this.user = new User();

        scan.nextLine();
        System.out.println("Acontinuacion ingresaras los datos de la persona que quieres ingresar...");
        System.out.print("Nombre: ");
        String nombre = scan.nextLine();
        user.setNombre(nombre);
        System.out.print("Apellido: ");
        String apellido = scan.nextLine();
        user.setApellido(apellido);
        System.out.print("Edad: ");
        int edad = scan.nextInt();
        user.setEdad(edad);
        scan.nextLine();
        System.out.print("Email: ");
        String email = scan.nextLine();
        user.setEmail(email);
    }

    public Document Insert(){
        Document newUser = new Document("name", user.getNombre())
                .append("apellido", user.getApellido())
                .append("edad", user.getEdad())
                .append("email", user.getEmail());
        return newUser;
    }

}