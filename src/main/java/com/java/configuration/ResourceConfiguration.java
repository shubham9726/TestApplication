package com.java.configuration;

import org.glassfish.jersey.server.ResourceConfig;

public class ResourceConfiguration extends ResourceConfig {

  public ResourceConfiguration() {
    packages("com.java");
  }
}
