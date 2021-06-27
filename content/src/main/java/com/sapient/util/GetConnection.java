package com.sapient.util;


import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;

import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;

/**
 * @Author: Aarsh Verdhan
 */
public class GetConnection {

public static MongoCollection getCollectionFromDatabase(String dbName, String collection, Class clss){
    CodecRegistry pojoCodecRegistry = fromRegistries(MongoClientSettings.getDefaultCodecRegistry(),
            fromProviders(PojoCodecProvider.builder().automatic(true).build()));
    ConnectionString connectionString = new ConnectionString("mongodb+srv://aarsh:aarsh@cluster0.urdbc.mongodb.net/myFirstDatabase?retryWrites=true&w=majority");
    MongoClientSettings settings = MongoClientSettings.builder().codecRegistry(pojoCodecRegistry).applyConnectionString(connectionString)
            .build();
    MongoClient mongoClient = MongoClients.create(settings);
    MongoDatabase db = mongoClient.getDatabase("test");
    return db.getCollection(collection , clss);
}

/*
    public static MongoCollection getCollectionFromDatabase(String dbName, String collection, Class clss ){
        MongoDatabase db = getMongoConnection(27017, "localhost").getDatabase(dbName);
        return db.getCollection(collection , clss);

    }

    public static MongoClient getMongoConnection(int port, String host ){
        CodecRegistry pojoCodecRegistry = fromRegistries(MongoClientSettings.getDefaultCodecRegistry(),
                fromProviders(PojoCodecProvider.builder().automatic(true).build()));
        return MongoClients.create(

                MongoClientSettings.builder().codecRegistry(pojoCodecRegistry).applyToClusterSettings(builder -> builder.hosts((Arrays.asList(new ServerAddress(host,port))))).build()
        );


    }
    public static MongoClient mongoUtilCodecRegistry() {
        CodecRegistry pojoCodecRegistry = fromRegistries(MongoClientSettings.getDefaultCodecRegistry(),
                fromProviders(PojoCodecProvider.builder().automatic(true).build()));

        MongoClientSettings settings = MongoClientSettings.builder()
                .codecRegistry(pojoCodecRegistry)
                .build();

        return MongoClients.create(settings);
    }

*/
}
