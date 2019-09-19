package com.java;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.java.configuration.AppConfiguration;
import com.roskart.dropwizard.jaxws.JAXWSBundle;
import io.dropwizard.Application;
import io.dropwizard.server.DefaultServerFactory;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import ru.vyarus.dropwizard.guice.GuiceBundle;
import ru.vyarus.dropwizard.guice.module.installer.feature.LifeCycleInstaller;
import ru.vyarus.dropwizard.guice.module.installer.feature.ManagedInstaller;
import ru.vyarus.dropwizard.guice.module.installer.feature.TaskInstaller;
import ru.vyarus.dropwizard.guice.module.installer.feature.eager.EagerSingletonInstaller;
import ru.vyarus.dropwizard.guice.module.installer.feature.health.HealthCheckInstaller;
import ru.vyarus.dropwizard.guice.module.installer.feature.jersey.JerseyFeatureInstaller;
import ru.vyarus.dropwizard.guice.module.installer.feature.jersey.ResourceInstaller;
import ru.vyarus.dropwizard.guice.module.installer.feature.jersey.provider.JerseyProviderInstaller;
import ru.vyarus.dropwizard.guice.module.installer.feature.plugin.PluginInstaller;

public class hellodropwizardApplication extends Application<AppConfiguration> {

  GuiceBundle<AppConfiguration> guiceBundle;
  private JAXWSBundle jaxwsBundle = new JAXWSBundle();
  public static void main(final String[] args) throws Exception {
    new hellodropwizardApplication().run(args);
  }

  @Override
  public String getName() {
    return "hellodropwizard";
  }

  /*@Override
  public void run(AppConfiguration appConfiguration, Environment environment) throws Exception {
    environment.jersey().packages("service");
  }*/

  public void initialize(final Bootstrap<AppConfiguration> bootstrap) {
    bootstrap.getObjectMapper().registerSubtypes(DefaultServerFactory.class);
    bootstrap.getObjectMapper().enable(DeserializationFeature.READ_ENUMS_USING_TO_STRING);
    bootstrap.addBundle(jaxwsBundle);
    GuiceBundle.Builder builder = GuiceBundle.builder()
               .modules(new ApplicationConnector())
       .noDefaultInstallers()
      .installers(new Class[]{LifeCycleInstaller.class,
        ManagedInstaller.class,
        JerseyFeatureInstaller.class, ResourceInstaller.class,
        JerseyProviderInstaller.class,
        EagerSingletonInstaller.class,
        HealthCheckInstaller.class,
        TaskInstaller.class,
        PluginInstaller.class
      })
      .enableAutoConfig(ApplicationConnector.class.getPackage().getName());
    guiceBundle = builder.build();
    bootstrap.addBundle(guiceBundle);
  }

  @Override
  public void run(AppConfiguration configuration, Environment environment) {
   /* MessageQueueClient messageQueue = configuration.getMessageQueueFactory().build(environment);*/
    /* MongoClient mongoClient = new MongoClient(configuration.getMongoHost(), configuration.getMongoPort());
    MongoManaged mongoManaged = new MongoManaged(mongoClient);
    environment.lifecycle().manage(mongoManaged);
    MongoDatabase db = mongoClient.getDatabase(configuration.getMongoDB());
    MongoCollection<Document> collection = db.getCollection(configuration.getCollectionName());
//    logger.info("Registering RESTful API resources");
    final EmployeeRepositoryImpl employeeService = new EmployeeRepositoryImpl(collection);
    *//*environment.jersey().register(new EmployeeResource(employeeService));*//*
 environment.healthChecks().register("TemplateHealthCheck",
      new TemplateHealthCheck(mongoClient));*/

  }
}
