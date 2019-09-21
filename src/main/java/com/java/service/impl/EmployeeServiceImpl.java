package com.java.service.impl;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.java.domain.Employee;
import com.java.repository.EmployeeRepository;
import com.java.service.EmployeeService;

import java.util.List;

@Singleton
public class EmployeeServiceImpl implements EmployeeService {

  EmployeeRepository employeeRepository;

  @Inject
  public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
    this.employeeRepository = employeeRepository;
  }

  /*@PostConstruct
  @Override
  protected void configure() {
  }*/

  /*final MongoCollection<Document> collection;
  public EmployeeServiceImpl(MongoCollection<Document> collection) {
    this.collection = collection;
  }*/

  public void insertOne(Employee employee) {
    employeeRepository.save(employee);
    /*final Document saveEmployee =new Document("name", employee.getName())
      .append("address", employee.getAddress())
      .append("employeeId", employee.getEmployeeId());
    collection.insertOne(saveEmployee);*/
  }

  public List<Employee> getAll() {
    return employeeRepository.getAll();
  }


   /* final MongoCursor<Document> employees = collection.find().iterator();
    final List<Employee> employeesFind = new ArrayList<>();
    try {
      while (employees.hasNext()) {
        final Document employee = employees.next();
        employeesFind.add(EmployeeMapper.map(employee));
      }
    } finally {
      employees.close();
    }
    return employeesFind;*/
  /*}*/

  /*public Employee getOne(String name) {
    final Optional<Document> employeeFind = Optional.ofNullable(collection.find(new Document("name", name)).first());
    return employeeFind.isPresent() ? EmployeeMapper.map(employeeFind.get()) : null;
  }

  public void update(String name, Employee employee) {
    collection.updateOne(new Document("name", name),
      new Document("$set", new Document("address", employee.getAddress())
        .append("employeeId", employee.getEmployeeId()))
    );
  }

  public void delete(String name) {
    collection.deleteOne(new Document("name", name));
  }*/
}
