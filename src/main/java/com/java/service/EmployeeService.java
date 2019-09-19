package com.java.service;

import com.java.domain.Employee;

import java.util.List;


public interface EmployeeService  {
  void insertOne(Employee employee);

  List<Employee> getAll();
}
