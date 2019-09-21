package com.java;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.google.inject.AbstractModule;
import com.google.inject.Module;
import com.java.configuration.AppConfiguration;
import com.java.configuration.ResourceConfiguration;
import com.java.mapper.ConnectionMapper;
import com.java.repository.impl.EmployeeRepositoryImpl;
import com.java.resources.EmployeeResource;
import com.java.service.impl.EmployeeServiceImpl;
import com.roskart.dropwizard.jaxws.JAXWSBundle;
import io.dropwizard.Application;
import io.dropwizard.server.AbstractServerFactory;
import io.dropwizard.server.DefaultServerFactory;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import org.glassfish.jersey.server.ResourceConfig;
import org.reflections.Reflections;
import org.reflections.util.ConfigurationBuilder;
import ru.vyarus.dropwizard.guice.GuiceBundle;
import org.glassfish.jersey.media.multipart.MultiPartFeature;
import ru.vyarus.dropwizard.guice.module.installer.feature.LifeCycleInstaller;
import ru.vyarus.dropwizard.guice.module.installer.feature.ManagedInstaller;
import ru.vyarus.dropwizard.guice.module.installer.feature.TaskInstaller;
import ru.vyarus.dropwizard.guice.module.installer.feature.eager.EagerSingletonInstaller;
import ru.vyarus.dropwizard.guice.module.installer.feature.health.HealthCheckInstaller;
import ru.vyarus.dropwizard.guice.module.installer.feature.jersey.JerseyFeatureInstaller;
import ru.vyarus.dropwizard.guice.module.installer.feature.jersey.ResourceInstaller;
import ru.vyarus.dropwizard.guice.module.installer.feature.jersey.provider.JerseyProviderInstaller;
import ru.vyarus.dropwizard.guice.module.installer.feature.plugin.PluginInstaller;

import javax.ws.rs.ext.ExceptionMapper;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

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
  /*bootstrap.getObjectMapper().enable(DeserializationFeature.READ_ENUMS_USING_TO_STRING);
    bootstrap.addBundle(GuiceBundle.<AppConfiguration>builder()
      .enableAutoConfig("com.java")
      .build()
    );*/

    bootstrap.getObjectMapper().registerSubtypes(DefaultServerFactory.class);
    /*bootstrap.getObjectMapper().enable(DeserializationFeature.READ_ENUMS_USING_TO_STRING);
    bootstrap.addBundle(jaxwsBundle);
    Module[] modules = autoDiscoverModules();
    GuiceBundle.Builder builder = GuiceBundle.builder()
//               .modules(new ApplicationConnector())
      .modules(modules)
       .noDefaultInstallers()
      .installers(new Class[]{LifeCycleInstaller.class,
        ManagedInstaller.class,
        JerseyFeatureInstaller.class, ResourceInstaller.class,
        JerseyProviderInstaller.class,
        EagerSingletonInstaller.class,
        HealthCheckInstaller.class,
        TaskInstaller.class,
        PluginInstaller.class
      })*/
    bootstrap.getObjectMapper().enable(DeserializationFeature.READ_ENUMS_USING_TO_STRING);
    bootstrap.addBundle(jaxwsBundle);
    Module[] modules = autoDiscoverModules();
    GuiceBundle.Builder builder = GuiceBundle.builder()
      .modules(modules)
      .noDefaultInstallers()
      .installers(new Class[]{
        LifeCycleInstaller.class,
        ManagedInstaller.class,
        JerseyFeatureInstaller.class,
        ResourceInstaller.class,
        JerseyProviderInstaller.class,
        EagerSingletonInstaller.class,
        HealthCheckInstaller.class,
        TaskInstaller.class,
        PluginInstaller.class,
        ApplicationConnector.class
      })
      .enableAutoConfig(ApplicationConnector.class.getPackage().getName());
    postInitialize(bootstrap, builder);
    guiceBundle = builder.build();
    bootstrap.addBundle(guiceBundle);
  }

  @Override
  public void run(AppConfiguration configuration, Environment environment) throws Exception {
    AbstractServerFactory sf = (AbstractServerFactory) configuration.getServerFactory();
    sf.setRegisterDefaultExceptionMappers(false);
    environment.jersey().register(MultiPartFeature.class);
    environment.jersey().register(new ResourceInstaller());
    environment.jersey().register(new ConnectionMapper());
    environment.jersey().getResourceConfig().register(ResourceConfiguration.class);
    environment.jersey().register(EmployeeServiceImpl.class);
    environment.jersey().register(EmployeeRepositoryImpl.class);
    environment.jersey().register(new ApplicationConnector());
    environment.jersey().register(EmployeeResource.class);
    postRun(configuration,environment);
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
  protected void postRun(final AppConfiguration configuration, final Environment environment) throws Exception {
    // Sub-classes should
  }

  protected void postInitialize(Bootstrap<AppConfiguration> bootstrap, GuiceBundle.Builder guiceBuilder) {
    // Sub-classes should
  }
  public Module[] autoDiscoverModules() {
    Reflections reflections =
      new Reflections(
        new ConfigurationBuilder()
          .forPackages(
            "com.java"));

    Set<Class<? extends AbstractModule>> classes = reflections.getSubTypesOf(AbstractModule.class);

    List<Module> discoveredModules = new ArrayList<>();
    for (Class clazz : classes) {
      try {
        AbstractModule module = (AbstractModule) clazz.newInstance();
        discoveredModules.add(module);
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
    return discoveredModules.toArray(new Module[]{});
  }

  private void removeDefaultExceptionMappers(boolean deleteDefault, Environment environment) {
    if (deleteDefault) {
      ResourceConfig jrConfig = environment.jersey().getResourceConfig();
      Set<Object> dwSingletons = jrConfig.getSingletons();
      List<Object> singletonsToRemove = new ArrayList<>();

      for (Object singletons : dwSingletons) {
        if (singletons instanceof ExceptionMapper && !singletons.getClass().getName().contains("DropwizardResourceConfig")) {
          singletonsToRemove.add(singletons);
        }
      }

      for (Object singletons : singletonsToRemove) {
        jrConfig.getSingletons().remove(singletons);
      }
    }
  }
}
