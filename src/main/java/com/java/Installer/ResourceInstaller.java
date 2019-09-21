/*
package com.java.Installer;


import com.google.inject.Binder;
import com.google.inject.servlet.RequestScoped;

import static ru.vyarus.dropwizard.guice.module.installer.util.JerseyBinding.isHK2Managed;

public class ResourceInstaller extends ru.vyarus.dropwizard.guice.module.installer.feature.jersey.ResourceInstaller {

  @Override
  public <T> void install(final Binder binder, final Class<? extends T> type, final boolean lazy) {
    if (!isHK2Managed(type, !lazy)) {
      // force singleton
      binder.bind(type).in(RequestScoped.class);
    }
  }

}

*/
