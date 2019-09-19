package com.java.resources;

import com.codahale.metrics.annotation.Timed;
import com.google.inject.Inject;
import com.java.domain.Employee;
import com.java.service.EmployeeService;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/employee")
@Produces(MediaType.APPLICATION_JSON)
@Timed
public class EmployeeResource  {


  EmployeeService employeeService;

  @Inject
  public EmployeeResource(EmployeeService employeeService) {
    this.employeeService = employeeService;
  }

 /* @PostConstruct

  @Override
  protected void configure() {
  }
*/

  @POST
  @Timed
  @Path("/createEmployee")
  @Produces(MediaType.APPLICATION_JSON)
  @Consumes(MediaType.APPLICATION_JSON)
  public Response createEmployee(@NotNull @Valid final Employee employee) {
    employeeService.insertOne(employee);
    return Response.status(Response.Status.CREATED).build();
  }

  /*@GET
  @Timed
  @Path("/findOne/{name}")
  public Response getEmployee(@PathParam("name") final String name) {
      final Employee employee = employeeService.getOne(name);
      if (employee != null) {
          return Response.ok(employee).build();
      }
      return Response.accepted(new com.java.api.Response("Employee not found.")).build();
  }*/

  @GET
  @Timed
  @Path("/getAllEmployee")
  public List<Employee> getAll() {
    return employeeService.getAll();
  /*public Response getAllEmployees() {
    final List<Employee> employeesFind = employeeService.getAll();
    return Response.ok(employeesFind).build();*/
  }



  /*@PUT
  @Timed
  @Path("/updateEmployee/{name}")
  public Response editEmployee(@PathParam("name") final String name, final Employee employee) {
    employeeService.update(name, employee);
      return Response.ok().build();
  }

  @DELETE
  @Timed
  @Path("/deleteEmployee/{name}")
  public Response deleteEmployee(@PathParam("name") final String name) {
    employeeService.delete(name);
      return Response.ok().build();
  }*/
}
