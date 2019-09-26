package com.java.configuration;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.java.MongoFactory;
import io.dropwizard.Configuration;

import javax.validation.Valid;

public class AppConfiguration extends Configuration {
  private MongoFactory mongoFactory = new MongoFactory();

  @JsonProperty("mongoDB")
  public MongoFactory getMongoFactory() {
    return this.mongoFactory;
  }

  @JsonProperty("mongoDB")
  public void setMongoFactory(MongoFactory mongoFactory) {
    this.mongoFactory = mongoFactory;


  /*@Valid
  @JsonProperty("mongoserver")
  public MongoConfiguration mongoConfiguration;

  public MongoConfiguration getMongoConfiguration() {
    return mongoConfiguration;
  }
nnnnnnnnnnnnnnn
  public void setMongoConfiguration(MongoConfiguration mongoConfiguration) {
    this.mongoConfiguration = mongoConfiguration;
  }
*/
  }
}
