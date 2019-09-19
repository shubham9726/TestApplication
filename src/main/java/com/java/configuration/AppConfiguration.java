package com.java.configuration;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.Configuration;

import javax.validation.Valid;

public class AppConfiguration extends Configuration {
  @Valid
  @JsonProperty("mongoserver")
  public MongoConfiguration mongoConfiguration;

  public MongoConfiguration getMongoConfiguration() {
    return mongoConfiguration;
  }

  public void setMongoConfiguration(MongoConfiguration mongoConfiguration) {
    this.mongoConfiguration = mongoConfiguration;
  }

}
