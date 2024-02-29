/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mongo;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import java.util.Arrays;
import java.util.List;
import javax.swing.JOptionPane;
import modelo.Estudiante;
import org.bson.Document;

/**
 *
 * @author josue
 */
public class ControllerMongo {
    
    public void mostrarMenu() {
        String[] opciones = {"Mostrar estudiantes", "Actualizar estudiante", "Insertar estudiante", "Eliminar estudiante", "Salir"};

        while (true) {
            // Muestra el menú y obtiene la opción seleccionada por el usuario
            String opcionSeleccionada = (String) JOptionPane.showInputDialog(null, "Seleccione una opción", "Menú",
                    JOptionPane.PLAIN_MESSAGE, null, opciones, opciones[0]);

            // Maneja la opción seleccionada por el usuario
            switch (opcionSeleccionada) {
                case "Mostrar estudiantes":
                    mostrar();
                    break;
                case "Actualizar estudiante":
                    updateOne();
                    break;
                case "Insertar estudiante":
                    insertStudent();
                    break;
                case "Eliminar estudiante":
                    deleteStudent();
                    break;
                case "Salir":
                    return;
            }
        }
    }
//En este metodo se mostraran todos los estudiantes
    public void mostrar() {
        MongoDBConnection mongoDBConnection = new MongoDBConnection();
        MongoDatabase database = mongoDBConnection.getDatabase();
        // Obtén la colección deseada
        MongoCollection<Document> collection = database.getCollection("Estudiante");
        // Realiza una consulta para obtener todos los documentos en la colección
        FindIterable<Document> documents = collection.find();
        MongoCursor<Document> cursor = documents.iterator();
        while (cursor.hasNext()) {
            Document document = cursor.next();
            System.out.println(document.toJson());
        }
        // Cierra la conexión con MongoDB
        mongoDBConnection.closeConnection();

    }
//En este metodo se actualizara los datos del estudiante
    public void updateOne() {
    String studentName = JOptionPane.showInputDialog("Ingrese el nombre del estudiante que desea actualizar:");
    if (studentName != null && !studentName.isEmpty()) {
        String newStudentName = JOptionPane.showInputDialog("Ingrese el nuevo nombre del estudiante:");
        int newStudentAge = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la nueva edad del estudiante:"));
        String newStudentCarrer = JOptionPane.showInputDialog("Ingrese la nueva carrera del estudiante:");

        MongoDBConnection mongoDBConnection = new MongoDBConnection();
        MongoDatabase database = mongoDBConnection.getDatabase();
        MongoCollection<Document> collection = database.getCollection("Estudiante");

        collection.updateOne(Filters.eq("nombre", studentName),
                             Updates.combine(Updates.set("nombre", newStudentName),
                                             Updates.set("edad", newStudentAge),
                                             Updates.set("carrera", newStudentCarrer)));

        mongoDBConnection.closeConnection();
        System.out.println("Estudiante actualizado correctamente.");
    } else {
        System.out.println("Nombre de estudiante no válido.");
    }
}

//En este metodo se insertaran los estudiantes deseados
    public void insertStudent() {
    MongoDBConnection mongoDBConnection = new MongoDBConnection();
    MongoDatabase database = mongoDBConnection.getDatabase();
    MongoCollection<Document> collection = database.getCollection("Estudiante");

    String name = JOptionPane.showInputDialog("Ingrese el nombre del estudiante:");
    int age = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la edad del estudiante:"));
    String carrer = JOptionPane.showInputDialog("Ingrese la carrera del estudiante:");

    Document studentDocument = new Document("nombre", name)
            .append("edad", age)
            .append("carrera", carrer);

    collection.insertOne(studentDocument);
    System.out.println("Estudiante insertado correctamente.");

    mongoDBConnection.closeConnection();
}
    
   
//En este metodo se eliminaran uno o todos los estudiantes, lo que el usuario desee
    public void deleteStudent() {
    String[] deleteOptions = {"Eliminar un estudiante", "Eliminar todos los estudiantes"};
    String deleteChoice = (String) JOptionPane.showInputDialog(null, "Seleccione una opción", "Eliminar Estudiante",
                    JOptionPane.PLAIN_MESSAGE, null, deleteOptions, deleteOptions[0]);

    if (deleteChoice != null) {
        MongoDBConnection mongoDBConnection = new MongoDBConnection();
        MongoDatabase database = mongoDBConnection.getDatabase();
        MongoCollection<Document> collection = database.getCollection("Estudiante");

        if (deleteChoice.equals("Eliminar un estudiante")) {
            String studentName = JOptionPane.showInputDialog("Ingrese el nombre del estudiante que desea eliminar:");
            if (studentName != null && !studentName.isEmpty()) {
                collection.deleteOne(Filters.eq("nombre", studentName));
                System.out.println("Estudiante " + studentName + " eliminado correctamente.");
            } else {
                System.out.println("Nombre de estudiante no válido.");
            }
        } else if (deleteChoice.equals("Eliminar todos los estudiantes")) {
            collection.deleteMany(new Document());
            System.out.println("Todos los estudiantes han sido eliminados.");
        }

        mongoDBConnection.closeConnection();
    }
}
    
}
