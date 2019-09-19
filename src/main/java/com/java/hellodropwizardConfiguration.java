package com.java;

import org.glassfish.jersey.server.ResourceConfig;

public class hellodropwizardConfiguration extends ResourceConfig {

  public hellodropwizardConfiguration(){
    packages("com.java");
    register(new ApplicationConnector());
  }

  /*@JsonProperty
  @NotEmpty
  public String mongoHost;

  @JsonProperty
  @Min(1)
  @Max(65535)
  public int mongoPort;

  @JsonProperty
  @NotEmpty
  public String mongoDB;

  @JsonProperty
  @NotEmpty
  public String collectionName;

  public String getMongoHost() {
    return mongoHost;
  }

  public void setMongoHost(String mongoHost) {
    this.mongoHost = mongoHost;
  }

  public int getMongoPort() {
    return mongoPort;
  }

  public void setMongoPort(int mongoPort) {
    this.mongoPort = mongoPort;
  }

  public String getMongoDB() {
    return mongoDB;
  }

  public void setMongoDB(String mongoDB) {
    this.mongoDB = mongoDB;
  }

  public String getCollectionName() {
    return collectionName;
  }

  public void setCollectionName(String collectionName) {
    this.collectionName = collectionName;
  }*/
}
