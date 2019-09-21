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


/*package com.java.db;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import org.jongo.Command;
import org.jongo.Mapper;
import org.jongo.MongoCollection;
import org.jongo.bson.BsonDBDecoder;
import org.jongo.bson.BsonDBEncoder;
import org.jongo.marshall.jackson.JacksonMapper.Builder;
import org.jongo.query.Query;

public class MongoDb {
  private final DB database;
  private final Mapper mapper;

  public MongoDb(DB database) {
    this(database, Builder.jacksonMapper().build());
  }

  public MongoDb(DB database, Mapper mapper) {
    this.database = database;
    this.mapper = mapper;
  }

  public MongoCollection getCollection(String name) {
    DBCollection dbCollection = this.database.getCollection(name);
    dbCollection.setDBDecoderFactory(BsonDBDecoder.FACTORY);
    dbCollection.setDBEncoderFactory(BsonDBEncoder.FACTORY);
    dbCollection.setReadConcern(this.database.getReadConcern());
    return new MongoCollection(dbCollection, this.mapper);
  }

  public DB getDatabase() {
    return this.database;
  }

  public Mapper getMapper() {
    return this.mapper;
  }

  public Query createQuery(String query, Object... parameters) {
    return this.mapper.getQueryFactory().createQuery(query, parameters);
  }

  public Command runCommand(String query) {
    return this.runCommand(query);
  }

  public Command runCommand(String query, Object... parameters) {
    return new Command(this.database, this.mapper.getUnmarshaller(), this.mapper.getQueryFactory(), query, parameters);
  }
}*/
