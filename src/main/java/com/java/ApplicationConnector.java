/*
package com.java;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.java.configuration.AppConfiguration;
import com.java.db.MongoDb;
import com.java.mapper.MongoManager;
import com.java.repository.EmployeeRepository;
import com.java.repository.impl.EmployeeRepositoryImpl;
import com.java.service.EmployeeService;
import com.java.service.impl.EmployeeServiceImpl;

import javax.annotation.PostConstruct;

public class ApplicationConnector extends AbstractModule {
  static MongoManager mongoManager;

  @PostConstruct
  @Override
  protected void configure() {
    bind(EmployeeService.class).to(EmployeeServiceImpl.class);
    bind(EmployeeRepository.class).to(EmployeeRepositoryImpl.class);
  }
  @Provides
  private synchronized MongoDb getMongoManagement(AppConfiguration configuration){
    if(mongoManager == null){
      mongoManager = new MongoManager(configuration);
    }
    return mongoManager;
  }
}
*/
