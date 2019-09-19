package com.java.db;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import org.jongo.Jongo;
import org.jongo.MongoCollection;

public interface MongoDb {
  MongoCollection getMongoCollection(String collectionName) throws Exception;
  DBCollection getDbCollection(String collectionName);
  Jongo getJongo() throws Exception;
  DB getDB() throws Exception;
}

