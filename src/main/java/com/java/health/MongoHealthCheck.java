package com.java.health;

import com.codahale.metrics.health.HealthCheck;
import com.hubspot.dropwizard.guice.InjectableHealthCheck;
import com.mongodb.Mongo;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class MongoHealthCheck extends InjectableHealthCheck {

    private final Mongo mongo;

    @Inject
    public MongoHealthCheck(Mongo mongo) {
        this.mongo = mongo;
    }

    @Override
    protected HealthCheck.Result check() throws Exception {
        mongo.getDatabaseNames();
        return HealthCheck.Result.healthy();
    }

    @Override
    public String getName() {
        return "mongo";
    }

}
