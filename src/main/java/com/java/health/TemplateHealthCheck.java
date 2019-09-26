/*
package com.java.health;

import com.codahale.metrics.health.HealthCheck;
nnnnnn
public class TemplateHealthCheck extends HealthCheck {
*/

  /*private MongoClient mongoClient;

  public TemplateHealthCheck(MongoClient mongoClient) {
    this.mongoClient = mongoClient;
  }

  @Override
  protected Result check() throws Exception {
    List<String> dbs = new ArrayList<>();
    for (String s : mongoClient.listDatabaseNames()) {
      dbs.add(s);
    }
    if (dbs.size() > 0) {
      return Result.healthy("Database names in MongogDB are: " + dbs);
    }
    return Result.unhealthy("DropwizardMongoDB Service is down");
  }*/
 /* private final String template;

  public TemplateHealthCheck(String template) {
    this.template = template;
  }
  nnnnnnnnnnnnn
  @Override
  protected Result check() throws Exception {

    final String saying = String.format(template, "TEST");
    if (!saying.contains("TEST")) {
      return Result.unhealthy("template doesn't include a name");
    }
    return Result.healthy();
  }
}*/
