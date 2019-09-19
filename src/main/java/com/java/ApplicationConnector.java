package com.java;

import com.google.inject.AbstractModule;
import com.java.repository.EmployeeRepository;
import com.java.repository.impl.EmployeeRepositoryImpl;
import com.java.service.EmployeeService;
import com.java.service.impl.EmployeeServiceImpl;

import javax.annotation.PostConstruct;

public class ApplicationConnector extends AbstractModule {
  @PostConstruct
  @Override
  protected void configure() {
    bind(EmployeeService.class).to(EmployeeServiceImpl.class);
    bind(EmployeeRepository.class).to(EmployeeRepositoryImpl.class);
  }
}
