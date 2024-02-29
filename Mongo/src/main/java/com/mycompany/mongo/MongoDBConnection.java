/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.mycompany.mongo;

import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCursor;
import java.awt.Cursor;
import org.bson.Document;

/**
 *
 * @author josue
 */
public class MongoDBConnection {
 private MongoClient mongoClient;
    private MongoDatabase database;

    public MongoDBConnection() {
        // Establece la conexión con MongoDB
        mongoClient = MongoClients.create("mongodb://localhost:27017");
        // Selecciona la base de datos
        database = mongoClient.getDatabase("JavaMongo");
    }

    public MongoDatabase getDatabase() {
        return database;
    }

    public void closeConnection() {
        mongoClient.close();
    }
    }
    

