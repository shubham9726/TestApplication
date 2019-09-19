package com.java.repository.impl;

import com.java.db.MongoDb;
import com.java.domain.Employee;
import com.java.repository.EmployeeRepository;

import javax.inject.Singleton;

@Singleton
public class EmployeeRepositoryImpl extends BaseRepositoryImpl<Employee> implements EmployeeRepository {
  MongoDb mongoManager;
  public EmployeeRepositoryImpl(MongoDb mongoManager, Class<Employee> clazz) throws Exception {
    super(mongoManager, clazz);
  }
}
