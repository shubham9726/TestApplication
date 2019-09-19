package com.java.domain;

import com.java.api.BaseModel;

import java.util.Objects;

public class Employee extends BaseModel {

  private String name;
  private String address;
  private String employeeId;
/*
  public Employee() {
  }
   public Employee(String name,String address, String employeeId){
    this.name = name;
    this.address = address;
    this.employeeId = employeeId;
   }*/


  @Override
  public boolean equals(final Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    final Employee employee = (Employee) o;
    return Objects.equals(name, employee.name)  &&
            Objects.equals(address, employee.address) &&
            Objects.equals(employeeId, employee.employeeId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, address, employeeId);
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public String getEmployeeId() {
    return employeeId;
  }

  public void setEmployeeId(String employeeId) {
    this.employeeId = employeeId;
  }

  /*@Override
  public Object getOrDefault(Object key, Object defaultValue) {
    return null;
  }*/
  @Override
  public String toString() {
    return "Employee{"
            + "name=" + name
            + ", address=" + address
            + ", employeeId='" + employeeId + '\''
            + '}';
  }
}