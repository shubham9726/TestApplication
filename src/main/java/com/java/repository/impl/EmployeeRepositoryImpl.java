package com.java.repository.impl;

import com.google.inject.Inject;
import com.java.db.MongoDb;
import com.java.domain.Employee;
import com.java.repository.EmployeeRepository;
import ru.vyarus.dropwizard.guice.module.installer.feature.jersey.HK2Managed;

@HK2Managed
public class EmployeeRepositoryImpl extends BaseRepositoryImpl<Employee> implements EmployeeRepository {

  @Inject
  public EmployeeRepositoryImpl(MongoDb mongoManager, Class<Employee> clazz) throws Exception {
    super(mongoManager, clazz);
  }
}