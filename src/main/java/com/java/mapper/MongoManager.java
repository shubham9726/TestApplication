/*
package com.java.mapper;

import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.datatype.joda.JodaModule;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.java.configuration.AppConfiguration;
import com.java.db.MongoDb;
import com.mongodb.*;
import io.dropwizard.lifecycle.Managed;
import org.jongo.Jongo;
import org.jongo.MongoCollection;
import org.jongo.marshall.jackson.JacksonMapper;

@Singleton
public class MongoManager implements MongoDb, Managed {

  private AppConfiguration appConfiguration;
  private static MongoClientURI mongoClientURI;
  private static Jongo jongo;
  private static MongoClient mongoClient;

  @Inject
  public MongoManager(AppConfiguration appConfiguration) {
    this.appConfiguration = appConfiguration;
  }

  @Override
  public MongoCollection getMongoCollection(String collectionName) throws Exception {
//         start();
//         MongoDatabase mongoDb=  mongoClient.getDB(mongoClientURI.getDatabase());
//        return mongoDb.getMongoCollection(collectionName);
    start();
    return jongo.getCollection(collectionName);
  }

  @Override
  public DBCollection getDbCollection(String collectionName) {
    try {
      start();
    } catch (Exception e){
      throw new RuntimeException("collection name Not found");
    }
    DB db = mongoClient.getDB(mongoClientURI.getDatabase());
    return db.getCollection(collectionName);
  }

  @Override
  public Jongo getJongo() throws Exception {
    start();
    return jongo;
  }

  @Override
  public DB getDB() throws Exception {
    start();
    return mongoClient.getDB(mongoClientURI.getDatabase());
  }

  @Override
  public void start() throws Exception {
    if (mongoClient != null) return;
    //   LOG.info("Starting MongoManager");

    String mongoUri = appConfiguration.mongoConfiguration.getUri();
    mongoClientURI = new MongoClientURI(mongoUri);
    mongoClient = new MongoClient(mongoClientURI);

    DB db = mongoClient.getDB(mongoClientURI.getDatabase());
    db.setWriteConcern(WriteConcern.ACKNOWLEDGED);
    jongo = new Jongo(db,
      new JacksonMapper.Builder()
        .registerModule(new JodaModule())
        .enable(MapperFeature.AUTO_DETECT_GETTERS)
        .build());
  }

  @Override
  public void stop() throws Exception {
    if (mongoClient != null) {
      mongoClient.close();
      mongoClient = null;
    }
  }
}

nnnnnnnnnnnnnnnnnnnn
*/
